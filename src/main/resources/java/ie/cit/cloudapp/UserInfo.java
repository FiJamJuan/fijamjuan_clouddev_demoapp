package ie.cit.cloudapp;
	/**
	 * @author fiona
	 *
	 */
	public class UserInfo {	
		private String username;
		private String pwd;
		private String email;
		private String home;
		private Boolean addtrip;
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
		 * @return the pwd
		 */
		public String getPwd() {
			return pwd;
		}
		/**
		 * @param pwd the pwd to set
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		/**
		 * @return the home
		 */
		public String getHome() {
			return home;
		}
		/**
		 * @param home the home to set
		 */
		public void setHome(String home) {
			this.home = home;
		}
		/**
		 * @return the addtrip
		 */
		public Boolean getAddtrip() {
			return addtrip;
		}
		/**
		 * @param addtrip the addtrip to set
		 */
		public void setAddtrip(Boolean addtrip) {
			this.addtrip = addtrip;
		}
		
	}


