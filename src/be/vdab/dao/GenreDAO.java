package be.vdab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Genre;

public class GenreDAO extends AbstractDAO {
	private static final String FIND_ALL_SQL = "SELECT * FROM retrovideo.genres ORDER BY genres.naam;";
	private final static Logger logger = Logger.getLogger(GenreDAO.class.getName());
	
	public Iterable<Genre> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
			List<Genre> genres = new ArrayList<>();
			while (resultSet.next()) {
				genres.add(resultSetRijNaarPizza(resultSet));
			}
			return genres;
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}
	
	private Genre resultSetRijNaarPizza(ResultSet resultSet)
			throws SQLException {
		return new Genre(resultSet.getLong("id"), resultSet.getString("naam"));
	}
}
