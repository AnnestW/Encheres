package fr.eni.ecole.encheres.ihm.encheres;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ecole.encheres.bllCategorie.CategorieManager;
import fr.eni.ecole.encheres.bllCategorie.CategorieManagerSingl;
import fr.eni.ecole.encheres.bllEncheres.BLLException;
import fr.eni.ecole.encheres.bllEncheres.EncheresManager;
import fr.eni.ecole.encheres.bllEncheres.EncheresSingl;
import fr.eni.ecole.encheres.bo.Utilisateur;



/**
 * Servlet implementation class EncheresServlet
 */
@WebServlet("/EncheresServlet")
public class EncheresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	public EncheresServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelEncheres modelEncheres = new ModelEncheres();
		String nextScreen = "WEB-INF/Encheres.jsp";
		EncheresManager mgr = EncheresSingl.getInstance();
		CategorieManager mgrCat = CategorieManagerSingl.getInstance();
		boolean userConnected = false;
		
		
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("user");
		//session.setAttribute("user", user);
		if (user != null) {
			userConnected = true;
			 }
		 
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

			
			if (request.getParameter("nomArticle") != null || request.getParameter("choisir_categorie")!=null) {
				 etatVente = "EN_COURS";
			}
			if (request.getParameter("encheresEnCours")!=null) {
					 etatVente = "EN_COURS";
			} if (request.getParameter("mesEncheres")!=null) {
				noEncherisseur = user.getNoUtilisateur();
			}if (request.getParameter("encheresRemportees")!=null) {
				etatVente = "TERMINE";
			}if (request.getParameter("ventesEnCours")!=null) {
				noVendeur = user.getNoUtilisateur();
				etatVente = "EN_COURS";
			}if (request.getParameter("ventesNonDebutees")!=null)  {
				noVendeur = user.getNoUtilisateur();
				etatVente = "NON_DEBUTE";
			}if (request.getParameter("ventesTerminees")!=null)  {
				noVendeur = user.getNoUtilisateur();
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
		 
		
		if(request.getParameter("Logout") != null) {
			nextScreen = "LogoutServlet";
		}


		request.getServletContext().setAttribute("userConnected", userConnected);
		request.getServletContext().setAttribute("modelEncheres", modelEncheres);
		request.getRequestDispatcher(nextScreen).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
