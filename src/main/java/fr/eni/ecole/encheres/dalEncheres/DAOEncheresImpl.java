package fr.eni.ecole.encheres.dalEncheres;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.dal.JdbcTools;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorie;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorieFactory;
import fr.eni.ecole.encheres.dalUtilisateur.DAOUtilisateur;
import fr.eni.ecole.encheres.dalUtilisateur.DAOUtilisateurFactory;

public class DAOEncheresImpl implements DAOEnchere {

	private static final String SELECT_E_AND_JOIN_U_AND_AV = "SELECT e.no_enchere, e.date_enchere, e.montant_enchere, e.no_article, e.no_utilisateur, "
				+ "												av.nom_article, av.description, av.date_debut_encheres, av.date_fin_encheres, av.prix_initial, av.prix_vente, av.etat_vente, "
				+ "												c.no_categorie, c.libelle, u.pseudo, u.nom, u.prenom, u.email, u.telephone, u.rue, u.code_postal,"
				+ "												u.ville, u.mot_de_passe, u.credit, u.administrateur"
				+ "												FROM encheres e"
				+ "												INNER JOIN articles_vendus av ON e.no_article = av.no_article "
				+ "												INNER JOIN categories c ON c.no_categorie = av.no_categorie "
				+ "												INNER JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur ";
	private final static String INSERT = "INSERT INTO encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private final static String SELECT_ALL = SELECT_E_AND_JOIN_U_AND_AV;
	private final static String SELECT_BY_NOMARTICLE = SELECT_E_AND_JOIN_U_AND_AV
			+ "											WHERE av.nom_article =?";
	private final static String UPDATE_ENCHERE = "UPDATE encheres SET montant_enchere = ? WHERE no_enchere = ?";
	
	
	private final static String SELECT_BY_ART_ENCHERISSEUR = SELECT_E_AND_JOIN_U_AND_AV
			+ "												WHERE e.no_article=? AND e.no_utilisateur = ?";

	private final static String SELECT_BY_CATEGORIE = SELECT_E_AND_JOIN_U_AND_AV
			+ "											WHERE c.no_categorie = ?";
	private final static String SELECT_BY_UTILISATEUR = SELECT_E_AND_JOIN_U_AND_AV
			+ "											WHERE u.no_utilisateur = ?";
	
	
	DAOCategorie daoCat = DAOCategorieFactory.getInstance();
	DAOUtilisateur daoUtil = DAOUtilisateurFactory.getInstance();
	
	
	
	@Override
	public void insert(Enchere enchere) throws DALException {
		Date date = java.sql.Date.valueOf(enchere.getDateEnchere());
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setDate(1, date);
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getArticleAVendre().getNoArticle());
			pStmt.setInt(4, enchere.getEncherisseur().getNoUtilisateur());
		
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			

		} catch(SQLException e){
			e.printStackTrace(); 
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public List<Enchere> getEncheresEnCours() throws DALException {
		List<Enchere> lstAllEncheres = getAllEncheres();
		List<Enchere> lstEncheresEnCours = new ArrayList<Enchere>();
		for (Enchere enchere : lstAllEncheres) {
			if (enchere.getArticleAVendre().getEtatVente().equalsIgnoreCase("EnCours")) {
				lstEncheresEnCours.add(enchere);
			}
		}
		return lstAllEncheres;
	}

	@Override
	public List<Enchere> getAllEncheres() throws DALException {
			List<Enchere> lstAllEncheres = new ArrayList<Enchere>();
			try (Connection cnx = JdbcTools.getConnection()) {
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ALL);
				while (rs.next()) {
					Enchere enchere = mapEnchere(rs);
					lstAllEncheres.add(enchere);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException(e.getMessage());
			}
			return lstAllEncheres;
		}

	@Override
	public void updateEnchere(Enchere enchere, Integer montant) throws DALException {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_ENCHERE);
			
			pStmt.setInt(1, enchere.getNoEnchere());
			pStmt.setInt(2, montant);
			pStmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace(); 
			throw new DALException(e.getMessage());
		}
			
	}

	@Override
	public List<Enchere> selectByNomArticle(String nomArticle) throws DALException {
		Enchere enchere = null;
		List<Enchere> lstEnchereByNomArticle = new ArrayList<Enchere>();
				try (Connection cnx = JdbcTools.getConnection()) {
					PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_NOMARTICLE);
					pStmt.setString(1, nomArticle);
					ResultSet rs = pStmt.executeQuery();
					while (rs.next()) {
						enchere = mapEnchere(rs);
					lstEnchereByNomArticle.add(enchere);
					}
				} catch(SQLException e){
					e.printStackTrace(); 
					throw new DALException(e.getMessage());
				}
				return lstEnchereByNomArticle;
			}
			

	@Override
	public List<Enchere> selectByCategorie(Integer noCategorie) throws DALException {
		Enchere enchere = null;
		List<Enchere> lstEnchereByCategorie = new ArrayList<Enchere>();
				try (Connection cnx = JdbcTools.getConnection()) {
					PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
					pStmt.setInt(1, noCategorie);
					ResultSet rs = pStmt.executeQuery();
					while (rs.next()) {
						enchere = mapEnchere(rs);
					lstEnchereByCategorie.add(enchere);
					}
					
				} catch(SQLException e){
					e.printStackTrace(); 
					throw new DALException(e.getMessage());
				}
				return lstEnchereByCategorie;
			}


	@Override
	public Enchere selectByArticleEncherisseur(ArticleVendu article, Utilisateur encherisseur) throws DALException {
		Enchere enchere = null;
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ART_ENCHERISSEUR);
			pStmt.setInt(1, article.getNoArticle());
			pStmt.setInt(2, encherisseur.getNoUtilisateur());
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				enchere = mapEnchere(rs);
			}
	
		} catch(SQLException e){
			e.printStackTrace(); 
			throw new DALException(e.getMessage());
		}
		return enchere;
	}

	@Override
	public List<Enchere> selectByUtilisateur(Integer noUtilisateur) throws DALException {
		Enchere enchere = null;
		List<Enchere> lstEnchereByUtilisateur = new ArrayList<Enchere>();
				try (Connection cnx = JdbcTools.getConnection()) {
					PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR);
					pStmt.setInt(1, noUtilisateur);
					ResultSet rs = pStmt.executeQuery();
					while (rs.next()) {
						enchere = mapEnchere(rs);
						lstEnchereByUtilisateur.add(enchere);
					}
					
				} catch(SQLException e){
					e.printStackTrace(); 
					throw new DALException(e.getMessage());
				}
				return lstEnchereByUtilisateur;
			}
	
	

	public ArticleVendu mapArt (ResultSet rs) throws SQLException {
		
		 Integer noArticle = rs.getInt("no_article");
		 String nomArticle = rs.getString("nom_article");
		 String description = rs.getString("description");
		 LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
		 LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
		 Integer miseAPrix = rs.getInt("prix_initial");
		 Integer prixVente = rs.getInt("prix_vente");
		 String etatVente = rs.getString("etat_vente");
		 Categorie categorie = daoCat.mapCateg(rs);
		 Utilisateur utilisateur = daoUtil.mapUtil(rs);
	
		 ArticleVendu articleVendu = new ArticleVendu(noArticle,nomArticle, description, dateDebutEncheres, dateFinEncheres,
				 miseAPrix, prixVente, etatVente, categorie, utilisateur);
		 
		 return articleVendu;
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

	private Enchere mapEnchere(ResultSet rs) throws SQLException {
		
		Integer noEnchere = rs.getInt("no_enchere");
		ArticleVendu article = mapArt(rs);
		LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
		Integer montantEnchere = rs.getInt("montant_enchere");
		Utilisateur encherisseur = daoUtil.mapUtil(rs);
		
		Enchere enchere = new Enchere(noEnchere, article, dateEnchere,montantEnchere, encherisseur);
		
		return enchere;
	}
	

}
