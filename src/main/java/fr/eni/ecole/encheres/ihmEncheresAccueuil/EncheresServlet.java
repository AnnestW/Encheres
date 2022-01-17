package fr.eni.ecole.encheres.ihmEncheresAccueuil;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.encheres.bllEncheres.BLLException;
import fr.eni.ecole.encheres.bllEncheres.EncheresManager;
import fr.eni.ecole.encheres.bllEncheres.EncheresSingl;


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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelEncheres modelEncheres = new ModelEncheres();
		String nextScrean = "WEB-INF/Encheres.jsp";
		EncheresManager mgr = EncheresSingl.getInstance();
		
		if(request.getParameter("rechercher") != null) {
			try {
				mgr.selectByNomArticle(request.getParameter("nomArticle"));
			} catch (BLLException e) {
				e.printStackTrace();
				modelEncheres.setMessage(e.toString());
			
			}	
		}
		
		
		
		

	request.getRequestDispatcher(nextScrean).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
