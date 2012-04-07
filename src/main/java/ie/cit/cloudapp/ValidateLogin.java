/**
 * 
 */
package ie.cit.cloudapp;

/**
 * @author fiona
 *
 */
public class ValidateLogin {
	private Boolean successfulLogin = false;
	//private Boolean correctPassword = false;
	//private Boolean existingUser = false ;
	private int index;
	private String storedPassword;
	
	public Boolean checkUser(String username, String password, LoginRepository logins){
	   if (logins.getLogin().isEmpty())
		   return successfulLogin;
	   else if (logins.getLogin().contains(username) ) {
		   index=logins.getLogin().indexOf(username);
	       storedPassword = logins.getLogin().get(index).getPassword();
		   if(storedPassword==password)
			 return successfulLogin = true;
		   else return successfulLogin;}
	   else return successfulLogin;
		

	}
	
	

}
