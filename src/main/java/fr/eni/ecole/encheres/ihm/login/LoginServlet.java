package fr.eni.ecole.encheres.ihm.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session=request.getSession(true);
		
		if(request.getParameter("connexion")!= null) {
			String pseudo = request.getParameter("login");
			String motDePasse = request.getParameter("motDePasse");
			try {
				Utilisateur	user = mgr.chercherUtilisateur(pseudo, motDePasse);
				nextScreen = "EncheresServlet";
				session.setAttribute("user", user);
			} catch (BLLException e) {
				e.printStackTrace();
			} 
			
		}
			
			
//			if (user ==null) {
//				String errorMessage = "Il y a eu une erreur. Réessayez.";
//				request.setAttribute("errorMessage", errorMessage);
//				
//			}


//			if(pseudo.equals(utilisateur.getPseudo()) || pseudo.equals(utilisateur.getEmail()) && 
//					motDePasse.equals(utilisateur.getMotDePasse()))
	
		if(request.getParameter("creercompte")!= null) {
			nextScreen = "SignUpServlet";
		}

		request.getRequestDispatcher(nextScreen).forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
