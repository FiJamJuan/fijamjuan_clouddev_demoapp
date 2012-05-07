/**
 * 
 */
package ie.cit.cloudapp.web;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.UserInfo;
import ie.cit.cloudapp.calculateDays;
import ie.cit.cloudapp.hashPassword;
import ie.cit.cloudapp.jdbcTripRepository;
import ie.cit.cloudapp.jdbcUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fiona
 * 
 */

@Controller
@RequestMapping("travel/login/registeruser")
public class RegistrationController {
	@Autowired
	private jdbcUserRepository userrepo;

	private UserInfo userinfo = new UserInfo();
	public String usermessage;
	public Integer count;
	public String message ="";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void main(Model model) {	
	
		//return "registeruser";
		
	}

	//SecurityContextHolder.getContext().getAuthentication().getName()
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerUserData(Model model, @RequestParam String username,
			@RequestParam String pwd, @RequestParam String home,
			@RequestParam String email) throws IOException, NoSuchAlgorithmException {
		//add the user to the database
		Boolean userexists=false;
		if (! SecurityContextHolder.getContext().getAuthentication().getName().isEmpty())
			//clear session data
			SecurityContextHolder.getContext().setAuthentication(null);
		//first check if existing user.
		if (! userrepo.getUserData(username).isEmpty())
		{
			userexists = true;
			model.addAttribute("userexists",userexists);
			return ("redirect:../../travel/login/registeruser.html");
		    
		}
	
	
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		// create md5 hash of password
		hashPassword hpw = new hashPassword();
		String pass = hpw.md5password(pwd);
	
		userinfo.setPwd(pass);
		userinfo.setHome(home);
		userinfo.setAddtrip(true);
		userrepo.save(userinfo);
	    ///return to login page
	
	    return ("redirect:../../travel/tracker/traveltracker.html");
	  

	}
}
