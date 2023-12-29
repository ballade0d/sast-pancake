package fun.sast.sastpancake.service.impl;

import fun.sast.sastpancake.mapper.PancakeMapper;
import fun.sast.sastpancake.pojo.Pancake;
import fun.sast.sastpancake.pojo.ResultData;
import fun.sast.sastpancake.service.PancakeService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PancakeServiceImpl implements PancakeService {

    @Resource
    private PancakeMapper pancakeMapper;

    @Override
    public ResultData getPancake() {
        Map<String, List<Pancake>> map = new HashMap<>();
        map.put("pancakes", pancakeMapper.getPancake());
        return ResultData.success(map);
    }

    @Override
    public ResultData putPancake(Pancake pancake) {
        if(pancake.getTitle() == null){
            return ResultData.fail(400, "Title不能为空");
        }
        if(pancake.getDdl() == null){
            return ResultData.fail(400, "DDL不能为空");
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        pancake.setCreateTime(format.format(date));
        pancakeMapper.putPancake(pancake);
        return ResultData.success("OK");
    }

    @Override
    public ResultData postPancake(int pancakeId) {
        pancakeMapper.postPancake(pancakeId);
        return ResultData.success("OK");
    }

    @Override
    public ResultData deletePancake(int pancakeId) {
        pancakeMapper.deletePancake(pancakeId);
        return ResultData.success("OK");
    }
}
