package home.data;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import show.jobs.*;
import Session.*;
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
		String data5 = n.getAppsFilled();
		HomeSession.setStudentNumber(data1);
		HomeSession.setCompanyNumber(data4);
		HomeSession.setJobsFilled(data5);
		request.setAttribute("StudentNumber", data1);
		request.setAttribute("JobsPosted", data2);
		request.setAttribute("JobsFilled", data5);
		request.setAttribute("CompanyNumber", data4);
		JobsForStudent jfs = new JobsForStudent();
		ArrayList<JobData> jobs = jfs.getAllData();
		HomeSession.setAllJobs(jobs);
		request.setAttribute("JobData", jobs);
		if(CompanySession.getStuds()!=null)
			request.getRequestDispatcher("CompanyHome.jsp").forward(request, response);
		else if(StudentSession.getJobs()!=null)
			request.getRequestDispatcher("StudentHome.jsp").forward(request, response);
		else
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	

}
