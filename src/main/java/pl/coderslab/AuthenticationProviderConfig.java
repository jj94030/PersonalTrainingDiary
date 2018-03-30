package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProviderConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/PersonalTrainingDiary");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("coderslab");
	    return driverManagerDataSource;
	}
    
    @Bean(name="userDetailsService")
    public UserDetailsService userDetailsService(){
    	JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
    	jdbcImpl.setDataSource(dataSource());
    	jdbcImpl.setUsersByUsernameQuery("select email, password, enabled from PersonalTrainer where email=?");
    	jdbcImpl.setAuthoritiesByUsernameQuery("select b.name, a.roles from PersonalTrainer_roles a, PersonalTrainer b where b.email=? and a.PersonalTrainer_id=b.id");
    	return jdbcImpl;
    }
}
