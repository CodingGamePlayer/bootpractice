package kr.co.ahaproject.moo.service;

import kr.co.ahaproject.moo.domain.Board;
import kr.co.ahaproject.moo.mapper.BoardMapper;
import kr.co.ahaproject.moo.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardServiceImpl implements  BoardService{

    @Autowired
    private BoardMapper boardMapper;

    private ModelMapper modelMapper = new ModelMapper();

    // 글 전체보기
    @Override
    public List<BoardDto> selectAll() {
        List<Board> boards = boardMapper.selectAll();

        boards.forEach(board -> board.toString());

        List<BoardDto> list = boards.stream()
                .map(board -> modelMapper.map(board, BoardDto.class))
                .collect(Collectors.toList());

        list.forEach(boardDto -> boardDto.toString());

        return list;
    }

    // 글 상세보기
    @Override
    public BoardDto selectOne(int id) {
        BoardDto boardDto = modelMapper.map(boardMapper.selectOne(id), BoardDto.class);

        return boardDto;
    }

    // 글 작성하기
    @Override
    public int createOne(BoardDto boardDto) {

        if(boardDto == null){
            throw new IllegalArgumentException("게시글 생성에 실패 하였습니다.");
        }

        Board board = modelMapper.map(boardDto, Board.class);
        int result = boardMapper.create(board);

        if(result<0){
            return 0;
        }
        return 1;
    }

    // 글 수정하기
    @Override
    public int updateOne(BoardDto boardDto) {

        Board target = boardMapper.selectOne(boardDto.getId());

        if(target == null){
            throw  new IllegalArgumentException("수정하려고 하는 게시글이 존재하지 않흡니다.");
        }

        Board board = modelMapper.map(boardDto, Board.class);
        int result = boardMapper.update(board);

        if(result<0){
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteOne(int id) {
        return 0;
    }
}
