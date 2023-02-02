package kr.co.ahaproject.controller;

import kr.co.ahaproject.service.YuriBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class YuriBoardController {

    YuriBoardService boardService;

    @GetMapping("yuriboard/board")
    public String goboard(Model model) {
        model.addAttribute("list",boardService.listAll());
        return "yuriboard/board";
    }

}
