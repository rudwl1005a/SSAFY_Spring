package com.mycom.mybatis.dto;

public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private String phone;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentNm() {
		return studentNm;
	}

	public void setStudentNm(String studentNm) {
		this.studentNm = studentNm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public StudentDto() {}

	public StudentDto(int studentId, String studentNm, String email, String phone) {
		super();
		this.studentId = studentId;
		this.studentNm = studentNm;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentNm=" + studentNm + ", email=" + email + ", phone="
				+ phone + "]";
	}

}
