package com.mycom.myboard.service;

import java.util.List;

import com.mycom.myboard.dto.CodeDto;

public interface CodeService {
	public List<CodeDto> codeList(String groupCode);
}
