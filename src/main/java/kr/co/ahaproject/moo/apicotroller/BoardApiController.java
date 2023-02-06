package kr.co.ahaproject.moo.apicotroller;

import kr.co.ahaproject.moo.dto.BoardDto;
import kr.co.ahaproject.moo.service.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static java.time.LocalDate.now;
@RestController
@Slf4j
public class BoardApiController {
    @Autowired
    private BoardServiceImpl boardService;

    // 글 작성하기
    @PostMapping("/api/board/register")
    public ResponseEntity<Integer> create(@RequestBody BoardDto boardDto){
//        boardDto.setRegdate(now());
        int result = boardService.createOne(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 글 수정하기
    @PutMapping("/api/board/update")
    public ResponseEntity<Integer> update(@RequestBody BoardDto boardDto){
//        boardDto.setModddate(LocalDate.now());
        int result = boardService.updateOne(boardDto);
        boardDto.setModddate(now());
        if (result<0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
