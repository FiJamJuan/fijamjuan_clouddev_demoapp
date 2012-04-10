package ie.cit.cloudapp;

	import java.sql.ResultSet;
	import java.sql.SQLException;
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
			jdbcTemplate.update("insert into TRIPS(deptdate, departure, destination, route, username) values (?,?,?, ?, ?)",trip.getDeptdate(),trip.getDeparture(), trip.getDestination(), trip.getRoute(), trip.getUsername());

		}
		
		public List<Trip> getAll(){
			return jdbcTemplate.query("select id,deptdate, departure, destination, route, username from TRIPS", new TripMapper());
		}
		
		
	
		
		
	}
		class TripMapper implements RowMapper<Trip>{
			public Trip mapRow(ResultSet rs, int rowNum) throws SQLException{
				Trip trip = new Trip();
				trip.setDeptdate(rs.getDate("deptDate"));
			trip.setDeparture(rs.getString("departure"));
				trip.setDestination(rs.getString("destination"));
				trip.setRoute(rs.getString("route"));
				//trip.setUserid(rs.getInt("userid"));
				trip.setId(rs.getInt("id"));
				trip.setUsername(rs.getString("username"));
				return trip;
				
			}
		}
		


