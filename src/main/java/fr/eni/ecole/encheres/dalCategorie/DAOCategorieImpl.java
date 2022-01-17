package fr.eni.ecole.encheres.dalCategorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.dal.JdbcTools;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public class DAOCategorieImpl implements DAOCategorie {

	private final static String INSERT = "INSERT INTO categories (libelle) VALUES(?)";
	private final static String SELECT_ALL = "SELECT no_categorie, libelle FROM categories";

	@Override
	public void insert(Categorie categorie) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, categorie.getLibelle());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				int noCategorie = rs.getInt(1);
				categorie.setNoCategorie(noCategorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public List<Categorie> getAllCategories() throws DALException {
		List<Categorie> lstAllCategories = new ArrayList<Categorie>();
		try (Connection cnx = JdbcTools.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Categorie categorie = mapCateg(rs);
				lstAllCategories.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		return lstAllCategories;
	}
	

	public Categorie mapCateg(ResultSet rs) throws SQLException {
		Integer noCategorie = rs.getInt("no_categorie");
		String libelle = rs.getString("libelle");

		Categorie categorie = new Categorie(noCategorie, libelle);
		return categorie;

	}

}
