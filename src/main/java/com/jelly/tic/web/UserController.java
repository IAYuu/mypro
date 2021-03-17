package com.jelly.tic.web;

import com.jelly.tic.entity.User;
import com.jelly.tic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register.html");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam("name") String name, @RequestParam("password") String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        boolean isRegister = false;
        if (userService.register(user)) {
            isRegister = true;
        }
        return new ModelAndView("register_res.html", Map.of("isRegister", isRegister));
    }

//    @PostMapping("/signin")
//    public ModelAndView doSignIn(User user, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String password = req.getParameter("password");
//        String expectedPassword = user.getPassword();
//        if (expectedPassword != null && expectedPassword.equals((password))) {
//            req.getSession().setAttribute("user", name);
//        } else {
//            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
//        }
//        return new ModelAndView("signin.html", Map.of("user", user));
//    }

}
