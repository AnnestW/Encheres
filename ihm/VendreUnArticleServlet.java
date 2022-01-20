package fr.eni.ecole.encheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.CategorieManager;
import fr.eni.ecole.encheres.bll.CategorieManagerImpl;
import fr.eni.ecole.encheres.bll.VendreUnArticleManager;
import fr.eni.ecole.encheres.bll.VendreUnArticleSing;
import fr.eni.ecole.encheres.bllCategorie.CategorieManagerSingl;
import fr.eni.ecole.encheres.bo.ArticleVendu;
import fr.eni.ecole.encheres.bo.Categorie;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;



/**
 * Servlet implementation class AtricleVenduServlet
 */

@WebServlet("/VendreUnArticleServlet")
public class VendreUnArticleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private VendreUnArticleManager manager = VendreUnArticleSing.getInstance();
	CategorieManager mgrCat = CategorieManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreUnArticleServlet() {
        super();
        
    }

//    private boolean isUserConnected() throws ServletException, IOException {
//		return true;
//	}
//    private Utilisateur getUtilisateurConnecte() throws ServletException, IOException {
//		Utilisateur utilisateurConnecte = new Utilisateur();
//		utilisateurConnecte.setNoUtilisateur(4);
//		return utilisateurConnecte;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		VendreUnArticleModel model = new VendreUnArticleModel();
		String nextScreen = "WEB-INF/NouvelleVente.jsp";
		
		boolean userConnected = true;
		Utilisateur user = null;
		
		HttpSession session = request.getSession();
		
		 if (session.getAttribute("user") != null) {
			userConnected = true;
			user = (Utilisateur) session.getAttribute("user");
		} 
			try {
				model.setLstCategories(mgrCat.getAllCategories());
			} catch (BLLException e) {
				e.printStackTrace();
				model.setMessage(e.toString());
			}
		
		if(request.getParameter("enregister")!=null) {
			//Integer noArticle = Integer.parseInt(request.getParameter("noArticle"));
			//int noArticle = Integer.parseInt(request.getParameter("idArticle"));
			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			LocalDate dateDebutEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"));
			LocalDate dateFinEncheres = LocalDate.parse(request.getParameter("dateDebutEncheres"));
			Integer miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
			//Integer prixVente = Integer.parseInt(request.getParameter("prixVente"));
			String etatVente = "encours";//request.getParameter("etatVente");
			int noCategorie = Integer.parseInt(request.getParameter("choisir_categorie"));
			int noUtilisateur = 1;//user.getNoUtilisateur();
			
			
			
			
			
			Categorie  categorie = new Categorie();
			categorie.setNoCategorie(noCategorie);
			
			Utilisateur utilisateur = new Utilisateur ();
			utilisateur = user;
			
			
			
			ArticleVendu articleVendu = new ArticleVendu( nomArticle, description, dateDebutEncheres,dateFinEncheres, 
					miseAPrix, categorie,utilisateur );

			
			try {
				manager.AddArticle(articleVendu);
					 model.setArticleVendu(articleVendu);
			        	model.setListArticlesVendus(manager.getAllArticleVendu());
								} catch (BLLException | DALException e) {
					
								e.printStackTrace();
			}
		}
			
	
		request.setAttribute("model", model);
				
	
		request.getRequestDispatcher(nextScreen).forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
