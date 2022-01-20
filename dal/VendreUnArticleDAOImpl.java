package fr.eni.ecole.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;

public class VendreUnArticleDAOImpl implements VendreUnArticleDAO {
	
		    
//	private final static String TABLE_NAME = "ARTICLES_VENDUS";
//	private final static String COL_no_article = TABLE_NAME + "_no_article";
//	private final static String COL_nom_article = TABLE_NAME + "_nom_article";
//	private final static String COL_description = TABLE_NAME + "_description";
//	private final static String COL_date_debut_encheres = TABLE_NAME + "_date_debut_encheres";
//	private final static String COL_date_fin_encheres = TABLE_NAME + "_date_fin_encheres";
//	private final static String COL_prix_initial = TABLE_NAME + "_prix_initial";
//	private final static String COL_prix_vente = TABLE_NAME + "_prix_vente";
//	private final static String COL_etat_vente = TABLE_NAME + "_etat_vente";
//	private final static String COL_no_utilisateur = TABLE_NAME + "_no_utilisateur";
//	private final static String COL_no_categorie = TABLE_NAME + "_no_categorie";
	
	private final static String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_Debut_encheres,date_fin_encheres, "
			+ " prix_initial, prix_vente, etat_vente, no_utilisateur,no_categorie ) VALUES(?,?,?,?,?,?,?,?,?)";
			
	private final static String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS";
	private final static String UPDATE = "UPDATE ARTICLES_VENDUS "; // à completer
	
	
	CategorieDAO daoCat = CategorieDAOFactory.getInstance();
	UtilisateurDAO daoUtil = UtilisateurDAOFactory.getInstance();
	
	@Override
	public void insert(ArticleVendu nouveauArticleAVendre) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, nouveauArticleAVendre.getNomArticle());
			pStmt.setString(2, nouveauArticleAVendre.getDescription());
			pStmt.setDate(3, Date.valueOf(nouveauArticleAVendre.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(nouveauArticleAVendre.getDateFinEncheres()));
			pStmt.setInt(5, nouveauArticleAVendre.getMiseAPrix());
			pStmt.setInt(6, nouveauArticleAVendre.getPrixVente());
			pStmt.setString(7, nouveauArticleAVendre.getEtatVente());
			pStmt.setInt(8, nouveauArticleAVendre.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(9, nouveauArticleAVendre.getCategorie().getNoCategorie());
			pStmt.executeUpdate();
			pStmt.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> articleVendus = new ArrayList<ArticleVendu>();
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while(rs.next()) {
				ArticleVendu articleVendu = map(rs);
				articleVendus.add(articleVendu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return articleVendus;
	}

	 
	public ArticleVendu map(ResultSet rs) throws SQLException{
		Integer noArticle = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
		LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
		Integer miseAPrix = rs.getInt("prix_initial");
		Integer prixVente = rs.getInt("prix_vente");
		String etatVente = rs.getString("etat_vente");
		Utilisateur utilisateur =daoUtil.map(rs); 
		Categorie  categorie = daoCat.mapCateg(rs);                  
		return new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres,dateFinEncheres, 
				miseAPrix, prixVente, etatVente,categorie,utilisateur );

	}

	@Override
	public void update(ArticleVendu ArticleVendu) throws DALException {
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			pStmt.setInt(1, ArticleVendu.getNoArticle());
			pStmt.setString(2, ArticleVendu.getNomArticle());
			pStmt.setString(3, ArticleVendu.getDescription());
			pStmt.setDate(4, Date.valueOf(ArticleVendu.getDateDebutEncheres()));
			pStmt.setDate(5, Date.valueOf(ArticleVendu.getDateFinEncheres()));
			pStmt.setInt(6, ArticleVendu.getMiseAPrix());
			pStmt.setInt(7, ArticleVendu.getPrixVente());
			pStmt.setString(8, ArticleVendu.getEtatVente());
			pStmt.setInt(9, ArticleVendu.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(10, ArticleVendu.getCategorie().getNoCategorie());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	
	
	}
	

