package fun.sast.sastpancake.controller;

import fun.sast.sastpancake.pojo.ResultData;
import fun.sast.sastpancake.pojo.User;
import fun.sast.sastpancake.service.AuthService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public ResultData login(@RequestBody User user) {
        return authService.login(user.getUsername(), user.getPassword());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResultData fix(Exception e){
        e.printStackTrace();
        return ResultData.fail(500, "Internal Server Error");
    }
}
