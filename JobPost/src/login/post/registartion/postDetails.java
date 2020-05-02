package login.post.registartion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class postDetails
 */
@WebServlet("/savedetails")
public class postDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDAO cd = new CustomerDAO();
		Customer c = new Customer();
		StudentDetails.setFirstname(request.getParameter("FirstName"));
		StudentDetails.setLastname(request.getParameter("LastName"));
		StudentDetails.setEmail(request.getParameter("Email"));
		StudentDetails.setRegion(request.getParameter("Region"));
		StudentDetails.setAge(request.getParameter("Age"));
		StudentDetails.setPost(request.getParameter("Post"));
		StudentDetails.setSkills(request.getParameter("Skills"));
		int status = cd.setStudentDetails(c);
		
		if(status != 0) 
			request.setAttribute("result", "Details Saved!");
		else
			request.setAttribute("result", "Something went wrong!!");
		
		request.setAttribute("UserID", c.getUserid());
		request.getRequestDispatcher("StudentHome.jsp").forward(request, response);

	}

}
