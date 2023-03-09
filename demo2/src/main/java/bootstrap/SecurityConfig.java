package bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf().disable()
	   		
		   
		   
         .authorizeRequests()
         	
             .anyRequest().authenticated()
             .and()
             
             .formLogin(form -> form
                     .loginPage("/login")
                     .defaultSuccessUrl("/")
                     .failureUrl("/login")
                     .permitAll()
                     );
		
	    return http.build();
	}
	
	

}