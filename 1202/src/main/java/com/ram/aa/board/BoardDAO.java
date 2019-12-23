package com.ram.aa.board;

import java.util.List;

public interface BoardDAO {

	public List<BoardVO> getBoardList() throws Exception;

	public BoardVO getBoardContent(int bno) throws Exception;

	public int insertBoard(BoardVO boardVO) throws Exception;

	public int updateBoard(BoardVO boardVO) throws Exception;

	public int deleteBoard(int bno) throws Exception;

	public int updateViewCnt(int bno) throws Exception;
//댓글
	public List<ReplyVO> getReplyList(int bno) throws Exception;

	public int saveReply(ReplyVO replyVO) throws Exception;

	public int updateReply(ReplyVO replyVO) throws Exception;

	public int deleteReply(int rno) throws Exception;
}
