package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Board;
import com.encore.spring.model.BoardService;
import com.encore.spring.UploadDataVO;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("boardInput.do")
	public ModelAndView boardInput() {		
		System.out.println("boardInput.do method in");
		//게시판 입력폼인 board/boardInsert.jsp로 결과 페이지 연결한다.
		return new ModelAndView("redirect:board/boardInsert.jsp");
	}

	@RequestMapping("boardInsert.do")
	public String boardInsert(Model model, Board board, UploadDataVO upload, HttpServletRequest request) throws Exception {		
					
		MultipartFile uploadFile = upload.getUploadFile();
		System.out.println("uploadFile :: " + uploadFile);
		
		/*
		 * 2. 업로드된 파일이 있다면 
		 *    파일의 사이즈
		 *    업로드한 파일의 이름
		 *    업로드한 파일의 파라미터명
		 */
		if((uploadFile.isEmpty())!=true) { // 업로드된 파일이 있다면
			System.out.println("파일의 사이즈:: " + uploadFile.getSize());
			System.out.println("업로드된 파일명:: " + uploadFile.getOriginalFilename());
			System.out.println("파일의 파라미터 명:: " + uploadFile.getName());
		}
			
		String root = request.getSession().getServletContext().getRealPath("/");
		String filePath = root + "\\upload\\";
		
		File copyFile = new File(filePath + uploadFile.getOriginalFilename());
		uploadFile.transferTo(copyFile); // 업로드한 파일의 카피본이 해당 경로에 저장된다...이동한다
		System.out.println("path : " + filePath);
		model.addAttribute("uploadfile", uploadFile.getOriginalFilename());
		
		String path = "error.jsp";
		try {
			boardService.insert(board);
			path = "boardList.do";
		} catch(Exception e) {
			System.out.println(e);
			model.addAttribute("msg", "게시글을 등록하는 중에 오류가 발생했습니다.");
		}
		
		return path;
	}

	@RequestMapping("boardList.do")
	public String boardList(Model model) throws Exception {
		System.out.println("boardList.do method in");
		String path = "error.jsp";
		List<Board> list = null;
		try {
			list = boardService.selectAll();
			for (Board b : list) System.out.println(b);
			path = "board_list";
		} catch(Exception e) {
			System.out.println(e);
			model.addAttribute("msg", "게시글 목록을 받아오는 중에 오류가 발생했습니다.");
		}
		model.addAttribute("list", list);
		return path;
	}

	@RequestMapping("boardDetail.do")
	public String boardDetail(Model model, String no) throws Exception {
		System.out.println("boardDetail.do method in");
		String path = "error.jsp";
		Board board = null;
		try {
			board = boardService.selectOne(no);
			System.out.println(board);
			path = "board_detail";
		} catch(Exception e) {
			System.out.println(e);
			model.addAttribute("msg", "게시글을 받아오는 중에 오류가 발생했습니다.");
		}
		model.addAttribute("vo", board);
		return path;
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(HttpServletRequest request, String filename) throws Exception {
		System.out.println("filename : " + filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root + "\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
	}
	
}
