package com.ram.aa.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restBoard")
public class RestBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/getReplyList", method = {RequestMethod.POST,RequestMethod.GET})
	public List<ReplyVO> getReplyList(@RequestParam("bno") int bno) throws Exception {
		
		return boardService.getReplyList(bno);
	}

	@RequestMapping(value="/saveReply", method = {RequestMethod.POST,RequestMethod.GET})
	public Map<String, Object> saveReply(@RequestBody ReplyVO replyVO) throws Exception{
		Map<String, Object> result = new HashMap<>();

		try {
			System.out.println(replyVO);
			boardService.saveReply(replyVO);
			result.put("status", "OK");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("status", "False");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateReply", method = {RequestMethod.POST,RequestMethod.GET})
	public int updateReply(@RequestBody ReplyVO replyVO) throws Exception {
		return boardService.updateReply(replyVO);
	}
	
	@RequestMapping(value = "/deleteReply", method = {RequestMethod.POST,RequestMethod.GET})
	public int deleteReply(@RequestParam("rno") int rno) throws Exception {
		
		return boardService.deleteReply(rno);
	}
	     
}
