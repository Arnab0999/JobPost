package show.jobs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import login.post.registartion.ConnectionProvider;
import login.post.registartion.StudentDetails;
/**
 * Servlet implementation class Accept
 */
@WebServlet("/accept")
public class Accept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement mystate = con.prepareStatement("UPDATE JobPost.Applications SET Status=? WHERE ID=?");
			mystate.setString(1, request.getParameter("submit"));
			mystate.setString(2, StudentDetails.getAppID());
			int status = mystate.executeUpdate();
			if(status!=0) {
				request.setAttribute("appmsg", request.getParameter("submit")+"ed succesfully");
				request.getRequestDispatcher("CompanyHome.jsp").forward(request, response);
			}
			else {
				request.setAttribute("appmsg", "Something went wrong! Retry..");
				request.getRequestDispatcher("app-single.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
