package kr.co.ahaproject.service;

import kr.co.ahaproject.dto.YuriBoardDTO;
import kr.co.ahaproject.mapper.YuriBoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuriBoardService {

    YuriBoardMapper boardMapper;

    public List<YuriBoardDTO> listAll(){
        return boardMapper.listAll();
    }

    public YuriBoardDTO selectOne(int bno){
        return boardMapper.selectOne(bno);
    }

    public int register(YuriBoardDTO boardDTO){
        return boardMapper.register(boardDTO);
    }

    public int update(YuriBoardDTO boardDTO){
        return boardMapper.update(boardDTO);
    }

    public int delete(int bno){
        return boardMapper.delete(bno);
    }
}
