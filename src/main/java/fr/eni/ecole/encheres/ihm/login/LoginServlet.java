package fr.eni.ecole.encheres.ihm.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.BLLException;
import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bll.UtilisateurManagerSingleton;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.DALException;


/**
 * Servlet implementation class SeConnecterServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurManager utilisateurManager = UtilisateurManagerSingleton.getInstance();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Utilisateur utilisateur = new Utilisateur();
		UtilisateurManager mgr = UtilisateurManagerSingleton.getInstance();
		
		String nextScreen = "/WEB-INF/login.jsp";
		
		if(request.getParameter("connexion")!= null) {
		
//	
			String pseudo = request.getParameter("login");
			String motDePasse = request.getParameter("motDePasse");
			
			Utilisateur user = null;
			try {
				user = mgr.chercherUtilisateur(pseudo, motDePasse);
			} catch (BLLException e) {
				e.printStackTrace();
			} 
			request.getSession().setAttribute("user", user);
			nextScreen = "EncheresServlet";
			
			if (user ==null) {
				String errorMessage = "Il y a eu une erreur";
				request.setAttribute("errorMessage", errorMessage);
				
			}


//			if(pseudo.equals(utilisateur.getPseudo()) || pseudo.equals(utilisateur.getEmail()) && 
//					motDePasse.equals(utilisateur.getMotDePasse()))

		
		}
		if(request.getParameter("creercompte")!= null) {
			nextScreen = "SignUpServlet";
		}

//		request.setAttribute("model", model);
		request.getRequestDispatcher(nextScreen).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
