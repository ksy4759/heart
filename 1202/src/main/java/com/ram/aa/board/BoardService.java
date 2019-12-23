package com.ram.aa.board;

import java.util.List;

public interface BoardService {
	public List<BoardVO> getBoardList() throws Exception; 
	
	public void insertBoard(BoardVO boardVO) throws Exception;

	public BoardVO getBoardContent(int bno) throws Exception;

	public void updateBoard(BoardVO boardVO) throws Exception;
	
	public void deleteBoard(int bno) throws Exception;
//댓글	
	public List<ReplyVO> getReplyList(int bno) throws Exception;

	public int saveReply(ReplyVO replyVO) throws Exception;

	public int updateReply(ReplyVO replyVO) throws Exception;

	public int deleteReply(int rno) throws Exception;

}
