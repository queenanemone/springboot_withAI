package com.example.board.service;

import com.example.board.entity.Board;
import com.google.api.core.ApiFuture;
import com.google.firebase.database.DatabaseReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class FirebaseService
{
	private final DatabaseReference databaseReference;
	
	/**
	 * 게시글을 Firebase에 JSON으로 저장
	 */
	public void saveBoardToFirebase(Board board)
	{
		try
		{
			// Board Entity → JSON Map 변환
			Map<String, Object> boardData = new HashMap<>();
			boardData.put("id", board.getId());
			boardData.put("title", board.getTitle());
			boardData.put("content", board.getContent());
			boardData.put("writer", board.getWriter());
			boardData.put("viewCount", board.getViewCount());
			boardData.put("createdAt", board.getCreatedAt() != null ? board.getCreatedAt().toString() : null);
			boardData.put("updatedAt", board.getUpdatedAt() != null ? board.getUpdatedAt().toString() : null);
			
			// Firebase에 비동기 저장
			// 경로: boards/{게시글ID}
			ApiFuture<Void> future = databaseReference
				.child(board.getId().toString())
				.setValueAsync(boardData);
			
			// 비동기 콜백 (성공/실패 처리)
			future.addListener(() -> {
				try
				{
					future.get();  // 완료될 때까지 대기
					log.info("Firebase 저장 성공 - ID: {}", board.getId());
				}
				catch (Exception e)
				{
					log.error("Firebase 저장 실패 - ID: {}, 에러: {}", board.getId(), e.getMessage());
				}
			}, Runnable::run);
		}
		catch (Exception e)
		{
			log.error("Firebase 저장 중 예외 발생: {}", e.getMessage());
		}
	}
	
	/**
	 * Firebase에서 게시글 삭제
	 */
	public void deleteBoardFromFirebase(Long boardId)
	{
		try
		{
			ApiFuture<Void> future = databaseReference
				.child(boardId.toString())
				.removeValueAsync();
			
			future.addListener(() -> {
				try
				{
					future.get();
					log.info("Firebase 삭제 성공 - ID: {}", boardId);
				}
				catch (Exception e)
				{
					log.error("Firebase 삭제 실패 - ID: {}, 에러: {}", boardId, e.getMessage());
				}
			}, Runnable::run);
		}
		catch (Exception e)
		{
			log.error("Firebase 삭제 중 예외 발생: {}", e.getMessage());
		}
	}
	
	/**
	 * Firebase에서 게시글 업데이트
	 */
	public void updateBoardInFirebase(Board board)
	{
		try
		{
			Map<String, Object> updates = new HashMap<>();
			updates.put("title", board.getTitle());
			updates.put("content", board.getContent());
			updates.put("viewCount", board.getViewCount());
			updates.put("updatedAt", board.getUpdatedAt() != null ? board.getUpdatedAt().toString() : null);
			
			ApiFuture<Void> future = databaseReference
				.child(board.getId().toString())
				.updateChildrenAsync(updates);
			
			future.addListener(() -> {
				try
				{
					future.get();
					log.info("Firebase 업데이트 성공 - ID: {}", board.getId());
				}
				catch (Exception e)
				{
					log.error("Firebase 업데이트 실패 - ID: {}, 에러: {}", board.getId(), e.getMessage());
				}
			}, Runnable::run);
		}
		catch (Exception e)
		{
			log.error("Firebase 업데이트 중 예외 발생: {}", e.getMessage());
		}
	}
}