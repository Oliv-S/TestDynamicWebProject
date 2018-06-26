

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.User;
import Repositories.UserRepository;
import Repositories.UserRepositoryInMemory;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserRepository userRepository;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        userRepository = new UserRepositoryInMemory();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user = request.getParameter("user");
		String pass = request.getParameter("pass"); 
		if (user == null||pass==null) {
			response.getWriter().append(showLoginForm());
		}else{
			if (userRepository.isUserExist(user, pass)) {
				response.getWriter().append("<h1>Hello "+ user+ "</h1>"
						+ "Your birtday is <b>" + userRepository.getUserByName(user).getDate().toString() + "</b>");		
				Cookie usercookie = new Cookie("user", user);
				response.addCookie(usercookie);
				//response.sendRedirect("http://www.ya.ru");
			}else {
				response.getWriter().append("<h1>For user "+ user+ " access denied!!</h1>");
				response.getWriter().append(showLoginForm());
			}
		}
		
		
	}
	
	private String showLoginForm() {
		return "<HTML><header>"
				+ "<link rel=\"stylesheet\" href=\"form.css\">"
				+ "</header>"
				+ "<body>"
				+ "<h1>Enter Login and Password:</h1>"
				+ "<form action=''>"
				+ "<ul class=\"form-style-1\">\r\n"  +
				"    <li>"
				+ "		 <label>User <span class=\"required\">*</span></label>"
				+ "		 <input type=\"text\" class=\"field-divided\" name='user'/>"
				+ "	 </li>\r\n" + 
				"    <li>\r\n" + 
				"        <label>Password <span class=\"required\">*</span></label>\r\n" + 
				"        <input type=\"password\" name=\"pass\" class=\"field-divided\" />\r\n" + 
				"    </li>\r\n" + 
				"    <li>\r\n" + 
				"        <input type=\"submit\" value=\"Submit\" />\r\n" + 
				"    </li>\r\n" + 
				"</ul>\r\n" + 
				"</form>"
				+ "</body></HTML>";
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
