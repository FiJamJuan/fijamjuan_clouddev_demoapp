package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class jdbcUserRepository {
	
		
		private JdbcTemplate jdbcTemplate;
		
		public jdbcUserRepository(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		public void save(UserInfo userinfo){
			jdbcTemplate.update("insert into USERDATA(username, fname, lname, email,userAdded, addTrip, viewAll,calcDays ) values (?,?,?,?,?,?,?,?)",userinfo.getUsername(), userinfo.getFname(), userinfo.getLname(), userinfo.getEmail(), userinfo.isUserAdded(), userinfo.isAddTrip(), userinfo.isViewAll(), userinfo.isCalcDays());
		}
		
	
		public List<UserInfo> getAll(){
			return jdbcTemplate.query("select id, username, fname, lname, email,userAdded, addTrip, viewAll,calcDays from USERDATA", new UserMapper());
		}
		
		public List<UserInfo> getUserData(String username){
			return jdbcTemplate.query("select id, username, fname, lname, email,userAdded, addTrip, viewAll,calcDays from USERDATA where username=?", new Object[]{username}, new UserMapper());
		}
		
		public void delete(int id){
			jdbcTemplate.update("delete from USERDATA where id=?", id);
		}
		
		//public Integer getId(String username){
		//	return jdbcTemplate.queryForInt("select id from USERLOGIN where username = ?", new Object[]{username});
		//}
		
		
	}
		class UserMapper implements RowMapper<UserInfo>{
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
				UserInfo userinfo = new UserInfo();
				userinfo.setEmail(rs.getString("email"));
				userinfo.setFname(rs.getString("fname"));
				userinfo.setLname(rs.getString("lname"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setId(rs.getInt("id"));
				userinfo.setUserAdded(rs.getBoolean("userAdded"));
				userinfo.setAddTrip(rs.getBoolean("addTrip"));
				userinfo.setViewAll(rs.getBoolean("viewAll"));
				userinfo.setCalcDays(rs.getBoolean("calcDays"));
				
				return userinfo;
				
			}
		}
		
		
