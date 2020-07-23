package med.rx.pharmacy.audit;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import med.rx.pharmacy.repository.UserRepository;

@Configuration
@EnableJpaAuditing
public class AuditConfiguration {

	/*
	 * @Autowired UserService service;
	 */

	@Autowired
	UserRepository repo;

	@Bean("auditorProvider")
	public AuditorAware<Integer> auditorProvider() {
		return () -> {
			Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
			User authUser = ((User) authentication.getPrincipal());
			Integer usrid = 0;
			try {
				usrid = repo.fetchUserId(authUser.getUsername());
			} catch (Exception ex) {
			}
			return (authentication != null && authentication.isAuthenticated()) ? Optional.of(usrid) : null;
			// return Optional.of(1);
	        };
	    }
	

}
