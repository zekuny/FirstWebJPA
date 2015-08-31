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

import model.Message;
import model.Userjpa;
import model.Userprofile;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello World");
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("username");
		String table = "";
		String table2 = "";
		
		table += "<thead><tr><th>Sender</th><th>Message</th></tr></thead>";
		ArrayList<Message> lists = new ArrayList<Message>(MessageDB.getAllSender(uname));
		for(Message u : lists){
			String uname2 = u.getSender();
			String profileimage = ProfileDB.getProfileimage(uname2);
			table += "<tr><td><img src=\"" + profileimage + "\" alt=\"Profile image\" style=\"width:24px; height:24px;\">" + uname2 + "</td><td>" + u.getMessage() + "</td></tr>\n";
		}
		
		table2 += "<thead><tr><th>Receiver</th><th>Message</th></tr></thead>";
		ArrayList<Message> lists2 = new ArrayList<Message>(MessageDB.getAllReceiver(uname));
		for(Message u : lists2){
			String uname2 = u.getReceiver();
			String profileimage = ProfileDB.getProfileimage(uname2);
			table2 += "<tr><td><img src=\"" + profileimage + "\" alt=\"Profile image\" style=\"width:24px; height:24px;\">" + uname2 + "</td><td>" + u.getMessage() + "</td></tr>\n";
		}

		request.setAttribute("table", table); 
		request.setAttribute("table2", table2); 
		String url = "/message.jsp?uname=" + uname;
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
