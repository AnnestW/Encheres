package fr.eni.ecole.encheres.ihm.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bll.UtilisateurManagerSingleton;
import fr.eni.ecole.encheres.bo.Utilisateur;
import fr.eni.ecole.encheres.dal.UtilisateurDAOImpl;
import fr.formation.vote.ihm.login.LoginModel;

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
		Utilisateur utilisateur = new Utilisateur();
		
		String EcranLogin = "/WEB-INT/login.jsp";
		
		if(request.getParameter("connexion")!= null) {
		
//	
			String login = request.getParameter("pseudo");
			String motDePasse = request.getParameter("motDePasse");
			
			Utilisateur user = UtilisateurDAOImpl.chercherUtilisateur(login, motDePasse);
			
			if (user ==null) {
				String errorMessage = "Il y a d'erreur";
				request.setAttribute("errorMessage", errorMessage);
				
				request.getRequestDispatcher(EcranLogin).forward(request, response);
			}


			if(login.equals(utilisateur.getPseudo()) || login.equals(utilisateur.getEmail()) && 
					motDePasse.equals(utilisateur.getMotDePasse())){
				
				request.getSession().setAttribute("login", login);
				
				EcranLogin = "OuvertEncheresServlet";
				
			}
		
		}
		if(request.getParameter("creercompte")!= null) {
			EcranLogin = "SignUpServlet";
		}

//		request.setAttribute("model", model);
		request.getRequestDispatcher(EcranLogin).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
