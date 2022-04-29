package com.mycom.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(
	name="student",
	uniqueConstraints = {
		@UniqueConstraint(name="UK_STUDENT_EMAIL", columnNames="email")
	}
)
public class Student { // @Entity로 인해, Student 테이블을 대변하는 (매핑되는) 클래스
	@Id
//	@GeneratedValue // 자동으로 증가 hibernate_sequence 테이블이 추가되어서 직접 증가해줘야 한다
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB에 의존해서 AutoIncrement처리
	@Column
	private int studentId;

	private String studentNm;

	@Column(name = "email", length = 200)
	private String email;

	@Column(name = "phone", columnDefinition="varchar(13) default '010-0000-0000'")
	private String phone;
}
