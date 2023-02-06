package kr.co.ahaproject.moo.service;

import kr.co.ahaproject.moo.dto.BoardDto;

import java.util.List;

public interface BoardService {
    // 글 전체보기
    public List<BoardDto> selectAll();

    // 글 상세보기
    public BoardDto selectOne(int id);

    // 글 작성하기
    public int createOne(BoardDto boardDto);

    // 글 수정하기
    public int updateOne(BoardDto boardDto);

    // 글 삭제하기
    public int deleteOne(int id);
}
