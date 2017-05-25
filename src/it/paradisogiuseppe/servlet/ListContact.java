package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.dao.ContactDAO;
import it.paradisogiuseppe.model.ContactModel;

/**
 * Servlet implementation class ListContact
 */
@WebServlet("/list")
public class ListContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    private static final Logger logger = Logger.getLogger(ListContact.class.getName());
	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDAO.populate();
		List<ContactModel>  listContacts=ContactDAO.getContacts();
//		logger.info(listContacts.toString());
		HttpSession session=request.getSession();
		session.setAttribute("listContacts", listContacts);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	 /**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String referrer = request.getHeader("referer");	
//		logger.warning("the servlet was being called from here: " + referrer);
//		request.getRequestDispatcher("save.jsp").forward(request, response);
	}
	
}
