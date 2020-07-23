package med.rx.pharmacy.config.security;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	 @Bean
	    public DataSource getDataSource() {
	       DataSource ds= DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver")
	        .url("jdbc:mysql://localhost:3306/rx_pharmacy?useSSL=false&allowPublicKeyRetrieval=true")
	        .username("root")
	        .password("admin")
	        .build();
	        return ds;
	    }

}
