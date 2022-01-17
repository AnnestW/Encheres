package fr.eni.ecole.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.ecole.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	
	private static final Map<String, Utilisateur> mapUtilisateur = new HashMap
			<String, Utilisateur>();
	
	private Utilisateur map(ResultSet rs) throws SQLException {
	
		Integer noUtilisateur = rs.getInt("noUtilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String codePostal = rs.getString("codePostal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("motDePasse");
		Integer credit = rs.getInt("credit");
		String administrateur = rs.getString("administrateur");
		
		Utilisateur utilisateur1 = null;
		
		utilisateur1 = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
				ville, motDePasse, credit, administrateur);
		
		return utilisateur1;
			
	}
	
	//pour regarder le profile
	public static final String SELECT_BY_PSEUDO ="Select nom,prenom,email,telephone,rue,"
			+ "codePostal, ville FROM Utilisateur WHERE pseudo = ? ";
	
	
	//pour modifier le mot de passe
	public static final String UPDATE_PASSWORD = "Update Utilisateur SET motDePasse = ? WHERE pseudo = ?";
	
	
	//pour creer nouvel compte
	public static final String INSERT ="Insert INTO Utilisateur(pseudo, nom, prenom, email, telephone,"
			+ "rue, codePostal,ville,motDePasse) VALUE (?,?,?,?,?,?,?,?,?,)";
	
	
	//pour supprimer le compte
	public static final String DELETE = "Delete FROM Utilisateur WHERE pseudo =?";
			
			
	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
			
		Utilisateur utilisateur = null;
		
		try(Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			
			utilisateur = map(rs);

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateur;
	}
	
	
	
	public void updatePassword(String motDePasse, String pseudo) throws DALException {
		try(Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_PASSWORD);
			pStmt.setString(1, motDePasse);
			pStmt.setString(2, pseudo);
		
		}catch (SQLException e){
			e.printStackTrace();
			throw new DALException(e.getMessage());
			
		}
		
	}

	
	public void insert(Utilisateur nouvelUtilisateur) throws DALException {
		try(Connection cnx = JdbcTools.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);	
			pStmt.setString(1, nouvelUtilisateur.getPseudo());
			pStmt.setString(2, nouvelUtilisateur.getNom());
			pStmt.setString(3, nouvelUtilisateur.getPrenom());
			pStmt.setString(4, nouvelUtilisateur.getEmail());
			pStmt.setString(5, nouvelUtilisateur.getTelephone());
			pStmt.setString(6, nouvelUtilisateur.getRue());
			pStmt.setString(7, nouvelUtilisateur.getCodePostal());
			pStmt.setString(8, nouvelUtilisateur.getVille());
			pStmt.setString(9, nouvelUtilisateur.getMotDePasse());
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}
	
	
	
	
	
	public Utilisateur chercherUtilisateur(String login, String motDePasse) {
		Utilisateur u = mapUtilisateur.get(login);
//		Utilisateur e = mapUtilisateur.get(email);
		if (u != null && u.getMotDePasse().equals(motDePasse)) {
			return u;
		}
		return null;
	}


	
	
}
