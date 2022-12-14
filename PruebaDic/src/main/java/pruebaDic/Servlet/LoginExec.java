package pruebaDic.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pruebaDic.DAO.DaoException;
import pruebaDic.DAO.DaoUser;
import pruebaDic.model.User;

/**
 * Servlet implementation class LoginExec
 */
@WebServlet("/LoginExec")
public class LoginExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginExec() {
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
		String username = request.getParameter("nombre");
		String password = request.getParameter("pass");
		String error = null;
		//compruebo que se introducen valores
		if(username.isEmpty() || username.isBlank()|| username == null ||
				password.isBlank() || password.isEmpty() || password == null) {
			error = "Debes introducir un usuario y una contraseña";
		}else {
			//compruebo que el usuario es válido
			DaoUser du = new DaoUser();
			User user = null;
			try {
				user = du.get(username);
				//compruebo que la contraseña coincide
				if(du.checkUser(user, password)) {
					//el usuario existe y coincide, creo sesión y redirijo
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("indexForUser.jsp");
					//response.sendRedirect("index.jsp");
				}else {
					//en este caso falla la contraseña
					error = "El usuario o la contraseña no son correctos";
				}
			} catch (DaoException e) {
				//aunque solo falle el usuario pongo este mensaje
				error = "El usuario o la contraseña no son correctos";
			}
			
		}
		if(error != null) {
			response.getWriter().append("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "	<title>Error</title>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "    <div>\n"
					+ "        <h1>Error</h1>\n"
					+ "        <h2>" + error + "</h2>\n"
					+ "        <a href=\"index.jsp\">Volver al inicio</a>\n"
					+ "    </div>\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		
	}

}
