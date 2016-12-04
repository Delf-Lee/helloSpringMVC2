package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Course {
	private int year;
	private int semester;
	
	@Size(min=7, max=7, message="코드 포멧 에러")
	@NotEmpty(message="공백 있음")
	private String code;
	private String title;
	private String division;
	private int credit;

	public Course() {
	}
	
	public Course(int year, int semester, String title, String division, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = null;
		this.title = title;
		this.division = division;
		this.credit = credit;
	}

	public Course(int year, int semester, String code, String title, String division, int credit) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.title = title;
		this.division = division;
		this.credit = credit;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String toString() {
		return "Course [year=" + year + ", semester=" + semester + ", code=" + code + ", title=" + title
				+ ", division=" + division + ", credit=" + credit + "]";
	}

}
