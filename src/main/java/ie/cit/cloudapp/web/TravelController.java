/**
 * 
 */
package ie.cit.cloudapp.web;

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

/**
 * @author fiona
 * 
 */

@Controller
@RequestMapping("/travel/login/main")
public class TravelController {
	@Autowired
	private jdbcUserRepository userrepo;
	@Autowired
	private jdbcTripRepository triprepo;

	private UserInfo userinfo = new UserInfo();
	public String usermessage;
	public Integer count;
	
	
	@RequestMapping(value="/travel/login/main", method = RequestMethod.GET)
	public String main(Model model) {	
	
		return "travel/login/main";
	}
 

	@RequestMapping(value = "/travel/login/main", method = RequestMethod.POST)
	public String initialSelection(Model model, @RequestParam String select) {
		
	if (select == "1")
			return "travel/login/registeruser";
	else if (select == "2")
		return "travel/traveltracker";
	}
	
	
	@RequestMapping(value="/travel/traveltracker", method = RequestMethod.GET)
	public void currentUsr(Model model) {	
		count = 0;
		model.addAttribute("count",count);
	}
    //SecurityContextHolder.getContext().getAuthentication().getName()
	//@RequestMapping(uri="login", method = RequestMethod.POST)
	@RequestMapping(params = "pwd", method = RequestMethod.POST)
	public String userData(Model model, @RequestParam String username,
			@RequestParam String pwd, @RequestParam String home,
			@RequestParam String email) {
		//validate the data
		
		if ((! userrepo.getUserData(username).isEmpty()) &&( (userrepo.getUserPwd(username).containsValue(pwd))))
		{
			// welcome user back and display stored trips for this user
		    // check that password matches
			usermessage = "Welcome back " + username + " please add a new trip:";
			userrepo.updateAddtrip(true, username);

		}
		else if ((! userrepo.getUserData(username).isEmpty()) &&( (! userrepo.getUserPwd(username).containsValue(pwd))))
		{
			// send back incorrect password message
			usermessage = "This username " + username +" already exists, the password does not match our records.</br> Please contact admin at admin@email.com to reset it";
			userinfo.setAddtrip(false);
			userrepo.updateAddtrip(false, username);
			
		}
		else {
			//add the user to the database
		usermessage = "Welcome " + username +". Please add a new trip:";
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		userinfo.setPwd(pwd);
		userinfo.setHome(home);
		userinfo.setAddtrip(true);
		userrepo.save(userinfo);
		}
		count = 1;
		model.addAttribute("user", userrepo.getUserData(username));	
		model.addAttribute("trips", triprepo.getAllTrips(username));
		model.addAttribute("usermessage", usermessage);
		model.addAttribute("count",count);
		return "travel/traveltracker";
	}

	@RequestMapping(params="strdeptdate", method = RequestMethod.POST)
	public String addTripData(Model model, @RequestParam String strdeptdate,
			@RequestParam String strexitdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route ) throws ParseException {
		Trip trip = new Trip();
		Boolean existingtrip = false;
		calculateDays calcdays = new calculateDays();
		Date deptdate =calcdays.StrToDate(strdeptdate); 
		Date exitdate =calcdays.StrToDate(strexitdate);
		
		if (! triprepo.getDeptDate(destination, userinfo.getUsername(), deptdate).isEmpty())
			// just display stored trips for this user
		{
			existingtrip=true;
			model.addAttribute("existingtrip",existingtrip);}
		else {
			
			trip.setDeptdate(deptdate); // this is a date field
			trip.setExitdate(exitdate); // this is a date field
			trip.setDeparture(departure);
			trip.setDestination(destination);
			trip.setRoute(route);
			trip.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			//calculate days and store with trip data
			
		    trip.setDays((int) calcdays.daysBetween(calcdays.DateToCalendar(deptdate),calcdays.DateToCalendar(exitdate)));
		triprepo.save(trip);
		}
		count = 2;
		model.addAttribute("trips", triprepo.getAllTrips(userinfo.getUsername()));
		model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()));
		model.addAttribute("count",count);
		return "travel/traveltracker";
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteTrip(Model model, @RequestParam int tripId) {
		triprepo.delete(tripId);
		model.addAttribute("trips", triprepo.getAllTrips(userinfo.getUsername()));
		model.addAttribute("user", userrepo.getUserData(userinfo.getUsername()));
		model.addAttribute("count",count);
	}


}
