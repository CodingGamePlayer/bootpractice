package kr.co.ahaproject.controller;

import kr.co.ahaproject.dto.ArticleDto;
import kr.co.ahaproject.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {
		// 바로 커밋해 
	// 바로 커밋해
// 바로 커밋해 asd asd
	//asdasd 
    @Autowired
    private ArticleServiceImpl articleService;

    @GetMapping("/articles")
    public String articles(Model model) {
        List<ArticleDto> articles = articleService.selectAll();
        model.addAttribute("articles", articles);

        articles.forEach(article -> log.info(String.valueOf(article)));

        return "user/article/articles";
    }

    @GetMapping("/article/{id}/detail")
    public String detail(@PathVariable int id, Model model){

        ArticleDto articleDto = articleService.selectOne(id);

        model.addAttribute("article", articleDto);

        return "user/article/detail";
    }

    @GetMapping("/article/{id}/modify")
    public String modify(@PathVariable int id, Model model){

        ArticleDto articleDto = articleService.selectOne(id);

        model.addAttribute("article", articleDto);

        return "user/article/modify";
    }

    @GetMapping("/articles/insertform")
    public String insertForm(){

        return "user/article/newform";
    }
}
