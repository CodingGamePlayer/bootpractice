package kr.co.ahaproject.moo.controller;

import kr.co.ahaproject.moo.dto.BoardDto;
import kr.co.ahaproject.moo.service.BoardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    private BoardServiceImpl boardService;

    // 글 전체보기
    @GetMapping("/list")
    public String boardlist(Model model){
//        List<BoardDto> boardlist = boardService.selectAll();
        model.addAttribute("boards", boardService.selectAll());
        return "moo/board/listAll";
    }

    // 글 작성하기
    @GetMapping("/register")
    public String boardregister(){
        return "moo/board/register";
    }

    // 글 상세보기
    @GetMapping("/board/{id}/detail")
        public String detail(@PathVariable int id, Model model){
            BoardDto boardDto = boardService.selectOne(id);
            model.addAttribute("board", boardDto);
            return "moo/board/detail";
        }

    // 글 수정하기
    @GetMapping("/board/{id}/update")
        public String update(@PathVariable int id, Model model){
        BoardDto boardDto = boardService.selectOne(id);
        model.addAttribute("board", boardDto);

        return "moo/board/update";
    }


    }
