package kr.co.ahaproject.service;

import kr.co.ahaproject.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    public List<ArticleDto> selectAll();

    public ArticleDto selectOne(int id);

    public int createOne(ArticleDto articleDto);

    public int updateOne(ArticleDto articleDto);

    public int deleteOne(int id);

}
