package com.mycom.myboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardParamDto {
	private int limit;
	private int offset;
	private String searchWord;

	private int boardId;
	private int userSeq;
}
