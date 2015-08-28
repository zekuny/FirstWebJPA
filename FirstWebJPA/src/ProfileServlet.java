import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Userjpa;
import model.Userprofile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World");
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String table = "";
		String table2 = "";
		String table3 = "";
		
		table += "<thead><tr><th>User Name</th><th>FirstName</th><th>LastName</th><th>Moto</th><th>Join Date</th></tr></thead>";
		ArrayList<Userprofile> lists = new ArrayList<Userprofile>(ProfileDB.getProfile(uname));
		for(Userprofile u : lists){
			table += "<tr><td><img src=\"" + u.getProfileimage() + "\" alt=\"Profile image\" style=\"width:24px; height:24px;\">" + u.getUsername() + "</td><td>" + u.getFirstname() + "</td><td>" + u.getLastname() + "</td><td>" + u.getMoto() + "</td><td>" + u.getJoindate() + "</td></tr>\n";
		}
		
	
		if(request.getParameter("keyword") != null && !request.getParameter("keyword").isEmpty()){
			String keyword = request.getParameter("keyword");
			table2 += "<thead><tr><th>Post</th><th>Post Date</th></tr></thead>";
			ArrayList<Userjpa> lists2 = new ArrayList<Userjpa>(UserDB.selectPostByKeyword(uname, keyword));
			for(Userjpa u : lists2){
				table2 += "<tr><td>" + u.getPost() + "</td><td>" + u.getPostdate() + "</td></tr>\n";
			}
		}else{
			table2 += "<thead><tr><th>Post</th><th>Post Date</th></tr></thead>";
			ArrayList<Userjpa> lists2 = new ArrayList<Userjpa>(UserDB.selectPostByUser(uname));
			for(Userjpa u : lists2){
				table2 += "<tr><td>" + u.getPost() + "</td><td>" + u.getPostdate() + "</td></tr>\n";
			}
		}
		request.setAttribute("table", table); 
		request.setAttribute("table2", table2); 
		String url = "/profile.jsp?uname=" + uname;
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
