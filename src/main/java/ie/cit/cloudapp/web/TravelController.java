/**
 * 
 */
package ie.cit.cloudapp.web;

import java.util.Date;

import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.UserInfo;
import ie.cit.cloudapp.jdbcTripRepository;
import ie.cit.cloudapp.jdbcUserRepository;

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

@Controller
@RequestMapping("traveltracker")
public class TravelController {
	@Autowired
	private jdbcUserRepository userrepo;
	private jdbcTripRepository triprepo;;

	private UserInfo userinfo = new UserInfo();
	//private CurrentUser currentuser = new CurrentUser();
   
	
	@RequestMapping(method = RequestMethod.GET)
	public void currentUsr(Model model) {	
	//   model.addAttribute("currentusr", currentuser.getUsername());
		model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()));
	}

	//@RequestMapping(uri="login", method = RequestMethod.POST)
	@RequestMapping(params = "fname", method = RequestMethod.POST)
	public String userData(Model model, @RequestParam String username,
			@RequestParam String fname, @RequestParam String lname,
			@RequestParam String email) {
		//currentuser.setUsername(username);
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		userinfo.setFname(fname);
		userinfo.setLname(lname);
		userinfo.setUserAdded(true);
		userrepo.save(userinfo);
		model.addAttribute("user", userrepo.getUserData(username));
	//	model.addAttribute("currenttest", userinfo.getUsername());
	//	model.addAttribute("currentusr", currentuser.getUsername());
	//	  model.addAttribute("userinfo", userrepo.getUserData(username));	
		return "traveltracker";
	}

	@RequestMapping(params="deptdate", method = RequestMethod.POST)
	public String addTripData(Model model, @RequestParam Date deptdate,
			@RequestParam Date arrdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route ) {
		Trip trip = new Trip();
		trip.setDeptdate(deptdate); // this is a date field
		trip.setArrdate(arrdate); // this is a date field
		trip.setDeparture(departure);
		trip.setDestination(destination);
		trip.setRoute(route);
		trip.setUsername(userinfo.getUsername());
		//triprepo.save(trip);
	  //  model.addAttribute("trips",	triprepo.getAllTrips(userinfo.getUsername()));
		model.addAttribute("trips", trip.getDeptdate());
		model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()));
		return "traveltracker";
	}

}
