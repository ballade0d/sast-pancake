package fun.sast.sastpancake.service;

import fun.sast.sastpancake.pojo.Pancake;
import fun.sast.sastpancake.pojo.ResultData;

public interface PancakeService {

    ResultData getPancake();

    ResultData putPancake(Pancake pancake);

    ResultData postPancake(int pancakeId);

    ResultData deletePancake(int pancakeId);
}
