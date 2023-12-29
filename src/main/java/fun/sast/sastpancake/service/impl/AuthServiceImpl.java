package fun.sast.sastpancake.service.impl;

import fun.sast.sastpancake.pojo.ResultData;
import fun.sast.sastpancake.pojo.User;
import fun.sast.sastpancake.service.AuthService;
import fun.sast.sastpancake.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    public RedisTemplate<String, User> tokenCache;

    @Override
    public ResultData login(String username, String password) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticate = authenticationManager.authenticate(authenticationToken);
            User user = (User) authenticate.getPrincipal();
            String jwt = JwtUtil.generateToken(username);
            Map<String, String> map = new HashMap<>();
            map.put("token", jwt);
            tokenCache.opsForValue().set("login:" + username, user);
            return ResultData.success("登陆成功", map);
        } catch (AuthenticationException e) {
            return ResultData.fail(1002, "用户名或密码错误");
        }
    }
}
