/**
 * 
 */
package ie.cit.cloudapp.web;

import ie.cit.cloudapp.Login;
import ie.cit.cloudapp.LoginRepository;
import ie.cit.cloudapp.ValidateLogin;
import ie.cit.cloudapp.jdbcLoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fiona
 * 
 */
@RequestMapping("login")
@Controller
public class LoginController {

	@Autowired
	private jdbcLoginRepository loginrepo;

	@RequestMapping(method = RequestMethod.GET)
	public void listLogins(Model model) {
		model.addAttribute("logins", loginrepo.getAll());
	}

	@RequestMapping(method = RequestMethod.POST, params="username")
	public String userLogin(Model model, @RequestParam String username,
			@RequestParam String password) {
		//For now this will just add the login to the repository
		// Later this should be validated against existing username and pwd.
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		loginrepo.save(login);
		model.addAttribute("logins", loginrepo.getAll());		
		return "mainmenu";
	}

	@RequestMapping(method = RequestMethod.POST, params="fname")
	public String registerUser(Model model, @RequestParam String fname, @RequestParam String lname, @RequestParam String newusername,
			@RequestParam String newpassword, @RequestParam String email) {
		Login login = new Login();
		login.setUsername(newusername);
		login.setPassword(newpassword);
		login.setEmail(email);
		login.setFname(fname);
		login.setLname(lname);
		loginrepo.save(login);
		model.addAttribute("logins", loginrepo.getAll());	
		return "mainmenu";
	}
}
