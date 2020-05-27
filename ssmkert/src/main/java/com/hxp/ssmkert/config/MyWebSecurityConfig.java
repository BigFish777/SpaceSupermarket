package com.hxp.ssmkert.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.NonceExpiredException;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 一颗小土豆
 * \* Date: 2020/5/27
 * \* Time: 9:48
 * \
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 用户详细信息服务
     * @return
     */
//    自定义 MyUserDetailsService
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p2").build());
//        manager.createUser(User.withUsername("admin").password("123").authorities("p2","p1").build());
//        return manager;
//    }

    /**
     * 密码比对解析器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/p/p2").hasAnyAuthority("p1","p2")
                .antMatchers("/p/p1").hasAuthority("p1")
                .antMatchers("/p/**").authenticated()
                .anyRequest().permitAll()//其余的全部允许
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(((httpServletRequest, httpServletResponse, authentication) -> {
//                    认证成功时
                    httpServletResponse.setStatus(200);
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    Map<String, Object> map = new HashMap<>();
                    map.put("status","200");
                    map.put("msg","登陆成功");
                    ObjectMapper mapper = new ObjectMapper();
                    out.write(mapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                }))
                .failureHandler(((httpServletRequest, httpServletResponse, e) -> {
//                    认证失败时
                    httpServletResponse.setStatus(401);
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    Map<String, Object> map = new HashMap<>();
                    map.put("status","401");
                    if (e instanceof BadCredentialsException){
                        map.put("msg","帐号或密码不正确");
                    }else if (e instanceof UsernameNotFoundException){
                        map.put("msg","帐号或密码不正确");
                    }else if (e instanceof AccountStatusException){
                        map.put("msg","帐号已被冻结");
                    }else if (e instanceof NonceExpiredException){
                        map.put("msg","登录已过期");
                    }else if (e instanceof AuthenticationServiceException){
                        map.put("msg","服务器出现错误，请稍后重试！");
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    out.write(mapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                }))
                .permitAll()
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable().cors()
                .and()
                .exceptionHandling().accessDeniedHandler(((httpServletRequest, httpServletResponse, e) -> {
                    //处理权限不足
                    httpServletResponse.setStatus(403);
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    Map<String, Object> map = new HashMap<>();
                    map.put("status","403");
                    map.put("msg","权限不足");
                    ObjectMapper mapper = new ObjectMapper();
                    out.write(mapper.writeValueAsString(map));
                    out.flush();
                    out.close();
                }));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/html/**","/js/**","/images/**");
    }
}
