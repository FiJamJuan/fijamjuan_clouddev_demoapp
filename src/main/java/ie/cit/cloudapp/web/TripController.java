package ie.cit.cloudapp.web;

import java.util.Date;

import ie.cit.cloudapp.Login;
import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.currentUser;
import ie.cit.cloudapp.jdbcLoginRepository;
import ie.cit.cloudapp.jdbcTripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("addtrip")
@Controller
public class TripController {
	/**
		 * 
		 */

	/**
	 * @author fiona
	 * 
	 */
	@Autowired
	private jdbcTripRepository triprepo;
	private jdbcLoginRepository loginrepo;
	private currentUser currentusr = new currentUser();

	@RequestMapping(method = RequestMethod.GET)
	public void get(Model model) {
		model.addAttribute("trips", triprepo.getAll());
		model.addAttribute("usr", currentusr.getUsername());

	}

	@RequestMapping(params = "username", method = RequestMethod.GET)
	public void getTrip(Model model, @RequestParam String username) {
		currentusr.setUsername(username);
		model.addAttribute("usr", currentusr.getUsername());
	}

	@RequestMapping(method = RequestMethod.POST)
	// public String addTrip(Model model) {
	public String addTrip(Model model, @RequestParam String username,
			@RequestParam Date deptdate, @RequestParam String departure,
			@RequestParam String destination, @RequestParam String route) {
		Trip trip = new Trip();
		trip.setDeptdate(deptdate); // this is a date field
		trip.setDeparture(departure);
		trip.setDestination(destination);
		trip.setRoute(route);
		trip.setUsername(username);
		triprepo.save(trip);
		model.addAttribute("usr", currentusr.getUsername());
		model.addAttribute("trips", triprepo.getAll());
		return "addtrip";
	}

}
