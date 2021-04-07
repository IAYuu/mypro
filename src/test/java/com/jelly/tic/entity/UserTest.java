package com.jelly.tic.entity;

import com.jelly.tic.BaseTest;
import com.jelly.tic.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

/**
 * User Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3 25, 2021</pre>
 */
public class UserTest extends BaseTest {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;

    private User user;

    @Before
    public void before() throws Exception {
        user = new User();
        user.setName("test");
        user.setPassword("123");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: setName(String username)
     */
    @Test
    public void testSetName() throws Exception {
        user.setName("test");
        assertEquals("test", user.getName());
    }

    /**
     * Method: getName()
     */
    @Test
    public void testGetName() throws Exception {
        user.setName("test");
        assertEquals("test", user.getName());
    }

    /**
     * Method: setPassword(String password)
     */
    @Test
    public void testSetPassword() throws Exception {
        user.setPassword("12");
        assertTrue(passwordEncoder.matches("12", user.getPassword()));
    }

    /**
     * Method: getPassword()
     */
    @Test
    public void testGetPassword() throws Exception {
        assertTrue(passwordEncoder.matches("123", user.getPassword()));
    }

    /**
     * Method: getUser()
     */
    @Test
    public void testGetUser() throws Exception {
        assertEquals(user, user.getUser());
    }

    /**
     * Method: authenticateUserByPassword(String username, String password)
     */
    @Test
    public void testAuthenticateUserByPassword() throws Exception {
//TODO: Test goes here...
    }


} 
