package com.jelly.tic.web;

import com.jelly.tic.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.naming.AuthenticationException;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3月 31, 2021</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 使用MockMvc + 所有被Spring管理的bean
@AutoConfigureMockMvc
public class UserControllerTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MockMvc mvc;

    // 无法被扫描到，需要打桩
    @MockBean
    private UserService userService;

    @Before
    public void before() throws Exception {
        // ------------------ 打桩 --------------------------
        // 只有@Controller等某些Bean可以被扫描到，其他需要打桩，如@Service, @Repository
//        Mockito.when(userService.getUserById(1L)).thenReturn(new User());


    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: showLogin()
     */
    @Test
    public void testShowLogin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/signin"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    /**
     * Method: signinError(HttpServletRequest request, HttpServletResponse response)
     */
    @Test(expected = AuthenticationException.class)
    public void testSigninError() throws Exception {
//        assertThat(MockMvcRequestBuilders.get("/signin/error"), AuthenticationException.class);
        mvc.perform(MockMvcRequestBuilders.get("/signin/error"))
                .andDo(print());


    }

    /**
     * Method: showHome()
     */
    @Test
    public void testShowHome() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: printAdmin()
     */
    @Test
    public void testPrintAdmin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: printUser()
     */
    @Test
    public void testPrintUser() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: register()
     */
    @Test
    public void testRegister() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: doRegister(@RequestParam("username") String username, @RequestParam("password") String password)
     */
    @Test
    public void testDoRegister() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: updatePassword(String password)
     */
    @Test
    public void testUpdatePassword() throws Exception {
//TODO: Test goes here... 
    }


} 
