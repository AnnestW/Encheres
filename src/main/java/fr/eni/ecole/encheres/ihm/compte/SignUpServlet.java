package fr.eni.ecole.encheres.ihm.compte;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bll.UtilisateurManager;
import fr.eni.ecole.encheres.bll.UtilisateurManagerSingleton;


/**
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/CreerCompteServlet")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private UtilisateurManager utilisateurManager = UtilisateurManagerSingleton.getInstance();
	
    /**
     * Default constructor. 
     */
    public SignUpServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String EcranSignUp = "/WEB-INT/signup.jsp";
		
		if(request.getParameter("creer") != null) {
		
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String confirmation = request.getParameter("motDePasse");
		
			
			EcranSignUp = "ListeEncheresServlet";
			
		}
		
		if(request.getParameter("annuler") != null) {
			EcranSignUp = "EncheresServler";
		}
		
	
		request.getRequestDispatcher(EcranSignUp).forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
