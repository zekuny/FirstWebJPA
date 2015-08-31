import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
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
		String term = request.getParameter("term");
		System.out.println("Data from ajax call " + term);
		// TODO Auto-generated method stub
		//String msg = ""; 
		
		List<Userprofile> lists = ProfileDB.getProfileLike(term);
		
		if(lists != null && lists.size() > 0){
			lists = new ArrayList<Userprofile>(lists);
			ArrayList<String> name = new ArrayList<String>();
			for(Userprofile u : lists){
				name.add(u.getUsername());
			}
			String searchList = new Gson().toJson(name);
			response.getWriter().write(searchList);
		}else{
			String searchList = new Gson().toJson("");
			response.getWriter().write(searchList);
		}
		//System.out.println(msg);
		//response.getWriter().println(msg);
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