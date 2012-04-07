package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class jdbcLoginRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public jdbcLoginRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void save(Login login){
		jdbcTemplate.update("insert into USERLOGIN(username, fname, lname, password, email) values (?,?, ?, ?, ?)",login.getUsername(), login.getFname(), login.getLname(), login.getPassword(), login.getEmail());
	}

	public Login get(String username){
		return jdbcTemplate.queryForObject("select id, fname, lname, password, email from USERLOGIN where username=?", new LoginMapper(), username);
	}
	
	public List<Login> getAll(){
		return jdbcTemplate.query("select id, username, fname, lname, password, email from USERLOGIN", new LoginMapper());
	}
	
	public void delete(int id){
		jdbcTemplate.update("delete from USERLOGIN where id=?", id);
	}
	
	public void updateLname(Login login){
		// example only  - would probably need separate method for each column heading
	   jdbcTemplate.update("update USERLOGIN set lname=? where id=?", login.getLname(), login.getId());
	}
	
	public void updateUsername(Login login){
		// example only  - would probably need separate method for each column heading
	  jdbcTemplate.update("update USERLOGIN set username=? where id=?", login.getUsername(), login.getId());
	}
	
	public void updateFname(Login login){
		// example only  - would probably need separate method for each column heading
	  jdbcTemplate.update("update USERLOGIN set fname=? where id=?", login.getFname(), login.getId());
	}
	
	
	
}
	class LoginMapper implements RowMapper<Login>{
		public Login mapRow(ResultSet rs, int rowNum) throws SQLException{
			Login login = new Login();
			login.setEmail(rs.getString("email"));
			login.setFname(rs.getString("fname"));
			login.setLname(rs.getString("lname"));
			login.setPassword(rs.getString("password"));
			login.setUsername(rs.getString("username"));
			login.setId(rs.getInt("id"));
			return login;
			
		}
	}
	

