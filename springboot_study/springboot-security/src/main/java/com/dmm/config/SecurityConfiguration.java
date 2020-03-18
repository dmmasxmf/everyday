package com.dmm.config;

import com.dmm.entry.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.inject.Inject;
import javax.inject.Qualifier;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/3 10:41
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService userDetailsService;

    /**
     * 责任链
     * 主要配置路径，也就是资源的访问权限（是否需要认证，需要什么角色等）
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * authorizeRequests() 定义哪些URL需要被保护、哪些不需要被保护。 formLogin() 定义当需要用户登录时候，转到的登录页面。
         * 此时，我们并没有写登录页面，但是spring security默认提供了一个登录页面，以及登录控制器
         */

//        http
//                .formLogin() //定义当需要用户登录时候，转到的登录页面。
//                .and()
//                .authorizeRequests()
//                .antMatchers("/product") // 定义哪些URL需要被保护、哪些不需要被保护
//                .hasRole("user")
//                .anyRequest() // 任何请求,登录后可以访问
//                .authenticated()
//                .antMatchers("/admin").hasRole("admin")
//                ;

        http
                //每个子匹配器将会按照声明的顺序起作用 认证请求
                .authorizeRequests()
                // 指定用户可以访问的多个url模式。特别的，任何用户可以访问以"/resources"开头的url资源
                //.antMatchers( "/resources/**", "/hello","/aa").permitAll()
                //.antMatchers("/product/**").hasRole("USER")
                //任何以"/admin"开头的请求限制用户具有 "ROLE_ADMIN"角色。你可能已经注意的，尽管我们调用的hasRole方法，但是不用传入"ROLE_"前缀
                //.antMatchers("/admin/**").hasRole("ADMIN")

                //任何以"/db"开头的请求同时要求用户具有"ROLE_ADMIN"和"ROLE_DBA"角色。
                //.antMatchers( "/db/**").access("hasRole('ADMIN') and hasRole('USER')")
                //任何没有匹配上的其他的url请求，只需要用户被验证
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(
                            O fsi) {
                        fsi.setSecurityMetadataSource(mySecurityMetadataSource());
                        fsi.setAccessDecisionManager(myAccessDecisionManager());
                        return fsi;
                    }
                })
                //忽略登录界面 提供登录参数和
                .and().formLogin().loginProcessingUrl("/login")
                .and().apply(securityConfigurerAdapter())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and().httpBasic()
        ;
    }

    @Bean
    public FilterInvocationSecurityMetadataSource mySecurityMetadataSource() {
        MyFilterInvocationSecurityMetadataSource securityMetadataSource = new MyFilterInvocationSecurityMetadataSource();
        return securityMetadataSource;
    }

    @Bean
    public AccessDecisionManager myAccessDecisionManager() {
        return new MyAccessDecisionManager();
    }
    /**
     * 权限验证
     * 主要配置身份认证来源，也就是用户及其角色
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
// 缓存中的用户
        //        auth
//                .inMemoryAuthentication()
//                .withUser("admin1") // 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
//                .password("{noop}admin1")  //
//                .roles("ADMIN", "USER")
//                .and()
//                .withUser("user1").password("{noop}user1") // 普通用户，只能访问 /product/**
//                .roles("USER");

        //数据库用户
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    public static void main(String[] args) {
//        String pass = "123456";
//        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//        String hashPass = bcryptPasswordEncoder.encode(pass);
//        System.out.println(hashPass);
//    }

    @Inject
    private TokenProvider tokenProvider;

    // 增加方法
    private MyAuthTokenConfigurer securityConfigurerAdapter() {
        return new MyAuthTokenConfigurer(userDetailsService, tokenProvider);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

