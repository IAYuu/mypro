package com.jelly.tic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
/** @EnableWebSecurity 加载了
 * 1. WebSecurityConfiguration （配置安全信息）和，
 *      1.1 声明 SpringSecurityFilterChain(spring security核心过滤器， 认证入口)
 * 2. AuthenticationConfiguration （配置认证信息，生成AuthenticationManaget）
 * 3. WebSecurityConfigurerAdapter 选择性修改配置
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;


    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 如果token表不存在，使用下面语句初始化该表
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    // 在内存中配置用户
    @Override
    // 暴露AuthenticationManager建造器
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }

    // 定义被拦截的url路径
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置路径拦截
        http.authorizeRequests()
                .antMatchers("/").authenticated()
                .anyRequest()
                .authenticated()
                .and()
                // 表单认证相关
                // 设置登录页
                .formLogin().loginPage("/signin")
                // 设置登录成功页
                .defaultSuccessUrl("/signin-success").permitAll()
                .failureUrl("/signin/error")
                //自定义登录用户名和密码参数， 默认为username和password
//                .usernameParameter("username")
//                .usernameParameter("password")
                .and()
                // 注销相关配置
                .logout().permitAll()
                .and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                // 有效时间：单位s
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService);
        // TODO: 2021/3/18 [学习] 关闭CSRF跨域
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件，对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

}
