package fun.sast.sastpancake.service;

import fun.sast.sastpancake.pojo.ResultData;

public interface AuthService {

    ResultData login(String username, String password);
}
