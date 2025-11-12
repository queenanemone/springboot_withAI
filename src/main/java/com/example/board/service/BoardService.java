package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService
{
	private final BoardRepository boardRepository;
	private final FirebaseService firebaseService;
	
	/**
	 * 게시글 목록 조회 (최신순)
	 */
	public List<Board> getBoardList()
	{
		return boardRepository.findAllByOrderByCreatedAtDesc();
	}
	
	/**
	 * 게시글 상세 조회 (조회수 증가)
	 */
	@Transactional
	public Board getBoard(Long id)
	{
		Board board = boardRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));
		
		// 조회수 증가
		board.setViewCount(board.getViewCount() + 1);
		
		// Firebase에도 업데이트 (비동기)
		firebaseService.updateBoardInFirebase(board);
		
		return board;
	}
	
	/**
	 * 게시글 작성
	 */
	@Transactional
	public Board writeBoard(String title, String content, String writer)
	{
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		// 1. H2 DB에 저장
		Board savedBoard = boardRepository.save(board);
		
		// 2. Firebase에도 저장 (비동기)
		firebaseService.saveBoardToFirebase(savedBoard);
		
		return savedBoard;
	}
	
	/**
	 * 게시글 수정
	 */
	@Transactional
	public Board updateBoard(Long id, String title, String content)
	{
		Board board = boardRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));
		
		// 제목과 내용 수정
		board.setTitle(title);
		board.setContent(content);
		
		// Firebase에도 업데이트 (비동기)
		firebaseService.updateBoardInFirebase(board);
		
		return board;
	}
	
	/**
	 * 게시글 삭제
	 */
	@Transactional
	public void deleteBoard(Long id)
	{
		if (!boardRepository.existsById(id))
		{
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id);
		}
		
		// 1. H2 DB에서 삭제
		boardRepository.deleteById(id);
		
		// 2. Firebase에서도 삭제 (비동기)
		firebaseService.deleteBoardFromFirebase(id);
	}
	
	/**
	 * 전체 게시글 수 조회
	 */
	public long getTotalCount()
	{
		return boardRepository.count();
	}
}