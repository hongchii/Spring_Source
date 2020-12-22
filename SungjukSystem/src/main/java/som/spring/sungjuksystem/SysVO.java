package som.spring.sungjuksystem;

public class SysVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String gender;
	private String email;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private String grade;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		tot = kor + eng + math;
		return tot;
	}
	public void setTot(int tot) {
		tot = kor + eng + math;
		this.tot = tot;
	}
	public double getAvg() {
		avg = tot / 3.;
		return avg;
	}
	public void setAvg(double avg) {
		avg = tot / 3.;
		this.avg = avg;
	}
	public String getGrade() {
		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			
		}
		return grade;
	}
	public void setGrade(String grade) {
		switch ((int) (avg / 10)) {
		case 10:
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			
		}
		this.grade = grade;
	}
	
}
