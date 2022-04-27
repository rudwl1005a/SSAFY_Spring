package com.mycom.more.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor // @NonNull인 것만 생성자 만들기
@ToString
public class StudentDto {
	private int studentId;
//	@NonNull
	private String studentNm;
	private String email;
	private String phone;
}
