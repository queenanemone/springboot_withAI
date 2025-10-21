package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController
{
    private final BoardService boardService;

    /**
     * 게시글 목록 페이지
     * URL: GET /board/list
     */
    @GetMapping("/list")
    public String list(Model model)
    {
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "list";  // templates/list.html
    }

    /**
     * 게시글 작성 페이지
     * URL: GET /board/write
     */
    @GetMapping("/write")
    public String writeForm()
    {
        return "write";  // templates/write.html
    }

    /**
     * 게시글 작성 처리
     * URL: POST /board/write
     */
    @PostMapping("/write")
    public String write(@RequestParam String title,
                        @RequestParam String content,
                        @RequestParam String writer)
    {
        boardService.writeBoard(title, content, writer);
        return "redirect:/board/list";  // 목록으로 리다이렉트
    }

    /**
     * 게시글 상세 페이지
     * URL: GET /board/detail/1
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model)
    {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "detail";  // templates/detail.html
    }

    /**
     * 게시글 수정 페이지
     * URL: GET /board/edit/1
     */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model)
    {
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "edit";  // templates/edit.html
    }

    /**
     * 게시글 수정 처리
     * URL: POST /board/edit/1
     */
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam String title,
                       @RequestParam String content)
    {
        boardService.updateBoard(id, title, content);
        return "redirect:/board/detail/" + id;  // 상세 페이지로 리다이렉트
    }

    /**
     * 게시글 삭제
     * URL: POST /board/delete/1
     */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id)
    {
        boardService.deleteBoard(id);
        return "redirect:/board/list";  // 목록으로 리다이렉트
    }
}