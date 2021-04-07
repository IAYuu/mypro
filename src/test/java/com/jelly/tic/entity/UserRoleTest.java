package com.jelly.tic.entity;

import com.jelly.tic.BaseTest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * UserRole Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3 25, 2021</pre>
 */
public class UserRoleTest extends BaseTest{

    UserRole userRole;

    @Before
    public void before() throws Exception {
        userRole = new UserRole();
        userRole.setRoleId(123L);
        userRole.setUserId(123L);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getUserId()
     */
    @Test
    public void testGetUserId() throws Exception {
        assertEquals("123", userRole.getUserId().toString());
    }

    /**
     * Method: setUserId(Long userId)
     */
    @Test
    public void testSetUserId() throws Exception {
        userRole.setUserId(12L);
        assertEquals("12", userRole.getUserId().toString());
    }

    /**
     * Method: getRoleId()
     */
    @Test
    public void testGetRoleId() throws Exception {
        assertEquals("123", userRole.getRoleId().toString());
    }

    /**
     * Method: setRoleId(Long roleId)
     */
    @Test
    public void testSetRoleId() throws Exception {
        userRole.setRoleId(12L);
        assertEquals("12", userRole.getRoleId().toString());
    }


} 
