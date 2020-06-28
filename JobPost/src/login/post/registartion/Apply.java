package login.post.registartion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class Apply
 */
@WebServlet("/applied")
public class Apply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apply() {
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
			Customer c = new Customer();
			Connection con = ConnectionProvider.getConnection();
			int count = 0;
			PreparedStatement mystate = con.prepareStatement("select * from JobPost.Applications");
			ResultSet rs = mystate.executeQuery();
			while(rs.next()) {
				count++;
			}
			System.out.print(JobDetails.getUserID());
			mystate = con.prepareStatement("INSERT INTO JobPost.Applications (ID, JobID, StudentDesciption, StudentUserID, CompanyUserID, Status) VALUES (?, ?, ?, ?, ?, ?)");
			mystate.setString(1,Integer.toString(count));
			mystate.setString(2, Integer.toString(JobDetails.getID()));
			mystate.setString(3, request.getParameter("studentbio"));
			mystate.setString(4, c.getUserid());
			mystate.setString(5, JobDetails.getUserID());
			mystate.setString(6, "Yes");
			int status = mystate.executeUpdate();
			if(status!=0) {
				request.setAttribute("Message", "Succesfully Applied");
			}
			else {
				request.setAttribute("Message", "Something went wrong, apply again.");
			}
			request.getRequestDispatcher("StudentHome.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
