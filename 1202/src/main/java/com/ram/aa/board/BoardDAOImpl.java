package com.ram.aa.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;

	private static String namespace="com.ram.aa.mappers.boardMapper"; 
	private static String namespace2="com.ram.aa.mappers.replyMapper"; 


	@Override
	public List<BoardVO> getBoardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".getBoardList");
	}

	@Override
	public BoardVO getBoardContent(int bno) throws Exception {

		return sqlSession.selectOne(namespace+".getBoardContent",bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".insertBoard", boardVO);
	}

	@Override
	public int updateBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".updateBoard", boardVO);
	}

	@Override
	public int deleteBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".deleteBoard", bno);
	}

	@Override
	public int updateViewCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".updateViewCnt",bno);
	}

	// 댓글 리스트
	@Override
	public List<ReplyVO> getReplyList(int bno) throws Exception {
		return sqlSession.selectList(namespace2+".getReplyList", bno);
	}
	
	@Override
	public int saveReply(ReplyVO replyVO) throws Exception {
		return sqlSession.insert(namespace2+".saveReply", replyVO);
	}


	@Override
	public int updateReply(ReplyVO replyVO) throws Exception {
		return sqlSession.update(namespace2+".updateReply", replyVO);
	}

	@Override
	public int deleteReply(int rno) throws Exception {
		return sqlSession.delete(namespace2+".deleteReply", rno);
	}
}
