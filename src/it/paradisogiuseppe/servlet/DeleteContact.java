package it.paradisogiuseppe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.paradisogiuseppe.model.ContactModel;
import it.paradisogiuseppe.model.dao.ContactDAO;

/**
 * Servlet implementation class DeleteContact
 */
@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int cid=0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String save=request.getParameter("save");
		if (id!=null){
			cid=Integer.parseInt(id);
			ContactModel contatto=ContactDAO.getContactById(Integer.parseInt(id));
			HttpSession session=request.getSession();
			session.setAttribute("contact", contatto);
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}
		else if (save.equals("1")){
			ContactDAO.deleteContact(cid);
			response.sendRedirect("list");
		}
	}

}
