package fr.eni.ecole.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ecole.encheres.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	
	
//	private static final Map<String, Utilisateur> mapUtilisateur = new HashMap
//			<String, Utilisateur>();

	public Utilisateur map(ResultSet rs) throws SQLException {
	
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
		
		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
				ville, motDePasse, credit, administrateur);
		
		return utilisateur;
			
	}
	
	//pour regarder le profile
	public static final String SELECT_BY_PSEUDO ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue"
			+ "									code_postal, ville, mot_de_passe, credit, administrateur "
			+ "									FROM utilisateurs "
			+ "									WHERE pseudo = ? ";
	
	
	//pour modifier le mot de passe
	public static final String UPDATE_PASSWORD = "Update utilisateurs SET mot_de_passe = ? WHERE pseudo = ?";
	
	
	//pour creer nouvel compte
	public static final String INSERT ="Insert INTO Utilisateurs (no_utilisateur, pseudo, nom, prenom, email, telephone, rue"
			+ "							code_postal, ville, mot_de_passe, credit, administrateur) VALUE (?,?,?,?,?,?,?,?,?,)";
	
	
	//pour supprimer le compte
	public static final String DELETE = "Delete FROM Utilisateurs WHERE pseudo =?";
	
	public static final String SELECT_BY_PSEUDO_MOT_DE_PASSE ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue,"
			+"													code_postal, ville, mot_de_passe, credit, administrateur "
			+" 													FROM Utilisateurs "
			+"													WHERE pseudo = ? AND mot_de_passe = ?";
			
			
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
	
	
	
	
	
//	public Utilisateur chercherUtilisateur(String login, String motDePasse) {
//		Utilisateur u = mapUtilisateur.get(login);
////		Utilisateur e = mapUtilisateur.get(email);
//		if (u != null && u.getMotDePasse().equals(motDePasse)) {
//			return u;
//		}
//		return null;
//	}
	
	public Utilisateur chercherUtilisateur(String pseudo, String motDePasse) throws DALException{
		Utilisateur utilisateur = null;

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO_MOT_DE_PASSE);
			pStmt.setString(1, pseudo);
			pStmt.setString(2, motDePasse);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
			utilisateur = map(rs);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return utilisateur;
	}

	 
     }
	

