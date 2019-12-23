package com.ram.aa.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ram.aa.board.BoardService;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return dao.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		dao.insertBoard(boardVO);
	}

	@Override
	public BoardVO getBoardContent(int bno) throws Exception{
		dao.updateViewCnt(bno);
		return dao.getBoardContent(bno);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		dao.deleteBoard(bno);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		dao.updateBoard(boardVO);
	}
	
	// 댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int bno) throws Exception {
		return dao.getReplyList(bno);
	}

	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return dao.saveReply(replyVO);
	}

	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return dao.updateReply(replyVO);
	}

	@Override
	public int deleteReply(int rno) throws Exception {
		return dao.deleteReply(rno);
	}
}
