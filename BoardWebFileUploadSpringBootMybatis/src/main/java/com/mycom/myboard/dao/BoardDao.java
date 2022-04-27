package com.mycom.myboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	
	public BoardDto boardDetail(BoardParamDto boardParamDto); // 게시물 상세정보
	public List<BoardFileDto> boardDetailFileList(int boardId); // 게시물 파일목록 상세
	
	// map - Dto
	public int boardUserReadCount(BoardParamDto boardParamDto); // 조회수 등록
	// map - @param
	public int boardUserReadInsert(@Param("boardId") int boardId, @Param("userSeq") int userSeq); // 조회수 등록
	
	public int boardReadCountUpdate(int boardId); // 조회수
	
	
	public int boardDelete(int boardId); // DB에서 게시물 삭제
	public int boardFileDelete(int boardId); // DB에서 파일 삭제
	public List<String> boardFileUrlDeleteList(int boardId); // 실제 물리적으로 저장된 파일 삭제를 위한 url
	public int boardReadCountDelete(int boardId); // 조회수 삭제
	
	public int boardInsert(BoardDto dto); // 게시물 등록
	public int boardFileInsert(BoardFileDto dto); // 게시물 파일 등록
	
	public List<BoardDto> boardList(BoardParamDto boardParamDto); // 게시물 목록
	public int boardListTotalCount(); // 목록 전체 개수 (페이징)
	
	public List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto); // 검색 결과 게시물 목록
	public int boardListSearchWordTotalCount(BoardParamDto boardParamDto); // 검색 결과 게시물 개수 (페이징)
	

	public int boardUpdate(BoardDto dto); // 게시물 수정
	
}
