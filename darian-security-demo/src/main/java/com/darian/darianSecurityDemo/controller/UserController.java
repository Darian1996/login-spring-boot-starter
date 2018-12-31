package com.darian.darianSecurityDemo.controller;

import com.darian.darianSecurityDemo.dto.User;
import com.darian.darianSecurityDemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "用户服务接口")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userServiceImpl;

    @ApiOperation("得到所有的 User 的集合")
    @GetMapping("/users")
    public List<User> users() {
        return userServiceImpl.users();
    }

    @ApiOperation("根据 id 获取对应的用户信息")
    @GetMapping("/user")
    @ApiImplicitParam(name = "id", dataType = "Long", value = "id")
    public User user(@RequestParam(required = false) Long id) {
        return userServiceImpl.find(id);
    }

    @ApiOperation(value = "添加一个用户",
            notes = "如果没有用户传进来，则后台随机生成一个用户信息")
    @GetMapping("/user/add")
    public boolean add(@RequestBody(required = false) User user) {
        return userServiceImpl.add(user);
    }

    @GetMapping("/meAuthentication")
    @ApiOperation("获取当前的用户的登陆信息Authentication")
    public Authentication getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/mePricipal")
    @ApiOperation("获取当前用户的登陆的 Pricipal 信息")
    public UserDetails getUserPricipal(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}