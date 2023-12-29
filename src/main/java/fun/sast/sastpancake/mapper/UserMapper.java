package fun.sast.sastpancake.mapper;

import fun.sast.sastpancake.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUser(String username);
}
