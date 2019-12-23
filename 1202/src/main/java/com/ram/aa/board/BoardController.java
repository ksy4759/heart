package com.ram.aa.board;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {

    @Inject
	private BoardService service;
	
	@RequestMapping(value="/getBoardList", method = {RequestMethod.POST,RequestMethod.GET})
	public String getBoardList(Model model) throws Exception{
		
		List<BoardVO> li=null;
		li=service.getBoardList();
		model.addAttribute("boardList", li);
		return "board/index";
	}
	
	@RequestMapping("/boardForm")
	public String boardForm(@ModelAttribute("boardVO")BoardVO boardVO) {
		return "board/boardForm";
	}
	@RequestMapping(value = "/saveBoard", method = {RequestMethod.POST,RequestMethod.GET})
	public String saveBoard(@ModelAttribute("BoardVO") BoardVO boardVO,@RequestParam("mode") String mode,     
			RedirectAttributes rttr) throws Exception {
		if(mode.contentEquals("edit")) {
			service.updateBoard(boardVO);
		}else {
			service.insertBoard(boardVO);
		}
		return "redirect:/getBoardList";
	}
	   
	@RequestMapping(value = "/getBoardContent", method = {RequestMethod.POST,RequestMethod.GET})
	public String getBoardContent(Model model, @RequestParam("bno") int bno) throws Exception {
		model.addAttribute("boardContent", service.getBoardContent(bno));
		model.addAttribute("replyVO", new ReplyVO());
		return "board/boardContent";
	}
	
    @RequestMapping(value="/editForm",method = {RequestMethod.POST,RequestMethod.GET})
    public String editForm(@RequestParam("mode") String mode,Model model, @RequestParam("bno") int bno)throws Exception{
		model.addAttribute("boardContent",service.getBoardContent(bno));
		model.addAttribute("mode",mode);//front단 구분하기위해서
		model.addAttribute("boardVO",new BoardVO());
		return "board/boardForm";    	
    }
    
    @RequestMapping(value="/deleteBoard",method = {RequestMethod.POST,RequestMethod.GET})
    public String deleteBoard(RedirectAttributes rttr, @RequestParam("bno")int bno) throws Exception{
    	
    	service.deleteBoard(bno);
    	return "redirect:/getBoardList";
    }
}