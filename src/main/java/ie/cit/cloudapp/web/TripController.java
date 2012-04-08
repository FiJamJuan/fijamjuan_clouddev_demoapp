
	package ie.cit.cloudapp.web;

	import java.util.Date;

	import ie.cit.cloudapp.Trip;
import ie.cit.cloudapp.jdbcTripRepository;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


	@RequestMapping("mainmenu")
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
		    @RequestMapping(method = RequestMethod.GET)
					public void getTrip(Model model) {
					//	model.addAttribute("trips", triprepo.getAll());
					}
			
			
		    @RequestMapping(method = RequestMethod.GET,params="viewall")
			public void listAll(Model model) {
				model.addAttribute("trips", triprepo.getAll());
			}


			@RequestMapping(method = RequestMethod.POST, params="addtrip")
			public String addTrip(Model model, @RequestParam String username, @RequestParam Date deptdate, @RequestParam String departure, @RequestParam String destination,
					@RequestParam String route, @RequestParam String userid) {
				Trip trip = new Trip();
			    trip.setDeptdate(deptdate); //this is a date field
				trip.setDeparture(departure);
				trip.setDestination(destination);
				trip.setRoute(route);
				trip.setUserid(27);
				trip.setUsername(username);
				triprepo.save(trip);
				model.addAttribute("trips", triprepo.getAll());	
				return "viewall";
			}

	}
