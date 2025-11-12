package com.example.board.controller;

import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController
{
	private final BoardService boardService;
	
	/**
	 * 메인 페이지
	 */
	@GetMapping("/")
	public String home(Model model)
	{
		// 총 게시글 수를 메인 페이지에 전달
		long totalBoards = boardService.getTotalCount();
		model.addAttribute("totalBoards", totalBoards);
		
		return "index";
	}
	
	/**
	 * 프로젝트 소개 페이지
	 */
	@GetMapping("/about")
	public String about()
	{
		return "about";
	}
	
	/**
	 * 문의 페이지
	 */
	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}
}