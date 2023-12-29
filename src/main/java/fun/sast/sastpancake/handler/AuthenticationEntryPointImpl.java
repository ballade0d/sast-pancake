package fun.sast.sastpancake.handler;

import com.alibaba.fastjson2.JSON;
import fun.sast.sastpancake.pojo.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.getWriter().write(JSON.toJSONString(ResultData.fail(401, "用户认证失败， 请重新登录")));
    }
}
