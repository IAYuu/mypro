package com.jelly.tic.web;

import com.jelly.tic.entity.User;
import com.jelly.tic.service.UserRoleService;
import com.jelly.tic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(getClass());
    private final long ROLE_USER = 2;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/signin")
    public String showLogin() {
        logger.info("-----showLogin----");
//        return "signin.html";
        return "signin.html";
    }

    @RequestMapping("/signin/error")
    public void signinError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf8");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/signin-success")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("当前登录用户： " + name);

        return "home.html";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userService.register(user);
        userRoleService.insert(user.getId(), ROLE_USER);
        return new ModelAndView("register_res.html");
    }

    // TODO: 2021/3/22 修改密码，如何得到user，从而修改password
    @PostMapping("/updatePassword")
    public ModelAndView updatePassword(String password) {
       return null;
    }
}
