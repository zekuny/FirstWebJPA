

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Userjpa;
import model.Userprofile;

/**
 * Servlet implementation class ur_servlet
 */
@WebServlet("/ur_servlet")
public class ur_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ur_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getgetget");
		String uname = request.getParameter("name");
		// TODO Auto-generated method stub
		String buffer=""; 
		
		List<Userprofile> lists = ProfileDB.getProfileLike(uname);
		if(lists != null){
			lists = new ArrayList<Userprofile>(lists);
			for(Userprofile u : lists){
				buffer = buffer + "'" + u.getUsername() + "',";
			}
		}
		System.out.println(buffer);
		response.getWriter().println(buffer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("postpostpost");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
