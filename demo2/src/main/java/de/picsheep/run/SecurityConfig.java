package de.picsheep.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
	
	  @Autowired
	   private UserDetailsService userDetailsService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  http.csrf().disable()
	   		
		   
		   
          .authorizeRequests()
          	.requestMatchers("/deleteUser").permitAll()
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
	 
	   @SuppressWarnings("deprecation")
	   @Bean
	   public static NoOpPasswordEncoder passwordEncoder() {
	   return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	   }

	   @Autowired
	   public void globalSecurityConfiguration(AuthenticationManagerBuilder auth) throws Exception {
	       auth.userDetailsService(userDetailsService);
	   }

	

}