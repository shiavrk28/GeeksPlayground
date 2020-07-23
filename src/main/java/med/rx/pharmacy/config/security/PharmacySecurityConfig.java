/**
 * 
 */
package med.rx.pharmacy.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import med.rx.utils.RxPharmacyConstants;

/**
 * @author SHIVARAM KRISHNAN
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class PharmacySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 private DataSource dataSource;
	
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private RxPharmacyAuthenticationEntryPoint entryPoint;
	

	
	@Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(RxPharmacyConstants.AUTH_USERNAME_QUERY)
                .authoritiesByUsernameQuery(RxPharmacyConstants.AUTH_AUTHORITIES_QUERY);
    }
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers(RxPharmacyConstants.AUTH_ALL_MATCHER).permitAll().
		and()
		.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())).sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		and().
		exceptionHandling().authenticationEntryPoint(entryPoint).accessDeniedHandler(accessDeniedHandler).
		and()
		.httpBasic();
		
	}

	

}
