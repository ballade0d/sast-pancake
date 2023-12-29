package fun.sast.sastpancake.mapper;

import fun.sast.sastpancake.pojo.Pancake;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PancakeMapper {

    List<Pancake> getPancake();

    void putPancake(Pancake pancake);

    void postPancake(int pancakeId);

    void deletePancake(int pancakeId);
}
