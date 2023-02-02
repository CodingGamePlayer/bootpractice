package kr.co.ahaproject.service;

import kr.co.ahaproject.dto.YuriBoardDTO;
import kr.co.ahaproject.mapper.YuriBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YuriBoardService {
    @Autowired
    YuriBoardMapper yuriBoardMapper;

    public List<YuriBoardDTO> listAll(){
        return yuriBoardMapper.listAll();
    }

    public YuriBoardDTO selectOne(int bno){
        return yuriBoardMapper.selectOne(bno);
    }

    public int register(YuriBoardDTO boardDTO){
        return yuriBoardMapper.register(boardDTO);
    }

    public int update(YuriBoardDTO boardDTO){
        return yuriBoardMapper.update(boardDTO);
    }

    public int delete(int bno){
        return yuriBoardMapper.delete(bno);
    }
}
