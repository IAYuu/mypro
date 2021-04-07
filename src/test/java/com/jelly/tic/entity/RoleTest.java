package com.jelly.tic.entity;

import com.jelly.tic.BaseTest;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Role Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3ÔÂ 30, 2021</pre>
 */
public class RoleTest extends BaseTest {

    private Role role;

    @Before
    public void before() throws Exception {
        role = new Role();
        role.setName("admin");
        role.setId(123L);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getName()
     */
    @Test
    public void testGetName() throws Exception {
        assertEquals("admin", role.getName());
    }

    /**
     * Method: setName(String name)
     */
    @Test
    public void testSetName() throws Exception {
        role.setName("user");
        assertEquals("user", role.getName());
    }

    // extends AbstractEntity
    @Test
    public void testGetId() throws Exception {
        assertEquals("123", role.getId().toString());
    }

    // extends AbstractEntity
    @Test
    public void testSetId() throws Exception{
        role.setId(12L);
        assertEquals("12", role.getId().toString());
    }
}
