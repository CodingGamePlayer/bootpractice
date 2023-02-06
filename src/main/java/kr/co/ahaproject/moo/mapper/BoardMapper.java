package kr.co.ahaproject.moo.mapper;

import kr.co.ahaproject.moo.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper



public interface BoardMapper {
    @Select("SELECT art_id, art_title, art_body, art_regdate, art_moddate, userid FROM article")
    @Results(id = "ArticleMap", value = {
            @Result(property = "id", column = "art_id"),
            @Result(property = "title", column = "art_title"),
            @Result(property = "body", column = "art_body"),
            @Result(property = "regdate", column = "art_regdate"),
            @Result(property = "moddate", column = "art_moddate"),
            @Result(property = "userid", column = "userid"),
    })
    List<Board> selectAll();

    @Insert("INSERT INTO article (art_title, art_body, art_regdate, userid) VALUES (#{board.title}, #{board.body}, now(), #{board.userid})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(@Param("board") Board board);

    @Select("SELECT * FROM article WHERE art_id = #{id}")
    @ResultMap("ArticleMap")
    Board selectOne(int id);

    @Update("UPDATE article SET art_title = #{board.title}, art_body = #{board.body}, art_moddate = now(), userid = #{board.userid} WHERE art_id = #{board.id}")
    int update(@Param("board") Board board);
}
