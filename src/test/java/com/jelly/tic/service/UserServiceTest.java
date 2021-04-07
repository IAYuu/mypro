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
* @since <pre>3�� 30, 2021</pre> 
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
    // ---------------------- ����mock���� --------------------

    // �������
    // 1)������ע����@Mock�Ķ������ģ��
//    MockitoAnnotations.initMocks(this);
    // 2)��ע�⣬�Ե����������mock
    mockUserMapper = Mockito.mock(UserMapper.class);

    // ��ʵ����(���ںϷ������������׮)
    spyUser = Mockito.spy(new User());

    // ���챻���Զ���
//    userService = new UserService();

    // ---------------------- ��׮ --------------------------
    // ��׮:�з���ֵ when().thenReturn / doReturn()
    // ��׮:�޷���ֵ doAnswer(Answer answer)��doNothing()...
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
    // ---------------------- ���� ------------------------------
    assertEquals(mockUserMapper.getById(1L).getName(),
            userService.getUserById(1L).getName());

    assertEquals("admin", mockUserMapper.getByName("admin").getName());

    assertTrue(passwordEncoder.matches("123", userService.getUserById(1L).getPassword()));

    // ---------------------- ͨ��verify(mock).someMethod()����������֤�����Ƿ񱻵��� -------------------
    // mock����һ���������ͻ��Զ���¼�Լ��Ľ�����Ϊ.
    Mockito.verify(mockUserMapper).getById(1L);
    Mockito.verify(mockUserMapper).getByName("admin");

    // ---------------------- ���������������ȷ�����б�Mock�Ķ������ط������Ѿ���Verify���� ---------------------
    // Ŀ�ģ���֤������ȷ����Ϊ����ԭ����֣�ȷ����֤����ĳһ�߼�
    ArgumentCaptor<Long> userMapperArgumentCaptor =
            ArgumentCaptor.forClass(Long.class);

    // ��֤�˷����Ƿ񱻵��ù����Ҳ������
    Mockito.verify(mockUserMapper).getById(userMapperArgumentCaptor.capture());

    // ��ȡ����
    Long id = userMapperArgumentCaptor.getValue();

    // ��֤����Ƿ���Ԥ�ڵ�
    assertThat(id, Matchers.is(1L));

    // ȷ�����б�mock�Ķ������ط������Ѿ���verify��
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
