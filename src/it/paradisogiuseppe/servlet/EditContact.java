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
 * Servlet implementation class EditContacts
 */
@WebServlet("/update")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EditContact.class.getName());
	private int previousId;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String save=request.getParameter("save");
		if (id!=null){
			ContactModel contatto=ContactDAO.getContactById(Integer.parseInt(id));
			previousId=Integer.parseInt(id);
			HttpSession session=request.getSession();
			session.setAttribute("contact", contatto);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if (save.equals("1")){
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String telefono=request.getParameter("telefono");
			String email=request.getParameter("email");
			
			ContactModel contact = new ContactModel(previousId, nome, cognome, telefono, email);
			ContactDAO.updateContact(contact);
			
//			logger.info(request.getParameter("nome"));

			response.sendRedirect("list");
		}
//		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
