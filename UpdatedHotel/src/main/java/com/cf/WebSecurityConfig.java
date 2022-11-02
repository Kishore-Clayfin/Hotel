package com.cf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private DataSource dataSource;
     
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
        	.passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from hotelusers where username=?")
            .authoritiesByUsernameQuery("select username, role from hotelusers where username=?")
        ;
    }
//    @Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().httpBasic().and().authorizeRequests()
            
        	.antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
        	.antMatchers("/api/user/**").hasAuthority("ROLE_USER")
        	
        	.anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            //.and()
            
            .and()
            .logout().permitAll();
    }
}
