package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.model.ContactModel;
import it.paradisogiuseppe.model.dao.ContactDAO;

/**
 * Servlet implementation class SaveContact
 */
@WebServlet("/save")
public class SaveContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ListContact.class.getName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("save.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String telefono=request.getParameter("telefono");
		String email=request.getParameter("email");
		
		ContactModel contact = new ContactModel(ContactDAO.getIdMax(), nome, cognome, telefono, email);
		ContactDAO.addContact(contact);
		
		response.sendRedirect("list");

	}

}
