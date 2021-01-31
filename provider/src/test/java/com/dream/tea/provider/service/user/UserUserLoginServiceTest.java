package com.dream.tea.provider.service.user;

import com.dream.tea.service.model.user.User;
import com.dream.tea.service.service.user.UserLoginService;
import com.dream.tea.service.service.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserUserLoginServiceTest {

    @Resource
    private UserLoginService userLoginService;

    @Resource
    private UserService userService;


    @Test
    public void registerTest() {
        User user = new User();
        user.setAccount("18719361408");
        user.setPassword("yaya1997");
        userLoginService.register(user);
        System.out.println(user.getId());
    }

    @Test
    public void getUserByIdTest() {
        User user = userService.getUserById(214L);
        System.out.println(user.toString());
    }
}
