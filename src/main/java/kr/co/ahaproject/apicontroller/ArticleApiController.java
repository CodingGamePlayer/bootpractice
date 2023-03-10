package kr.co.ahaproject.apicontroller;

import kr.co.ahaproject.dto.ArticleDto;
import kr.co.ahaproject.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Slf4j
public class ArticleApiController {

    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/api/article/create")
    public ResponseEntity<Integer> create(@RequestBody ArticleDto articleDto){

        articleDto.setRegdate(LocalDate.now());
        int result = articleService.createOne(articleDto);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @PutMapping("/api/article/update")
    public ResponseEntity<Integer> update(@RequestBody ArticleDto articleDto){

//        log.info(articleDto.toString());

        articleDto.setModdate(LocalDate.now());
        int result = articleService.updateOne(articleDto);

        if(result<0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
