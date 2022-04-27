package com.mycom.myboard.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class BoardDto {
	private int boardId;
	private int userSeq;
	private String userName;
	private String userProfileImageUrl;
	private String title;
	private String content;
	//private Date regDt;
	//private LocalDate regDt;
	private LocalDateTime regDt;
	private int readCount;

	private boolean sameUser;
	
	private List<BoardFileDto> fileList;

	public BoardDto() {};
	public BoardDto(int userSeq, String title, String content) {
		this.userSeq = userSeq;
		this.title = title;
		this.content = content;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}
	public void setUserProfileImageUrl(String userProfileImageUrl) {
		
		if( userProfileImageUrl == null || "null".equals(userProfileImageUrl) || "".equals(userProfileImageUrl)) {
			this.userProfileImageUrl = "/img/noProfile.png";
		}else {
			this.userProfileImageUrl = userProfileImageUrl;
		}
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = LocalDateTime.ofInstant(
				regDt.toInstant(), ZoneId.systemDefault()
		);	// for Mybatis Date Mapping
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public List<BoardFileDto> getFileList() {
		return fileList;
	}
	public void setFileList(List<BoardFileDto> fileList) {
		this.fileList = fileList;
	}
	
	public boolean isSameUser() {
		return sameUser;
	}
	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}
	
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", userSeq=" + userSeq + ", userName=" + userName
				+ ", userProfileImageUrl=" + userProfileImageUrl + ", title=" + title + ", content=" + content
				+ ", regDt=" + regDt + ", readCount=" + readCount + ", sameUser=" + sameUser + ", fileList=" + fileList
				+ "]";
	}
}

