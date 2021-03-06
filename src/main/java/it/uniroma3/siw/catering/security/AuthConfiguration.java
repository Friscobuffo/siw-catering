package it.uniroma3.siw.catering.security;

import it.uniroma3.siw.catering.model.userdata.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration @EnableWebSecurity
public class AuthConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource datasource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/index", "/login", "/user/**", "/css/**", "/images/**", "/favicon.ico").permitAll()
                .antMatchers(HttpMethod.POST, "/login", "/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/admin/**").hasAnyAuthority(Credentials.ADMIN_ROLE)
                .antMatchers(HttpMethod.POST, "/admin/**").hasAnyAuthority(Credentials.ADMIN_ROLE)
                .anyRequest().authenticated()
                .and()

                //normal login
                .formLogin().loginPage("/login")
                .defaultSuccessUrl("/default")

                //google login
                .and().oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/defaultGoogle")

                //logout
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true).permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(this.datasource)
                .authoritiesByUsernameQuery("SELECT username, role FROM credentials WHERE username=?")
                .usersByUsernameQuery("SELECT username, password, 1 as enabled FROM credentials WHERE username=?");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
