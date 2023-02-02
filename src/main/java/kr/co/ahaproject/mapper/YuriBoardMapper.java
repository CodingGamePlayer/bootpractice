package kr.co.ahaproject.mapper;

import kr.co.ahaproject.dto.YuriBoardDTO;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface YuriBoardMapper {

    @Select("select * from yuriboard order by bno desc")
    List<YuriBoardDTO> listAll();

    @Select("select * from yuriboard where bno =#{bno}")
    YuriBoardDTO selectOne(int bno);

    @Insert("insert into yuriboard (title,content,userid) values (#{title}, #{content}, #{userid})")
    int register(YuriBoardDTO boardDTO);

    @Update("update yuriboard set title=#{title}, content=#{content}, userid=#{userid} where bno =#{bno}")
    int update(YuriBoardDTO boardDTO);

    @Delete("delete from yuriboard where bno=#{bno}")
    int delete(int bno);
}
