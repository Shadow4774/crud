package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletControl")
public class ServletControl extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServletControl() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		String op = request.getParameter("op");
		
		switch (op) {
		case "list":
			request.setAttribute("users", DBActions.getAll());
			forward(request, response, "/listAll.jsp");
			break;

		default:
			forward(request, response, "/index.html");
			break;
		}
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
