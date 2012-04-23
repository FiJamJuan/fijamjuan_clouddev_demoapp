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
			jdbcTemplate.update("insert into USERDATA(username, pwd, email,home, addtrip ) values (?,?,?,?,?)",userinfo.getUsername(), userinfo.getPwd(),  userinfo.getEmail(), userinfo.getHome(), userinfo.getAddtrip());
		}
		
	
		public List<UserInfo> getAll(){
			return jdbcTemplate.query("select id, username, pwd, email, home, addtrip from USERDATA", new UserMapper());
		}
		
		public List<UserInfo> getUserData(String username){
			return jdbcTemplate.query("select id, username, pwd, email, home, addtrip from USERDATA where username=?", new Object[]{username}, new UserMapper());
		}
		
		public Map<String,Object> getUserPwd(String username){
			return jdbcTemplate.queryForMap("select pwd from USERDATA where username=?", new Object[]{username});
		}
		
		public void delete(int id){
			jdbcTemplate.update("delete from USERDATA where id=?", id);
		}
		
		
		public void updateAddtrip(Boolean addtrip, String username){
			jdbcTemplate.update("update USERDATA set addtrip=? where username =?", addtrip, username);
		}
		//public Integer getId(String username){
		//	return jdbcTemplate.queryForInt("select id from USERLOGIN where username = ?", new Object[]{username});
		//}
		
		
	}
		class UserMapper implements RowMapper<UserInfo>{
			public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException{
				UserInfo userinfo = new UserInfo();
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPwd(rs.getString("pwd"));
				userinfo.setEmail(rs.getString("home"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setAddtrip(rs.getBoolean("addtrip"));
				userinfo.setId(rs.getInt("id"));
				
				
				return userinfo;
				
			}
		}
		
		
