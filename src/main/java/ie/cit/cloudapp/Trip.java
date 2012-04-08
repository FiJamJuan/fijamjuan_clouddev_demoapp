package ie.cit.cloudapp;

import java.util.Date;

public class Trip {
	/**
	 * 
*/

	/**
	 * @author fiona
	 *
	 */ 
	    private Date deptdate;
		private String departure;
		private String destination;
		private String route;
		private Integer id;
		private Integer userid;
		private String username;
		/**
		 * @return the deptdate
		 */
		public Date getDeptdate() {
			return deptdate;
		}
		/**
		 * @param deptdate the deptdate to set
		 */
		public void setDeptdate(Date deptdate) {
			this.deptdate = deptdate;
		}
		/**
		 * @return the departure
		 */
		public String getDeparture() {
			return departure;
		}
		/**
		 * @param departure the departure to set
		 */
		public void setDeparture(String departure) {
			this.departure = departure;
		}
		/**
		 * @return the destination
		 */
		public String getDestination() {
			return destination;
		}
		/**
		 * @param destination the destination to set
		 */
		public void setDestination(String destination) {
			this.destination = destination;
		}
		/**
		 * @return the route
		 */
		public String getRoute() {
			return route;
		}
		/**
		 * @param route the route to set
		 */
		public void setRoute(String route) {
			this.route = route;
		}
		/**
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Integer id) {
			this.id = id;
		}
		/**
		 * @return the userid
		 */
		public Integer getUserid() {
			return userid;
		}
		/**
		 * @param userid the userid to set
		 */
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}


}
