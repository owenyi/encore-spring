package com.encore.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.board.domain.BoardVO;
import com.encore.board.domain.MemberVO;
import com.encore.board.model.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	private String write(BoardVO bvo, HttpSession session, Model model) throws Exception {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo == null) { // 로그인 된 유저 정보가 없다면
			return "redirect:index.jsp";
		}
		bvo.setMemberVO(mvo); // mvo 삽입으로 bvo 완성
		model.addAttribute("bvo", bvo); // 자기가 쓴 글 상세보기로 가기 위해
		boardService.write(bvo);
		return "board/show_content";
	}
	
	@RequestMapping("list.do")
	private String list(Model model) throws Exception {
		try {
			List<BoardVO> list = boardService.getBoardList();
			model.addAttribute("list", list);
			return "board/list";
		} catch(Exception e) {
			model.addAttribute("message", "게시글 목록 - 에러 발생");
			return "Error";
		}
	}
	
	@RequestMapping("showContent.do")
	private String showContent(int no, Model model) throws Exception {
		try {
			boardService.addCount(no);
			BoardVO bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			return "board/show_content";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "게시글 상세 - 에러 발생");
			return "Error";
		}
	}
	
	@RequestMapping("updateView.do")
	private String update(int no, Model model) throws Exception {
		try {
			BoardVO bvo = boardService.showContent(no);
			model.addAttribute("bvo", bvo);
			return "board/update";
		} catch(Exception e) {
			model.addAttribute("message", "게시글 수정 - 에러 발생");
			return "Error";
		}
	}
	
	@RequestMapping("updateBoard.do")
	private String update(BoardVO vo, Model model) throws Exception {
		try {
			boardService.update(vo);
			model.addAttribute("no", vo.getNo());
			return "redirect:showContent.do";
		} catch(Exception e) {
			model.addAttribute("message", "게시글 수정 - 에러 발생");
			return "Error";
		}
	}

	@RequestMapping("delete.do")
	private String delete(int no, Model model) throws Exception {
		try {
			boardService.delete(no);
			return "redirect:list.do";
		} catch(Exception e) {
			model.addAttribute("message", "게시글 삭제 - 에러 발생");
			return "Error";
		}
	}
	
}