package som.spring.sungjuksystem;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysService")
public class SysServiceim implements SysService {

	@Autowired(required=false)
	private SysDAO sysDAO = null;
	
	@Override
	public int insertSungjuk(SysVO sysVO) {
		int res = sysDAO.insertSungjuk(sysVO);
		
		return 0;
	}

	@Override
	public int insertMember(SysVO sysVO) {
		int res = sysDAO.insertMember(sysVO);
		
		return 0;
	}
	
	@Override
	public int userCheck(SysVO sysVO) {
		int res = sysDAO.userCheck(sysVO);
		
		return 0;
	}

	@Override
	public ArrayList<SysVO> getSyslist() {
		ArrayList<SysVO> sys_list = new ArrayList<SysVO>();
		sys_list = sysDAO.getSyslist();
		
		return sys_list;
	}

	@Override
	public SysVO selectMember(SysVO sysVO) {
		SysVO vo = sysDAO.selectMember(sysVO);
		
		return vo;
	}

	@Override
	public int deleteMember(SysVO sysVO) {
		int res = sysDAO.deleteMember(sysVO);
		
		return res;
	}

	@Override
	public SysVO update(SysVO sysVO) {
		SysVO vo = sysDAO.selectMember(sysVO);
		
		return vo;
	}

	@Override
	public int updateMember(SysVO sysVO) {
		int res = sysDAO.updateMember(sysVO);
		
		return res;
	}

}
