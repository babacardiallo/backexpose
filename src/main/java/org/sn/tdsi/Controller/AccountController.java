package org.sn.tdsi.Controller;

import org.sn.tdsi.entiites.AppUser;
import org.sn.tdsi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/registrer")
	public AppUser registrer(@RequestBody RegisterForm userForm) {
		
		if(!userForm.getPassword().equals(userForm.getRepassword())) {
			throw new RuntimeException("Les mots de passe saisis ne correspondent pas");
		}
		
		AppUser user = accountService.findUserByUsername(userForm.getUsername());
		
		if(user!=null) {
			
			throw new RuntimeException("L'utilisateur saisi existe deja");
		}
		
		AppUser appUser = new AppUser();
		
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		
		accountService.saveUser(appUser);
		
		accountService.addRoleToUser(userForm.getUsername(), "ADMIN");
		
		return appUser;
	}

}
