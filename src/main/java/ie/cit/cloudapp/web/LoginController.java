/**
 * 
 */
package ie.cit.cloudapp.web;

import ie.cit.cloudapp.Login;
import ie.cit.cloudapp.LoginRepository;
import ie.cit.cloudapp.ValidateLogin;

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
	private LoginRepository loginrepo;

	@RequestMapping(method = RequestMethod.GET)
	public void listLogins(Model model) {
		model.addAttribute("logins", loginrepo.getLogin());
	}

	@RequestMapping(method = RequestMethod.POST, params="username")
	public String userLogin(Model model, @RequestParam String username,
			@RequestParam String password) {
		// first check if user exists and password is correct ValidateLogin
		// ValidateLogin validate = new ValidateLogin();
		// /if (validate.checkUser(username, password, loginrepo)==true)
		// {
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		loginrepo.addLogin(login);
		model.addAttribute("logins", loginrepo.getLogin());
		// model.addAttribute("logins", loginrepo.getCurrentLogin(username));
		return "mainmenu";
		// }
		// successful login - next page served showing existing trips
		// unsuccessful login page
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
		loginrepo.addLogin(login);
		model.addAttribute("logins", loginrepo.getLogin());
		// model.addAttribute("logins", loginrepo.getCurrentLogin(username));
		return "mainmenu";
	}
}
