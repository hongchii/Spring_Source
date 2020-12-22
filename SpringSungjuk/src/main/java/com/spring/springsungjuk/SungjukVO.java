package com.spring.springsungjuk;

public class SungjukVO {
	String hakbun;
	String name;
	int kor;
	int eng;
	int math;
	int tot;
	double avg;
	String grade;
	
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		
		this.grade = grade;
	}
	
		
		
	}
	
}