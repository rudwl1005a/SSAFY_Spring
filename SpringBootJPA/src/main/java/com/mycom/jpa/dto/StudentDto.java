package com.mycom.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto {
	private int studentId;
	private String studentNm;
	private String email;
	private String phone;
}
