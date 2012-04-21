package ie.cit.cloudapp;

	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.Date;
	import java.util.List;

	import javax.sql.DataSource;

	import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

	public class jdbcTripRepository {
		
		private JdbcTemplate jdbcTemplate;
		
		public jdbcTripRepository(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}
		
		public void save(Trip trip){
			jdbcTemplate.update("insert into TRIPS(deptdate, arrdate, departure, destination, route, username) values (?,?,?,?,?,?)",trip.getDeptdate(),trip.getArrdate(),trip.getDeparture(), trip.getDestination(), trip.getRoute(), trip.getUsername());
		}
 
		public List<Trip> getAllTrips(String username){
			return jdbcTemplate.query("select id, deptdate, arrdate, departure, destination, route, username from TRIPS where username = ?", new Object[]{username}, new TripMapper());
		}

		public List<Trip> getDeptDate(String destination, String username, Date deptdate){
			return jdbcTemplate.query("select id, deptdate, arrdate, departure, destination, route, username from TRIPS where destination=? and username=? and deptdate=?", new Object[]{destination,username,deptdate}, new TripMapper());
		}
	}
		class TripMapper implements RowMapper<Trip>{
			public Trip mapRow(ResultSet rs, int rowNum) throws SQLException{
				Trip trip = new Trip();
				trip.setDeptdate(rs.getDate("deptdate"));
		     	trip.setDeparture(rs.getString("departure"));
			    trip.setDeptdate(rs.getDate("arrdate"));
				trip.setDestination(rs.getString("destination"));
				trip.setRoute(rs.getString("route"));
				//trip.setUserid(rs.getInt("userid"));
				trip.setId(rs.getInt("id"));
				trip.setUsername(rs.getString("username"));
				return trip;
				
			}
		}
		


