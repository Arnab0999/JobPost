package search;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import show.jobs.StudentData;

/**
 * Servlet implementation class SearchStuds
 */
@WebServlet("/SearchStuds")
public class SearchStuds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStuds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		findStudents fs = new findStudents();
		ArrayList<StudentData> arr = fs.getSearchedStuds(request.getParameter("keyword"),request.getParameter("Region"));
		request.setAttribute("StudentData", arr);
		request.getRequestDispatcher("Studs.jsp").forward(request, response);;
	}

}
