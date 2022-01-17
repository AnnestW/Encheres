package fr.eni.ecole.encheres.dalUtilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.JdbcTools;
import fr.eni.ecole.encheres.dalEncheres.DALException;

public class DAOUtilisateurImpl implements DAOUtilisateur {

	private final static String INSERT = "INSERT INTO utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "								VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_ALL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur "
			+ "								 FROM utilisateurs";

	
	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setString(11, utilisateur.getTelephone());
			pStmt.setBoolean(12, utilisateur.getAdministrateur());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				int noUtilisateur = rs.getInt(1);
				utilisateur.setNoUtilisateur(noUtilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() throws DALException {
		List<Utilisateur> lstAllUtilisateurs = new ArrayList<Utilisateur>();
		try (Connection cnx = JdbcTools.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
				Utilisateur utilisateur = mapUtil(rs);
				lstAllUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		return lstAllUtilisateurs;
	}
	

	@Override
	public Utilisateur mapUtil(ResultSet rs) throws SQLException {
		 Integer noUtilisateur = rs.getInt("no_utilisateur");
		 String pseudo = rs.getString("pseudo");
		 String nom = rs.getString("nom");
		 String prenom = rs.getString("prenom");
		 String email = rs.getString("email");
		 String telephone = rs.getString("telephone");
		 String rue = rs.getString("rue");
		 String codePostal = rs.getString("code_postal");
		 String ville = rs.getString("ville");
		 String motDePasse = rs.getString("mot_de_passe");
		 Integer credit = rs.getInt("credit");
		 boolean administrateur = rs.getBoolean("administrateur");
		
		Utilisateur utilisateur = new Utilisateur(noUtilisateur,pseudo, nom, prenom, 
				email, telephone, rue, codePostal,ville, motDePasse, credit, administrateur);
		return utilisateur;
	}

}
