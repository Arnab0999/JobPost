package login.post.registartion;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import show.jobs.*;
import home.data.NumberOfData;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerDAO cd = new CustomerDAO();
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String type = request.getParameter("type");
		String submitType = request.getParameter("submit");
		Customer c = cd.getCustomer(userid, passwd, type);
		System.out.println(submitType);
		if(c!=null  && submitType.equals("Log In")) {
			request.setAttribute("UserID", c.getUserid());
			request.getRequestDispatcher("StudentHome.jsp").forward(request, response);
		}
		
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
		String type = request.getParameter("type");
		String submitType = request.getParameter("submit");
		System.out.println(type);
		Customer c = cd.getCustomer(userid, passwd, type);
		if(c!=null  && submitType.equals("Log In")) {
			request.setAttribute("UserID", c.getUserid());
			if(type.charAt(0) == 'S') {
				JobsForStudent jfs = new JobsForStudent();
				ArrayList<JobData> arr = jfs.getData(c.getUserid());
				ArrayList<JobData> all = jfs.getAllData();
				if(arr.size()!=0)
					request.setAttribute("CompanyData", arr);
				else
					request.setAttribute("CompanyData", all);
				cd.getStudentDetails(userid);
				StudentDetails sd = new StudentDetails();
				request.setAttribute("StudentData", sd);
				NumberOfData nd = new NumberOfData();
				request.setAttribute("StudentNumber", nd.getStudentNumber());
				request.getRequestDispatcher("StudentHome.jsp").forward(request, response);
			}
			else {
				StudentsForCompany sfj = new StudentsForCompany();
				ArrayList<StudentData> arr = sfj.getData(c.getUserid());
				request.setAttribute("StudentData", arr);
				CompanyDetails cdd = new CompanyDetails();
				request.setAttribute("CompanyData",cdd);
				request.getRequestDispatcher("CompanyHome.jsp").forward(request, response);
			}
		}
		else if(submitType.equals("Sign Up")) {
			c.setPassword(passwd);
			c.setUserid(userid);
			c.setType(type);
			int status = cd.setCustomer(c);
			if(status!=0)
				request.setAttribute("message", "Registration Complete!! Login to continue.");
			else
				request.setAttribute("message", "Some problem occured please register again.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("message", "Invalid username or password!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
