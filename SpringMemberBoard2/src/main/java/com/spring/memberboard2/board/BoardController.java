package com.spring.memberboard2.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService; // 의존성 주입. bean객체로 설정되어 있어야함. 
	
	@RequestMapping("/boardlist.bo") 
	public String getBoardlist(Model model, @RequestParam(value="page", required=false, // 요청 파라메타를 읽어올때 page라는 파라메타를 불러옴. 
			defaultValue="1") int page) {  // 페이지를 읽어와서 int page에 저장. required=false 파라메타가 없더라도 에러를 발생시키지 않겠다. true면 파라메타가 무조건 있어야함. 
		// defaultValue="1" page라는 파라메타가 없을때 1을 저장해줌. 
		int limit=10;  // 한 페이지에 출력될 글 수. 
		
		int listcount=boardService.getListCount();
		List<BoardVO> boardlist = boardService.getBoardList(page, limit);
		
		//총 페이지 수
   		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1; // 페이지 하단 링크 페이지 
   		
		model.addAttribute("page", page);
		model.addAttribute("listcount", listcount);
		model.addAttribute("boardlist", boardlist);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("startpage", startpage);
		model.addAttribute("endpage", endpage);
		
		return "board/qna_board_list";
	}
	
	@RequestMapping("/boardwriteform.bo") 
	public String boardInsertForm() {
		
		return "board/qna_board_write";
	}
	
	@RequestMapping("/boardwrite.bo") 
	public String boardInsert(BoardVO vo) throws Exception {
		MultipartFile mf = vo.getFile(); // 파일이 없으면 불러올게 없음. 
		
		//System.out.println("mf=" + mf); // mf를 찍어보면 mf는 빈 객체로 만들어져 있음. 
		//System.out.println("mf.getSize()= " + mf.getSize());  //mf의 사이즈로 null인지 아닌지 알아보기.
		
		String uploadPath = "/Users/hongmac/Documents/upload/";
		String originalFileExtension = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		//지정한주소에 파일 저장 - 파일이 없으면 수행할수 없음. 파일없이도 등록할수 있게 하려면 file이 null인지 아닌지 if로 검사 하거나...  
        if(mf.getSize() != 0) {            
            //mf.transferTo(new File(uploadPath+"/"+mf.getOriginalFilename()));     
        	mf.transferTo(new File(uploadPath+storedFileName)); // 예외처리 기능 필요함.
        	//mf.transferTo 실제 업로드 발생. 
        }
		vo.setOrg_file(mf.getOriginalFilename());
		vo.setUp_file(storedFileName);

		boolean res = boardService.boardInsert(vo);
		
		return "redirect:/boardlist.bo"; 
	} 
	
	@RequestMapping("/boarddetail.bo") 
	public String getDetail(@RequestParam(value="num", required=true) int num, Model model) {
		BoardVO vo = boardService.getDetail(num); // 글이 반드시 있어야 하기때문에 required= true
		
		model.addAttribute("vo", vo);
		
		return "board/qna_board_view";
	}
	
	@RequestMapping("/boardreplyform.bo") 
	public String boardReplyForm(@RequestParam(value="num", required=true) int num, Model model) {
		BoardVO vo = boardService.getDetail(num);
		
		model.addAttribute("vo", vo);
		
		return "board/qna_board_reply";
	}
	
	@RequestMapping("/boardreply.bo") 
	public String boardReply(BoardVO vo) throws Exception {
		int res = boardService.boardReply(vo);
		
		return "redirect:/boardlist.bo";
	}
	
	@RequestMapping("/boardmodifyform.bo") 
	public String getModifyForm(@RequestParam(value="num", required=true) int num, Model model) {
		BoardVO vo = boardService.getDetail(num);
		
		model.addAttribute("vo", vo);
		
		return "board/qna_board_modify";
	}
	/*// 수정 권한 검사 안함(원본)
	@RequestMapping("/boardmodify.bo") 
	public String boardModify(BoardVO vo) {
		boolean res = boardService.boardModify(vo);
		
		return "redirect:/boarddetail.bo?num=" + vo.getNum();
	} 
	 */	
	// 수정 권한 검사(수정본)
	@RequestMapping("/boardmodify.bo") 
	public String boardModify(BoardVO vo, HttpSession session, HttpServletResponse response) throws Exception {
		vo.setId((String)session.getAttribute("id"));
		boolean res = boardService.boardModify(vo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res == true)
		{
			writer.write("<script>alert('수정 성공!!');"
					+ "location.href='./boarddetail.bo?num=" + vo.getNum() + "';</script>");
		}
		else
		{
			writer.write("<script>alert('수정 실패(권한없음)!!');"
					+ "location.href='./boardlist.bo';</script>");
		}
		return null;
	}
	
	@RequestMapping("/boarddelete.bo") 
	public String boardDelete(@RequestParam(value="num", required=true) int num, HttpSession session, HttpServletResponse response) throws Exception {
		String id = (String)session.getAttribute("id");
		boolean res = boardService.boardDelete(num, id);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res == true)
		{
			writer.write("<script>alert('삭제 성공!!');"
					+ "location.href='./boardlist.bo';</script>");
		}
		else
		{
			writer.write("<script>alert('삭제 실패(권한없음)!!');"
					+ "location.href='./boardlist.bo';</script>");
		}
		return null;
	}
	
	//파일 다운로드 방식
    @RequestMapping("/filedownload.bo")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	response.setCharacterEncoding("utf-8");
    	
    	String num = request.getParameter("num");
        String of = request.getParameter("of"); // 서버에 업로드된 변경된 실제 파일명
        String of2 = request.getParameter("of2"); // 오리지날 파일명
        
        /* //웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기.
        String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
        String fullPath = uploadPath+"/"+of;
        */
        String uploadPath = "C:\\Project\\upload\\"; // 직접 경로 지정
        String fullPath = uploadPath + of;
        File downloadFile = new File(fullPath);
        
        //파일 다운로드를 위해 컨테츠 타입을 application/download 설정
        response.setContentType("application/download; charset=UTF-8");
        //파일 사이즈 지정
        response.setContentLength((int)downloadFile.length());
        //다운로드 창을 띄우기 위한 헤더 조작
        response.setHeader("Content-Disposition", "attachment;filename="
                                        + new String(of2.getBytes(), "ISO8859_1"));
        response.setHeader("Content-Transfer-Encoding","binary");
        
        FileInputStream fin = new FileInputStream(downloadFile);
        ServletOutputStream sout = response.getOutputStream();

        byte[] buf = new byte[1024];
        int size = -1;

        while ((size = fin.read(buf, 0, buf.length)) != -1) {
            sout.write(buf, 0, size);
        }
        fin.close();
        sout.close();
    }
}
