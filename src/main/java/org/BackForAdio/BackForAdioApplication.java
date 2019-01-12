package org.BackForAdio;



import org.BackForAdio.entiites.AppRole;
import org.BackForAdio.entiites.AppUser;
import org.BackForAdio.entiites.Metier;
import org.BackForAdio.entiites.Note;
import org.BackForAdio.entiites.Ourvrier;
import org.BackForAdio.restService.MetierRestService;
import org.BackForAdio.restService.OuvrierRestService;
import org.BackForAdio.restService.ProduitRestService;
import org.BackForAdio.security.JWTAuthenticationFilter;
import org.BackForAdio.security.JWTAuthorizationFilter;
import org.BackForAdio.security.SecurityConfig;
import org.BackForAdio.service.AccountService;
import org.BackForAdio.service.AccountServiceImpl;
import org.BackForAdio.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackageClasses = SecurityConfig.class)
@ComponentScan(basePackageClasses = MetierRestService.class)
@ComponentScan(basePackageClasses = OuvrierRestService.class)
@ComponentScan(basePackageClasses = ProduitRestService.class)
@ComponentScan(basePackageClasses = AppUser.class)
@ComponentScan(basePackageClasses = AppRole.class)
@ComponentScan(basePackageClasses = UserDetailsServiceImpl.class)
@ComponentScan(basePackageClasses = AccountServiceImpl.class)
@ComponentScan(basePackageClasses = AccountService .class)
@ComponentScan(basePackageClasses = Ourvrier.class)
@ComponentScan(basePackageClasses = Note.class)
@ComponentScan(basePackageClasses = Metier.class)
@ComponentScan(basePackageClasses = JWTAuthenticationFilter.class)
@ComponentScan(basePackageClasses = JWTAuthorizationFilter.class)

public class BackForAdioApplication implements CommandLineRunner{
    
        @Autowired
        private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(BackForAdioApplication.class, args);
	}
        
        
        @Bean
        public BCryptPasswordEncoder getBCPE(){
            
            return new BCryptPasswordEncoder();
        }

        @Override
        public void run(String... args) throws Exception {

            /*accountService.saveUser(new AppUser("babacar", "1234", null));
            accountService.saveRole(new AppRole(null, "ADMIN"));
            accountService.addRoleToUser("babacar", "ADMIN");*/
        }

}

