package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Film;

public class FilmDAO extends AbstractDAO {
	private static final String FIND_BY_ID_SQL = "SELECT * FROM retrovideo.films WHERE id = ?;";
	private static final String FIND_ALL_BY_GENRE_SQL = "SELECT * FROM retrovideo.films WHERE genreid = ?;";
	private final static Logger logger = Logger.getLogger(GenreDAO.class
			.getName());

	public Iterable<Film> findAllByGenre(long genreid) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(FIND_ALL_BY_GENRE_SQL)) {
			List<Film> films = new ArrayList<>();
			statement.setLong(1, genreid);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					films.add(resultSetRijNaarFilm(resultSet));
				}
				return films;
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}
	
	public Film read(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(FIND_BY_ID_SQL)) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSetRijNaarFilm(resultSet);
				}
				return null;
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}

	private Film resultSetRijNaarFilm(ResultSet resultSet) throws SQLException {
		return new Film(resultSet.getLong("id"), resultSet.getLong("genreid"),
				resultSet.getString("titel"), resultSet.getInt("voorraad"),
				resultSet.getInt("gereserveerd"),
				resultSet.getBigDecimal("prijs"));
	}
}
