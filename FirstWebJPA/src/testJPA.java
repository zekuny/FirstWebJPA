

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Userjpa;
/**
 * Servlet implementation class testJPA
 */
@WebServlet("/testJPA")
public class testJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testJPA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// write to /output.jsp
		String table = "";
		response.setContentType("text/html");
		
		if(request.getParameter("keyword") != null && !request.getParameter("keyword").isEmpty()){
			String keyword = request.getParameter("keyword");
			// get all from database
			ArrayList<Userjpa> lists = new ArrayList<Userjpa>(UserDB.selectSearchResult(keyword));
			if(lists == null || lists.size() == 0){
				table += "<h1>nonono</h1>";
			}else{
				table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
					    + "<thead>" + "<tr>" + "<th>User Name</th>" + "<th>Post</th>" + "<th>Post Date</th></tr>"
					    +   "</thead>" + "<tbody>";	    
				for(Userjpa u : lists){
					table += "<tr>";
					table += "<td><a href = \"ProfileServlet?uname=" + u.getUsername() + "\">" + u.getUsername() + "</a></td>";
					table += "<td>" + u.getPost() + "</td>";
					table += "<td>" + u.getPostdate() + "</td>";
					table += "</tr>";
				}
				table += "</tbody>" + "</table>" + "</div>";
				table += "<br/><br/>";
			}
		}else{
			if(request.getParameter("username") != null && !request.getParameter("username").isEmpty()){
				// TODO Auto-generated method stub
				//EntityManager em = DBUtil.getEmFactory().createEntityManager();   
				String username = request.getParameter("username");
				String post = request.getParameter("post");
				String postDate = request.getParameter("postDate");
				Userjpa userjpa = new Userjpa();
				userjpa.setUsername(username);
				userjpa.setPost(post);
				userjpa.setPostdate(postDate);
				//userjpa.setUserid(uid++);	
				UserDB.insert(userjpa);
			}
			// get all from database
			ArrayList<Userjpa> lists = new ArrayList<Userjpa>(UserDB.selectAllUser());
			if(lists == null || lists.size() == 0){
				table += "<h1>nonono</h1>";
			}else{
				table += "<div class=\"container\">" + "<h2>Result</h2>" + "<table class=\"table table-condensed\">"
					    + "<thead>" + "<tr>" + "<th>User Name</th>" + "<th>Post</th>" + "<th>Post Date</th></tr>"
					    +   "</thead>" + "<tbody>";	    
				for(Userjpa u : lists){
					table += "<tr>";
					table += "<td><a href = \"ProfileServlet?uname=" + u.getUsername() + "\">" + u.getUsername() + "</a></td>";
					table += "<td>" + u.getPost() + "</td>";
					table += "<td>" + u.getPostdate() + "</td>";
					table += "</tr>";
				}
				table += "</tbody>" + "</table>" + "</div>";
				table += "<br/><br/>";
			}
		}
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
