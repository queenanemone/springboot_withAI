package com.example.board.repository;

import com.example.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>
{
    // JpaRepository가 기본 제공하는 메서드들:
    // - save(Board board) : 저장/수정
    // - findById(Long id) : ID로 조회
    // - findAll() : 전체 조회
    // - deleteById(Long id) : ID로 삭제
    // - count() : 전체 개수
    // 등등... 자동으로 구현됨!

    // ===== 커스텀 메서드 (메서드 이름으로 쿼리 자동 생성) =====

    /**
     * 작성자로 게시글 찾기
     * SQL: SELECT * FROM board WHERE writer = ?
     */
    List<Board> findByWriter(String writer);

    /**
     * 제목에 특정 키워드가 포함된 게시글 찾기
     * SQL: SELECT * FROM board WHERE title LIKE %keyword%
     */
    List<Board> findByTitleContaining(String keyword);

    /**
     * 제목 또는 내용에 키워드가 포함된 게시글 찾기
     * SQL: SELECT * FROM board WHERE title LIKE %keyword% OR content LIKE %keyword%
     */
    List<Board> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);

    /**
     * 조회수 많은 순으로 상위 10개 조회
     * SQL: SELECT * FROM board ORDER BY view_count DESC LIMIT 10
     */
    List<Board> findTop10ByOrderByViewCountDesc();

    /**
     * 최신 게시글 순으로 전체 조회
     * SQL: SELECT * FROM board ORDER BY created_at DESC
     */
    List<Board> findAllByOrderByCreatedAtDesc();

    /**
     * 특정 작성자의 게시글 개수
     * SQL: SELECT COUNT(*) FROM board WHERE writer = ?
     */
    long countByWriter(String writer);
}