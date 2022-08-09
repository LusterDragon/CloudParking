package one.digitalinovation.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


	@Bean
	// Configuring Authorization
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/swagger-resources/**").permitAll()
		.antMatchers("/webjars/**").permitAll()
		.antMatchers("/v2/api-docs/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/csrf").permitAll()
		.antMatchers("/*.js").permitAll()
		.antMatchers("/*.css").permitAll()
		.antMatchers("/*.ico").permitAll()
		.antMatchers("/*.png").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
	}


}
