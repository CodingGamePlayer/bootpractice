package kr.co.ahaproject.controller;

import kr.co.ahaproject.dto.YuriBoardDTO;
import kr.co.ahaproject.service.YuriBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YuriBoardController {

    @Autowired
    private YuriBoardService yuriBoardService;

    @GetMapping("yuriboard/board")
    public String goboard(Model model) {
        model.addAttribute("list",yuriBoardService.listAll());
        return "yuriboard/board";
    }

    @GetMapping("yuriboard/detail/{no}")
    public String goDetail(Model model, @PathVariable("no") int bno){
        model.addAttribute("board",yuriBoardService.selectOne(bno));
    return "yuriboard/detail";
    }

    @GetMapping("yuriboard/register")
    public void goRegister(){
    }

    @PostMapping("yuriboard/register")
    public String register(YuriBoardDTO boardDTO){
        yuriBoardService.register(boardDTO);
        return "redirect:/yuriboard/board";
    }
    @GetMapping("yuriboard/update/{no}")
    public String goupdate(Model model, @PathVariable("no") int bno, YuriBoardDTO boardDTO) {
        model.addAttribute("board", yuriBoardService.selectOne(bno));
        return "yuriboard/update";
    }

    @PostMapping("yuriboard/update/{bno}")
    public String update(@PathVariable("bno") int bno, Model model,YuriBoardDTO boardDTO) {
        yuriBoardService.update(boardDTO);
        System.out.println(boardDTO.toString());
        return "redirect:/yuriboard/board";
    }

    @GetMapping("yuriboard/delete/{no}")
    public String delete(@PathVariable("no") int bno){
        yuriBoardService.delete(bno);
        return "redirect:/yuriboard/board";
    }

}

