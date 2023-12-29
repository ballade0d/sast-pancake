package fun.sast.sastpancake.filter;

import com.alibaba.fastjson2.JSON;
import fun.sast.sastpancake.pojo.ResultData;
import fun.sast.sastpancake.pojo.User;
import fun.sast.sastpancake.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    public RedisTemplate<String, User> tokenCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token
        String username;
        try {
            Claims claims = JwtUtil.getClaims(token);
            username = claims.getSubject();
        } catch (Exception e) {
            response.getWriter().write(JSON.toJSONString(ResultData.fail(401, "用户认证失败， 请重新登录")));
            return;
        }
        // 从redis中获取用户信息
        User user = tokenCache.opsForValue().get("login:" + username);
        if (Objects.isNull(user)) {
            response.getWriter().write(JSON.toJSONString(ResultData.fail(401, "用户认证失败， 请重新登录")));
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
