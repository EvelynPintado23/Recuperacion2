package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TarjetaDAO;
import ec.edu.ups.modelo.Tarjeta;

/**
 * Servlet implementation class IngresarTarjeta2
 */
@WebServlet("/IngresarTarjeta2")
public class IngresarTarjeta2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarTarjeta2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		TarjetaDAO tarjetaDao= DAOFactory.getFactory().getTarjetaDAO();
		
		Tarjeta tarjeta=new Tarjeta();
        tarjeta.setNumero_tarjeta("5423698742");
        tarjeta.setNombre("Evelyn");
        tarjeta.setFecha_caducidad("05/05/20");
        tarjeta.setCcv("532");
        
        tarjetaDao.create(tarjeta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

        
        //request.setAttribute("tarjetas", tarjetaDao.findAll());
       // String url = "/Publica/crear_tarjeta.jsp";
        //getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
