package com.mycom.myboard.dto;

import java.util.List;

public class BoardResultDto {
	private int result;
	private BoardDto dto;
	private List<BoardDto> list;
	private int count;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public BoardDto getDto() {
		return dto;
	}
	public void setDto(BoardDto dto) {
		this.dto = dto;
	}

	public List<BoardDto> getList() {
		return list;
	}
	public void setList(List<BoardDto> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	

}
