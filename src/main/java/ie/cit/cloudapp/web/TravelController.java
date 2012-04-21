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
	@Autowired
	private jdbcTripRepository triprepo;

	private UserInfo userinfo = new UserInfo();
	//private CurrentUser currentuser = new CurrentUser();
	final String existinguser = "Existing User";
	public Integer count;
	
	@RequestMapping(method = RequestMethod.GET)
	public void currentUsr(Model model) {	
	//	model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()))
		count = 0;
		//userinfo.setUsername("");
		model.addAttribute("count",count);
	}

	//@RequestMapping(uri="login", method = RequestMethod.POST)
	@RequestMapping(params = "fname", method = RequestMethod.POST)
	public String userData(Model model, @RequestParam String username,
			@RequestParam String fname, @RequestParam String lname,
			@RequestParam String email) {
		//currentuser.setUsername(username);
		if (! userrepo.getUserData(username).isEmpty())
			// just display stored trips for this user
			model.addAttribute("existinguser",existinguser);
		else {
			//add the user to the database
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		userinfo.setFname(fname);
		userinfo.setLname(lname);
		userinfo.setUserAdded(true);
		userrepo.save(userinfo);
		}
		count = 1;
		model.addAttribute("user", userrepo.getUserData(username));	
		model.addAttribute("trips", triprepo.getAllTrips(username));
		model.addAttribute("count",count);
		return "traveltracker";
	}

	@RequestMapping(params="deptdate", method = RequestMethod.POST)
	public String addTripData(Model model, @RequestParam Date deptdate,
			@RequestParam Date arrdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route ) {
		Trip trip = new Trip();
		Boolean existingtrip = false;
		trip.setDeptdate(deptdate); // this is a date field
		trip.setArrdate(arrdate); // this is a date field
		trip.setDeparture(departure);
		trip.setDestination(destination);
		trip.setRoute(route);
		trip.setUsername(userinfo.getUsername());
		if (! triprepo.getDeptDate(destination, userinfo.getUsername(),deptdate).isEmpty())
			// just display stored trips for this user
		{
			existingtrip=true;
			model.addAttribute("existingtrip",existingtrip);}
		else {
		triprepo.save(trip);
		}
		count = 2;
		model.addAttribute("trips", triprepo.getAllTrips(userinfo.getUsername()));
		model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()));
		model.addAttribute("count",count);
		return "traveltracker";
	}

}
