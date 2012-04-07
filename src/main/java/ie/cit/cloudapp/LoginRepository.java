/**
 * 
 */

/**
 * @author fiona
 *
 */
package ie.cit.cloudapp;

import ie.cit.cloudapp.Login;

import java.util.ArrayList;
import java.util.List;

	public class LoginRepository {
		private List<Login> logins = new ArrayList<Login>();
	

		public List<Login> getLogin() {
			return logins;
		}

		public void addLogin(Login login) {
			logins.add(login);
		} 
		
	//	public Login getCurrentLogin(String username){
	//		int Index = logins.indexOf(username);
	//		return logins.get(Index);
	//	}

	}


