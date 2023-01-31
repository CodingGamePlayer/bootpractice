package kr.co.ahaproject.service.impl;

import kr.co.ahaproject.domain.Article;
import kr.co.ahaproject.dto.ArticleDto;
import kr.co.ahaproject.mapper.ArticleMapper;
import kr.co.ahaproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ArticleDto> selectAll() {
        List<Article> articles = articleMapper.selectAll();

        articles.forEach(article -> article.toString());

        List<ArticleDto> list = articles.stream()
                .map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toList());

        list.forEach(articleDto -> articleDto.toString());

        return list;
    }

    @Override
    public ArticleDto selectOne(int id) {
        ArticleDto articleDto = modelMapper.map(articleMapper.selectOne(id), ArticleDto.class);

        return articleDto;
    }

    @Override
    public int createOne(ArticleDto articleDto) {

        if(articleDto == null) {
            throw new IllegalArgumentException("게시글 생성에 실패 하였습니다.");
        }

        Article article = modelMapper.map(articleDto, Article.class);
        int result = articleMapper.create(article);

        if(result<0){
            return 0;
        }

        return 1;
    }

    @Override
    public int updateOne(ArticleDto articleDto) {

        Article target = articleMapper.selectOne(articleDto.getId());

        if(target == null) {
            throw new IllegalArgumentException("수정하려고 하는 게시글이 존재 하지 않습니다.");
        }

        Article article = modelMapper.map(articleDto, Article.class);
        int result = articleMapper.update(article);

        if(result<0){
            return 0;
        }
        return 1;
    }

    @Override
    public int deleteOne(int id) {

        int result = articleMapper.delete(id);

        if(result<0){
            return 0;
        }
        return 1;
    }
}
