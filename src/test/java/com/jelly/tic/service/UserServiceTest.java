package com.jelly.tic.service;

import com.jelly.tic.BaseTest;
import com.jelly.tic.entity.User;
import com.jelly.tic.mapper.UserMapper;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

/** 
* UserService Tester. 
* 
* @author <Authors name> 
* @since <pre>3月 30, 2021</pre> 
* @version 1.0 
*/ 
public class UserServiceTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Mock
    private UserMapper mockUserMapper;

    @Spy
    private User spyUser;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

@Before
public void before() throws Exception {
    // ---------------------- 创建mock对象 --------------------

    // 虚拟对象
    // 1)对所有注解了@Mock的对象进行模拟
//    MockitoAnnotations.initMocks(this);
    // 2)不注解，对单个对象进行mock
    mockUserMapper = Mockito.mock(UserMapper.class);

    // 真实对象(对于合法操作，无需打桩)
    spyUser = Mockito.spy(new User());

    // 构造被测试对象
//    userService = new UserService();

    // ---------------------- 打桩 --------------------------
    // 打桩:有返回值 when().thenReturn / doReturn()
    // 打桩:无返回值 doAnswer(Answer answer)、doNothing()...
    User user = new User();
    user.setId(1L);
    user.setName("admin");
    user.setPassword("123");
//    user.setPassword(passwordEncoder.encode("123"));
    Mockito.when(mockUserMapper.getById(1L)).thenReturn(user);
    Mockito.when(mockUserMapper.getById(4L)).thenReturn(null);

    Mockito.when(mockUserMapper.getByName("admin")).thenReturn(user);
}

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getUserById(Long id) 
* 
*/ 
@Test
public void testGetUserById() throws Exception { 
    // ---------------------- 测试 ------------------------------
    assertEquals(mockUserMapper.getById(1L).getName(),
            userService.getUserById(1L).getName());

    assertEquals("admin", mockUserMapper.getByName("admin").getName());

    assertTrue(passwordEncoder.matches("123", userService.getUserById(1L).getPassword()));

    // ---------------------- 通过verify(mock).someMethod()方法，来验证方法是否被调用 -------------------
    // mock对象一旦创建，就会自动记录自己的交互行为.
    Mockito.verify(mockUserMapper).getById(1L);
    Mockito.verify(mockUserMapper).getByName("admin");

    // ---------------------- 构造参数捕获器，确保所有被Mock的对象的相关方法都已经被Verify过了 ---------------------
    // 目的：保证过程正确，因为错误原因多种，确保验证的是某一逻辑
    ArgumentCaptor<Long> userMapperArgumentCaptor =
            ArgumentCaptor.forClass(Long.class);

    // 验证此方法是否被调用过，且捕获入参
    Mockito.verify(mockUserMapper).getById(userMapperArgumentCaptor.capture());

    // 获取参数
    Long id = userMapperArgumentCaptor.getValue();

    // 验证入参是否是预期的
    assertThat(id, Matchers.is(1L));

    // 确保所有被mock的对象的相关方法都已经被verify了
    Mockito.verifyNoMoreInteractions(mockUserMapper);


} 

/** 
* 
* Method: getUserByName(String username) 
* 
*/ 
@Test
public void testGetUserByName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: register(User user) 
* 
*/ 
@Test
public void testRegister() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updatePassword(String password) 
* 
*/ 
@Test
public void testUpdatePassword() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: signIn(User user) 
* 
*/ 
@Test
public void testSignIn() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: signOut(User user) 
* 
*/ 
@Test
public void testSignOut() throws Exception { 
//TODO: Test goes here... 
} 


} 
