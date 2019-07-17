package org.sn.tdsi;



import org.sn.tdsi.Controller.EtudiantController;
import org.sn.tdsi.entiites.AppRole;
import org.sn.tdsi.entiites.AppUser;
import org.sn.tdsi.entiites.Etudiant;
import org.sn.tdsi.security.JWTAuthenticationFilter;
import org.sn.tdsi.security.JWTAuthorizationFilter;
import org.sn.tdsi.security.SecurityConfig;
import org.sn.tdsi.service.AccountService;
import org.sn.tdsi.service.AccountServiceImpl;
import org.sn.tdsi.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackageClasses = SecurityConfig.class)
@ComponentScan(basePackageClasses = AppUser.class)
@ComponentScan(basePackageClasses = AppRole.class)
@ComponentScan(basePackageClasses = UserDetailsServiceImpl.class)
@ComponentScan(basePackageClasses = AccountServiceImpl.class)
@ComponentScan(basePackageClasses = AccountService.class)
@ComponentScan(basePackageClasses = JWTAuthenticationFilter.class)
@ComponentScan(basePackageClasses = JWTAuthorizationFilter.class)
@ComponentScan(basePackageClasses = Etudiant.class)
@ComponentScan(basePackageClasses = EtudiantController.class)
public class TdsiApplication implements CommandLineRunner{
    
        @Autowired
        private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(TdsiApplication.class, args);
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

