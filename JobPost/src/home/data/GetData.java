package home.data;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import show.jobs.*;
/**
 * Servlet implementation class GetData
 */
@WebServlet("")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NumberOfData n = new NumberOfData();
		String data1 = n.getStudentNumber();
		String data2 = n.getJobs();
		String data3 = n.getApplications();
		String data4 = n.getCompanyNumber();
		request.setAttribute("StudentNumber", data1);
		request.setAttribute("JobsPosted", data2);
		request.setAttribute("JobsFilled", data3);
		request.setAttribute("CompanyNumber", data4);
		JobsForStudent jfs = new JobsForStudent();
		ArrayList<JobData> jobs = jfs.getAllData();
		request.setAttribute("JobData", jobs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	

}
