/**
 * 
 */
package ie.cit.cloudapp.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.UserInfo;
import ie.cit.cloudapp.calculateDays;
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
@RequestMapping("/travel/login/main")
public class LoginController {

	public String usermessage;
	public Integer count;
	public String message ="";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void main(Model model) {	
		if (! SecurityContextHolder.getContext().getAuthentication().getName().isEmpty())
			//clear any previous session data and force user to login or register
			SecurityContextHolder.getContext().setAuthentication(null);
		//return "main";
	}


	
	@RequestMapping(params="select", method = RequestMethod.POST)
	public String register(Model model, @RequestParam String select) {
	model.addAttribute("select",select);
			return "redirect:../../travel/login/registeruser.html";
	
	
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model) {
			return "redirect:../../travel/tracker/traveltracker.html";
	
	
	
	}
	
	

}
