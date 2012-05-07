package ie.cit.cloudapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/travel/login/login")
public class SecurityLoginController {
//controller to render login.html for username and password

		
		@RequestMapping(method = RequestMethod.GET)
		public void getTravelTracker(Model model) {	
			//
			
		}
		
		@RequestMapping(params="error", method = RequestMethod.GET)
		public String getLoginError(Model model, @RequestParam String error) {	
			
				String errormsg="Access denied - incorrect username or password. Please try again.";
				model.addAttribute("error", errormsg);
				return ("/travel/login/login");

			
		}
		
}
