package fr.eni.ecole.encheres.ihmEncheresAccueuil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bllCategorie.CategorieManager;
import fr.eni.ecole.encheres.bllCategorie.CategorieManagerSingl;
import fr.eni.ecole.encheres.bllEncheres.BLLException;
import fr.eni.ecole.encheres.bllEncheres.EncheresManager;
import fr.eni.ecole.encheres.bllEncheres.EncheresSingl;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.bo.ArticleVendu;


/**
 * Servlet implementation class EncheresServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EncheresServlet() {
		super();
	}

	private boolean isUserConnected() throws ServletException, IOException {
		return true;
	}

	private Utilisateur getUtilisateurConnecte() throws ServletException, IOException {
		Utilisateur utilisateurConnecte = new Utilisateur();
		utilisateurConnecte.setNoUtilisateur(2);
		return utilisateurConnecte;
	}
//	HttpSession session = request.getSession(false);
//	if (session == null || session.getAttribute("userConnected") == null) {
//	
//		} else {
//		   
//		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelEncheres modelEncheres = new ModelEncheres();
		String nextScreen = "WEB-INF/Encheres.jsp";
		EncheresManager mgr = EncheresSingl.getInstance();
		CategorieManager mgrCat = CategorieManagerSingl.getInstance();

		try {
			modelEncheres.setLstEncheres(mgr.getEncheresEnCours());
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

	
		try {
			modelEncheres.setLstCategories(mgrCat.getAllCategories());
		} catch (BLLException e) {
			e.printStackTrace();
			modelEncheres.setMessage(e.toString());
		}
		


		if (request.getParameter("Rechercher") != null) {
			String choixCat = request.getParameter("choisir_categorie");
			String nomArt = request.getParameter("nomArticle");
			String etatVente = null;
			Integer noEncherisseur = null;
			Integer noVendeur = null;
			
			if (request.getParameter("nomArticle") != null || request.getParameter("choisir_categorie") !=null) {
				 etatVente = "EN_COURS";
			}
			
			if (request.getParameter("encheresEnCours") !=null) {
				 etatVente = "EN_COURS";
				
			}
			if (request.getParameter("mesEncheres") !=null) {
				noEncherisseur = getUtilisateurConnecte().getNoUtilisateur();
			}
				if (request.getParameter("encheresRemportees") !=null) {
					
					etatVente = "TERMINE";
				}
				if (request.getParameter("ventesEnCours") !=null) {
					noVendeur = getUtilisateurConnecte().getNoUtilisateur();
					etatVente = "EN_COURS";
				}
				if (request.getParameter("ventesNonDebutees") !=null) {
					noVendeur = getUtilisateurConnecte().getNoUtilisateur();
					etatVente = "NON_DEBUTE";
				}
				if (request.getParameter("ventesTerminees") !=null) {
					noVendeur = getUtilisateurConnecte().getNoUtilisateur();
					etatVente = "TERMINE";
				}
			
			try {
				modelEncheres.setLstEncheres(mgr.getEnchereByFilter(
						nomArt != null && !nomArt.isEmpty() ? nomArt : null,
						choixCat != null && !choixCat.isEmpty() ? Integer.valueOf(choixCat) : null,
						noEncherisseur, etatVente, noVendeur));
			} catch (BLLException e) {
				e.printStackTrace();
				modelEncheres.setMessage(e.toString());
			}
	
		}
//		if (request.getParameter("choisir_categorie") != null && !request.getParameter("choisir_categorie").isEmpty()) {
//
//			try {
//				modelEncheres.setLstParCategorie(
//						mgr.selectByCategorie(Integer.valueOf(request.getParameter("choisir_categorie"))));
//			} catch (BLLException e) {
//				e.printStackTrace();
//				modelEncheres.setMessage(e.toString());
//			}

		request.getServletContext().setAttribute("userConnected", isUserConnected());
		request.getServletContext().setAttribute("modelEncheres", modelEncheres);
		request.getRequestDispatcher(nextScreen).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
