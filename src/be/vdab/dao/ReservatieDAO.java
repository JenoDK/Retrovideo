package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Reservatie;

public class ReservatieDAO extends AbstractDAO {
	private final static Logger logger = Logger.getLogger(GenreDAO.class
			.getName());
	private static final String CREATE_SQL = "INSERT INTO retrovideo.reservaties(klantid, filmid, reservatieDatum) values (?,?,?);";
	private static final String FIND_ALL_SQL = "SELECT klantid, filmid, klanten.familienaam, klanten.voornaam, "
			+ "films.titel , reservatieDatum FROM retrovideo.reservaties "
			+ "INNER JOIN klanten ON reservaties.klantid = klanten.id "
			+ "INNER JOIN films ON reservaties.filmid = films.id;";
	private static final String DELETE_SQL = "DELETE FROM retrovideo.reservaties WHERE klantid = ? AND filmid = ?";

	public void create(Reservatie reservatie) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						CREATE_SQL, Statement.RETURN_GENERATED_KEYS)) {
			statement.setLong(1, reservatie.getKlantid());
			statement.setLong(2, reservatie.getFilmid());
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(reservatie.getReservatieDatum());
			statement.setString(3, currentTime);
			statement.executeUpdate();
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}

	public Iterable<Reservatie> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
			List<Reservatie> reservaties = new ArrayList<>();
			while (resultSet.next()) {
				reservaties.add(resultSetRijNaarReservatie(resultSet));
			}
			return reservaties;
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}

	private Reservatie resultSetRijNaarReservatie(ResultSet resultSet)
			throws SQLException {
		return new Reservatie(resultSet.getLong("klantid"), resultSet.getLong("filmid"), resultSet.getString("familienaam"), resultSet.getString("voornaam"),
				resultSet.getString("titel"),
				resultSet.getDate("reservatieDatum"));
	}
	
	public void delete(long klantid, long filmid) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(DELETE_SQL)) {
			statement.setLong(1, klantid);
			statement.setLong(2, filmid);
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}	

}
