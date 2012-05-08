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
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fiona
 * 
 */

@Controller
@RequestMapping("/travel/tracker/traveltracker")
public class TravelController {
	@Autowired
	private jdbcUserRepository userrepo;
	@Autowired
	private jdbcTripRepository triprepo;
    public String uname;
    public UserInfo userinfo = new UserInfo();
	
	@RequestMapping(method = RequestMethod.GET)
	public void getTravelTracker(Model model) {	
		userinfo.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("trips", triprepo.getAllTrips(SecurityContextHolder.getContext().getAuthentication().getName()));
		model.addAttribute("user", userrepo.getUserData(SecurityContextHolder.getContext().getAuthentication().getName()));
		
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public void addTripData(Model model, @RequestParam String strdeptdate,
			@RequestParam String strexitdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route ) throws ParseException {
		Trip trip = new Trip();
		Boolean existingtrip = false;
		calculateDays calcdays = new calculateDays();
		
	
		Date deptdate =calcdays.StrToDate(strdeptdate); 
		Date exitdate =calcdays.StrToDate(strexitdate);
	
		
		if (! triprepo.getDeptDate(destination, userinfo.getUsername(), strdeptdate).isEmpty())
			// just display stored trips for this user
		{
			existingtrip=true;
			model.addAttribute("existingtrip",existingtrip);
			}
		else {
			trip.setDeptdate(strdeptdate); // this is stored as a String
			trip.setExitdate(strexitdate); // this is stored as a String
			trip.setDeparture(departure);
			trip.setDestination(destination);
			trip.setRoute(route);
			trip.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			//calculate days and store with trip data
			
		    trip.setDays((int) calcdays.daysBetween(calcdays.DateToCalendar(deptdate),calcdays.DateToCalendar(exitdate)));
		
		    triprepo.save(trip);
		}

		model.addAttribute("trips", triprepo.getAllTrips(SecurityContextHolder.getContext().getAuthentication().getName()));
		model.addAttribute("user", userrepo.getUserData(SecurityContextHolder.getContext().getAuthentication().getName()));
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteTrip(Model model, @RequestParam int tripId) {
		triprepo.delete(tripId);
		model.addAttribute("trips", triprepo.getAllTrips(SecurityContextHolder.getContext().getAuthentication().getName()));
		model.addAttribute("user", userrepo.getUserData(SecurityContextHolder.getContext().getAuthentication().getName()));
	
	}


}
