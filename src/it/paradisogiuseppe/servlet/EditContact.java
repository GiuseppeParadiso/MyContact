package it.paradisogiuseppe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.model.ContactModel;
import it.paradisogiuseppe.model.StringValidation;
import it.paradisogiuseppe.model.dao.ContactDAO;

/**
 * Servlet implementation class EditContacts
 */
@WebServlet("/update")
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(EditContact.class.getName());
	private int previousId=-1;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(previousId==-1 || id!=null){
			
			ContactModel contatto=ContactDAO.getContactById(Integer.parseInt(id));
			previousId=Integer.parseInt(id);
			HttpSession session=request.getSession();
			session.setAttribute("contact", contatto);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String telefono=request.getParameter("telefono");
		String email=request.getParameter("email");

		if((!(StringValidation.check(StringValidation.getEmailRegex(), email))) || (!(StringValidation.check(StringValidation.getTelRegex(), telefono)))){
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Telefono o email non corretti!');");
			   out.println("location='update.jsp';");
			   out.println("</script>");
		}else{
			ContactModel contact = new ContactModel(previousId, nome, cognome, telefono, email);
			ContactDAO.updateContact(contact);
			previousId=-1;
			response.sendRedirect("list");
		}

	}

}
