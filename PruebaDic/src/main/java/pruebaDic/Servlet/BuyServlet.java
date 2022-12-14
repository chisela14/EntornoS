package pruebaDic.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pruebaDic.DAO.DaoException;
import pruebaDic.DAO.DaoTrain;
import pruebaDic.DAO.DaoTravel;
import pruebaDic.model.Train;
import pruebaDic.model.Travels;
import pruebaDic.model.User;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/** Recupera el tren por sesión así que no admite parámetros por url
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession(); 
		User userSession = (User) se.getAttribute("user");
		if(userSession !=null){
			//recupero el tren y le resto un ticket
			Train train = (Train) se.getAttribute("train");
			train.setNumbertickets(train.getNumbertickets()-1);
			//lo actualizo en la base de datos
			DaoTrain dt = new DaoTrain();
			try {
				dt.update(train);
				//añado el viaje a la vase de datos
				DaoTravel dtravels = new DaoTravel();
				Travels t = new Travels(userSession, train, 1);
				dtravels.add(t);
			} catch (DaoException e) {
				response.sendRedirect("error.jsp?msg='" + e.getMessage() + "'");
			}
		}else {
			response.sendRedirect("error.jsp?msg='No te has autenticado'");
		}
			
	}

}
