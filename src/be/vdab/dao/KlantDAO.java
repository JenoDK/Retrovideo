package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import be.vdab.entities.Adres;
import be.vdab.entities.Klant;

public class KlantDAO extends AbstractDAO {
	private final static Logger logger = Logger.getLogger(GenreDAO.class
			.getName());
	private static final String FIND_ALL_BY_STRING_SQL = "SELECT * FROM retrovideo.klanten WHERE familienaam LIKE ?;";
	private static final String FIND_BY_ID_SQL = "SELECT * FROM retrovideo.klanten WHERE id = ?;";
	
	public Iterable<Klant> findAllByString(String pieceOfFamName) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(FIND_ALL_BY_STRING_SQL)) {
			List<Klant> klanten = new ArrayList<>();
			statement.setString(1, '%'+pieceOfFamName+'%');
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					klanten.add(resultSetRijNaarKlant(resultSet));
				}
				return klanten;
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}
	
	public Klant read(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement(FIND_BY_ID_SQL)) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSetRijNaarKlant(resultSet);
				}
				return null;
			}
		} catch (SQLException ex) {
			logger.log(Level.SEVERE, "Probleem met database retrovideo", ex);
			throw new DAOException(ex);
		}
	}
	
	private Klant resultSetRijNaarKlant(ResultSet resultSet) throws SQLException {
		return new Klant(resultSet.getLong("id"), 
				resultSet.getString("familienaam"), resultSet.getString("voornaam"),
				new Adres(resultSet.getString("straatNummer"), resultSet.getString("postcode"), resultSet.getString("gemeente")));
	}
}
