package ie.cit.cloudapp;
	/**
	 * @author fiona
	 *
	 */
	public class UserInfo {	
		private String username;
		private String fname;
		private String lname;
		private String email;
		private boolean userAdded;
		private boolean addTrip;
		private boolean viewAll;
		private boolean calcDays;
		private Integer id;
		
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

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * @return the lname
		 */
		public String getLname() {
			return lname;
		}
		/**
		 * @param lname the lname to set
		 */
		public void setLname(String lname) {
			this.lname = lname;
		}
		/**
		 * @return the fname
		 */
		public String getFname() {
			return fname;
		}
		/**
		 * @param fname the fname to set
		 */
		public void setFname(String fname) {
			this.fname = fname;
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
		 * @return the isDone
		 */

		/**
		 * @return the addTrip
		 */
		public boolean isAddTrip() {
			return addTrip;
		}
		/**
		 * @param addTrip the addTrip to set
		 */
		public void setAddTrip(boolean addTrip) {
			this.addTrip = addTrip;
		}
		/**
		 * @return the viewAll
		 */
		public boolean isViewAll() {
			return viewAll;
		}
		/**
		 * @param viewAll the viewAll to set
		 */
		public void setViewAll(boolean viewAll) {
			this.viewAll = viewAll;
		}
		/**
		 * @return the calcDays
		 */
		public boolean isCalcDays() {
			return calcDays;
		}
		/**
		 * @param calcDays the calcDays to set
		 */
		public void setCalcDays(boolean calcDays) {
			this.calcDays = calcDays;
		}
		/**
		 * @return the userAdded
		 */
		public boolean isUserAdded() {
			return userAdded;
		}
		/**
		 * @param userAdded the userAdded to set
		 */
		public void setUserAdded(boolean userAdded) {
			this.userAdded = userAdded;
		}
		
		

	}


