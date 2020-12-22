package som.spring.sungjuksystem;

import java.util.ArrayList;

public interface SysService {
	public int insertSungjuk(SysVO sysVO);
	public int insertMember(SysVO sysVO);
	public int userCheck(SysVO sysVO);
	public ArrayList<SysVO> getSyslist();
	public SysVO selectMember(SysVO sysVO);
	public int deleteMember(SysVO sysVO);
	public SysVO update(SysVO sysVO);
	public int updateMember(SysVO sysVO);
}
