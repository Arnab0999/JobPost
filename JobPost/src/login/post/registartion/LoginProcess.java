package login.post.registartion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/loginprocess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
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
		//doGet(request, response);
		CustomerDAO cd = new CustomerDAO();
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String College = request.getParameter("college");
		String age = request.getParameter("age");
		String interest1 = request.getParameter("interest1");
		String interest2 = request.getParameter("interest2");
		String interest3 = request.getParameter("interest3");
		String submitType = request.getParameter("submit");
		Customer c = cd.getCustomer(userid, passwd);
		if(c!=null  && submitType.equals("Login")) {
			request.setAttribute("name", c.getFirstname());
			request.setAttribute("interest1", c.getInterest1());
			request.getRequestDispatcher("StudentHome.jsp").forward(request, response);
		}
		else if(submitType.equals("Register")) {
			c.setFirstname(FirstName);
			c.setPassword(passwd);
			c.setUserid(userid);
			c.setLastname(LastName);
			c.setAge(age);
			c.setCollege(College);
			c.setInterest1(interest1);
			c.setInterest2(interest2);
			c.setInterest3(interest3);
			int status = cd.setCustomer(c);
			if(status!=0)
				request.setAttribute("message", "Registration Complete!! Login to continue.");
			else
				request.setAttribute("message", "Some problem occured please register again.");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("message", "Invalid username or password!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}

}
