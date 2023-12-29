package fun.sast.sastpancake.handler;

import com.alibaba.fastjson2.JSON;
import fun.sast.sastpancake.pojo.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.getWriter().write(JSON.toJSONString(ResultData.fail(403, "无权限")));
    }
}
