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
import fr.eni.ecole.encheres.dal.UtilisateurDAO;
import fr.eni.ecole.encheres.dal.UtilisateurDAOFactory;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Enchere;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorie;
import fr.eni.ecole.encheres.dalCategorie.DAOCategorieFactory;


public class DAOEncheresImpl implements DAOEnchere {

public static final String ETAT_TERMINE = "TERMINE";
public static final String ETAT_EN_COURS = "EN_COURS";
public static final String ETAT_NON_DEBUTE = "NON_DEBUTE";
//	private static final String SELECT_ALL_ENCHERES = "SELECT av.nom_article, av.description, av.date_debut_encheres,"
//			+"										av.date_fin_encheres, av.prix_initial, av.prix_vente, av.etat_vente,"
//			+"										c.no_categorie, c.libelle, u.no_utilisateur"
//			+"										FROM encheres e"
//			+"										LEFT JOIN articles_vendus av ON e.no_article = av.no_article"
//			+"										LEFT JOIN categories c ON c.no_categorie = av.no_categorie"	
//			+"										LEFT JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur"
//			+"										WHERE e.montant_enchere = av.prix_vente and u.no_utilisateur = ?";		

	private final static String INSERT = "INSERT INTO encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private final static String UPDATE_ENCHERE = "UPDATE encheres SET montant_enchere = ? WHERE no_enchere = ?";
	private final static String WHERE = " WHERE 1=1 ";
	private final static String AND = " AND ";

	private final static String FILTER_BY_NOM_ARTICLE = "av.nom_article like ?";
	private final static String FILTER_BY_ENCHERISSEUR = "e.no_utilisateur = ?";
	private final static String FILTER_BY_CATEGORIE = "c.no_categorie = ?";
	private final static String FILTER_BY_ETAT_VENTE = "av.etat_vente = ?";
	private final static String FILTER_BY_VENDEUR = "av.no_utilisateur = ?";
	private static final String SELECT_ALL_FROM_ARTICLE = "SELECT DISTINCT av.no_article, av.nom_article, av.description, av.date_debut_encheres, "
			+ "												av.date_fin_encheres, av.prix_initial, av.prix_vente, av.etat_vente, c.no_categorie, c.libelle, u.no_utilisateur,"
			+ "												v.*"
			+ "												FROM articles_vendus av"
			+ "												LEFT JOIN encheres e ON e.no_article = av.no_article "
			+ "												LEFT JOIN categories c ON c.no_categorie = av.no_categorie "
			+ "												LEFT JOIN utilisateurs u ON e.no_utilisateur = u.no_utilisateur"
			+ "												INNER JOIN utilisateurs v ON v.no_utilisateur = av.no_utilisateur";
	private final static String FILTER_BY_GAGNANT = "e.montant_enchere = av.prix_vente";	
	DAOCategorie daoCat = DAOCategorieFactory.getInstance();
	UtilisateurDAO daoUtil = UtilisateurDAOFactory.getInstance();

	@Override
	public void insert(Enchere enchere) throws DALException {
		Date date = Date.valueOf(enchere.getDateEnchere());
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

			pStmt.setDate(1, date);
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getArticleAVendre().getNoArticle());
			pStmt.setInt(4, enchere.getEncherisseur().getNoUtilisateur());

			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public List<ArticleVendu> getEncheresEnCours() throws DALException {
		List<ArticleVendu> lstAllEncheres = getAllEncheres();
		List<ArticleVendu> lstEncheresEnCours = new ArrayList<ArticleVendu>();
		for (ArticleVendu articleAVendre : lstAllEncheres) {
			if (articleAVendre.getEtatVente().equalsIgnoreCase("EN_COURS")) {
				lstEncheresEnCours.add(articleAVendre);
			}
		}
		return lstEncheresEnCours;
	}


	@Override
	public List<ArticleVendu> getAllEncheres() throws DALException {
		List<ArticleVendu> lstAllEncheres = new ArrayList<ArticleVendu>();
		try (Connection cnx = JdbcTools.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_FROM_ARTICLE);
			while (rs.next()) {
				ArticleVendu articleAVendre = mapArt(rs);
				lstAllEncheres.add(articleAVendre);
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

	}

	@Override
	public List<ArticleVendu> selectByFilter(String nomArticle, Integer noCategorie, Integer noEncherisseur,
			String etatVente, Integer noVendeur) throws DALException {
		ArticleVendu articleAVendre = null;
		// String query = SELECT_ALL;
		String query = SELECT_ALL_FROM_ARTICLE;
		int i = 1;
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();

		try (Connection cnx = JdbcTools.getConnection()) {

			if (nomArticle != null || noCategorie != null || etatVente != null || noEncherisseur != null || noVendeur !=null) {
				query += WHERE;
				if (nomArticle != null) {
					query += AND + FILTER_BY_NOM_ARTICLE;
				}
				if (noCategorie != null) {
					query += AND + FILTER_BY_CATEGORIE;
				}
				if (etatVente != null) {
					query += AND + FILTER_BY_ETAT_VENTE;
				}
				if (noEncherisseur != null) {
					query += AND + FILTER_BY_ENCHERISSEUR;
				}
				if (etatVente != null && etatVente.equals(ETAT_TERMINE)) {
					query += AND + FILTER_BY_GAGNANT;
				}
				if (noVendeur != null) {
					query += AND + FILTER_BY_VENDEUR;
				}
				
				

			}
			PreparedStatement pStmt = cnx.prepareStatement(query);
			if (nomArticle != null) {
				pStmt.setString(i++, "%" + nomArticle + "%");
			}
			if (noCategorie != null) {
				pStmt.setInt(i++, noCategorie);
			}
			if (etatVente != null) {
				pStmt.setString(i++, etatVente);
			}
			if (noEncherisseur != null) {
				pStmt.setInt(i++, noEncherisseur);
			}
			if (noVendeur != null) {
				pStmt.setInt(i++, noVendeur);
			}
		
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				articleAVendre = mapArt(rs);
				liste.add(articleAVendre);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}

		return liste;

	}

	public ArticleVendu mapArt(ResultSet rs) throws SQLException {

		Integer noArticle = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
		LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
		Integer miseAPrix = rs.getInt("prix_initial");
		Integer prixVente = rs.getInt("prix_vente");
		String etatVente = rs.getString("etat_vente");
		Categorie categorie = daoCat.mapCateg(rs);
		Utilisateur vendeur = daoUtil.map(rs);

		ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres,
				dateFinEncheres, miseAPrix, prixVente, etatVente, categorie, vendeur);

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

		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
				ville, motDePasse, credit, administrateur);
		return utilisateur;
	}

	private Enchere mapEnchere(ResultSet rs) throws SQLException {

		Integer noEnchere = rs.getInt("no_enchere");
		ArticleVendu articleAVendre = mapArt(rs);
		LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
		Integer montantEnchere = rs.getInt("montant_enchere");
		Utilisateur encherisseur = daoUtil.map(rs);

		Enchere enchere = new Enchere(noEnchere, articleAVendre, dateEnchere, montantEnchere, encherisseur);

		return enchere;
	}

	@Override
	public Enchere selectByArticleEncherisseur(ArticleVendu articleAVendre, Utilisateur encherisseur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
