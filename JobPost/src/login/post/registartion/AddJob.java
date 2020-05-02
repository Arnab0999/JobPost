package login.post.registartion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class AddJob
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/companydetails")
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJob() {
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
		Part fp = request.getPart("Logo");
		System.out.println(fp);
		if(fp!=null)
				CompanyDetails.setLogo(fp.getInputStream());
		CompanyDetails.setEmail(request.getParameter("Email"));
		CompanyDetails.setCompanyname(request.getParameter("CompanyName"));
		CompanyDetails.setJobtitle(request.getParameter("JobTitle"));
		CompanyDetails.setLocation(request.getParameter("Location"));
		CompanyDetails.setRegion(request.getParameter("Region"));
		CompanyDetails.setDescryption(request.getParameter("Descryption"));
		CompanyDetails.setWebsite(request.getParameter("Website"));
		
		int status = cd.setCompanyDetails(c);
		if(status!=0)
			request.setAttribute("result", "Details Saved!!");
		else
			request.setAttribute("result", "Something went wrong!!");
		
		request.setAttribute("UserID", c.getUserid());
		request.getRequestDispatcher("CompanyHome.jsp").forward(request, response);
	}

}
