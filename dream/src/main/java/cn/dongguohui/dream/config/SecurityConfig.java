package cn.dongguohui.dream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("admin").password("123456").roles("admin")
                .and().withUser("user").password("123456").roles("admin");
    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http
                .authorizeRequests()//开启验证
                .mvcMatchers("/test").hasRole("admin")//test接口具有admin的权限
                .anyRequest().authenticated()//剩余接口 登录之后就能访问
                .and();
//                .formLogin()
//                //定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
//                .loginPage("/test");
    }
}
