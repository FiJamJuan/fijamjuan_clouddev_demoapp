package ie.cit.cloudapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class jdbcTripRepository {

	private JdbcTemplate jdbcTemplate;

	public jdbcTripRepository(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Trip trip) {
		jdbcTemplate
				.update("insert into TRIPS(deptdate, exitdate, departure, destination, route, username, days) values (?,?,?,?,?,?,?)",
						trip.getDeptdate(), trip.getExitdate(),
						trip.getDeparture(), trip.getDestination(),
						trip.getRoute(), trip.getUsername(), trip.getDays());
	}

	public List<Trip> getAllTrips(String username) {
		return jdbcTemplate
				.query("select id, deptdate, exitdate, departure, destination, route, username, days from TRIPS where username = ? order by deptdate asc",
						new Object[] { username }, new TripMapper());
	}

	public List<Trip> getDeptDate(String destination, String username,String deptdate) {
		return jdbcTemplate
				.query("select id, deptdate, exitdate, departure, destination, route, username, days from TRIPS where destination=? and username=? and deptdate=?",
						new Object[] { destination, username, deptdate },
						new TripMapper());
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from TRIPS where id=?", id);
	}

}

class TripMapper implements RowMapper<Trip> {
	public Trip mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trip trip = new Trip();
		trip.setDeptdate(rs.getString("deptdate"));
		trip.setDeparture(rs.getString("departure"));
		trip.setDeptdate(rs.getString("exitdate"));
		trip.setDestination(rs.getString("destination"));
		trip.setRoute(rs.getString("route"));
		// trip.setUserid(rs.getInt("userid"));
		trip.setId(rs.getInt("id"));
		trip.setUsername(rs.getString("username"));
		trip.setDays(rs.getInt("days"));
		return trip;

	}
}
