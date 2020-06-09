package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.dao.TarjetaDAO;
import ec.edu.ups.modelo.Comida;
import ec.edu.ups.modelo.Pedido;
import ec.edu.ups.modelo.Tarjeta;

/**
 * Servlet implementation class IngresarPedido
 */
@WebServlet("/IngresarPedido")
public class IngresarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private Pedido pedido;
	private double total_pedido;
	private boolean bandera;
	List<Comida> comidas;
	private Tarjeta tarjeta;
	private Date fecha;
	private Pedido p;
	private PedidoDAO pedidoDAO ;
	private ComidaDAO comidaDAO;
	private TarjetaDAO tarjetaDAO ;
	public IngresarPedido() {
		super();
		// TODO Auto-generated constructor stub
		pedidoDAO = DAOFactory.getFactory().getPedidoDAO();
		comidaDAO = DAOFactory.getFactory().getComidaDAO();
		tarjetaDAO = DAOFactory.getFactory().getTarjetaDAO();
		pedido = new Pedido();
		total_pedido = 0.0;
		bandera = false;
		comidas = new ArrayList<Comida>();
		tarjeta= new Tarjeta();
		fecha=null;
		p=new Pedido();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String url = null;
		
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String accion = request.getParameter("accion");

		
		tarjeta = tarjetaDAO.read(request.getParameter("tarjeta"));
		total_pedido =total_pedido+ Double.parseDouble(request.getParameter("precio"));

		if (accion.equals("Agregar")) {

			if (tarjeta == null) {
				request.setAttribute("Message",
						"<div class=\"alert alert-danger\" role=\"alert\">La ingresada no esta registrada</div>");
				url = "/Publica/crear_pedido.jsp";

			} else {

				if (bandera) {
					
					Comida comida = new Comida();
					comida.setNombre(request.getParameter("nombre_comida"));
					comida.setPrecio_unitario(Double.parseDouble(request.getParameter("precio")));
					p=pedidoDAO.buscar("cliente", request.getParameter("cliente").toUpperCase());
					p.setTotal(total_pedido);
					pedidoDAO.update(p);
					comida.setPedido(p);
					comidaDAO.create(comida);
					comidas.add(comida);
				} else {
					LocalDateTime localDateTime = LocalDateTime.now();
					ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneOffset.systemDefault());
					Instant instant = zonedDateTime.toInstant();
					fecha = Date.from(instant);

					pedido.setCliente(request.getParameter("cliente").toUpperCase());
					pedido.setObservaciones(request.getParameter("observaciones").toUpperCase());
					pedido.setTarjeta(tarjeta);
					pedido.setFecha(fecha);
					bandera=true;
					pedidoDAO.create(pedido);

				}


			}
			request.setAttribute("total", total_pedido);
			request.setAttribute("pedido", pedido);
			url = "/Paginas/RegistrarPedido.jsp";
		}
		
		if(accion.equals("Realizar Pedido")) {
			List<Pedido> ped = new ArrayList<Pedido>();
		    Pedido pedi = new Pedido();
			pedi=pedidoDAO.buscar("cliente", request.getParameter("cliente").toUpperCase());
			ped.add(pedi);
			tarjeta.setPedido(ped);
			tarjetaDAO.update(tarjeta);
			pedi.setComida(comidas);
			System.out.println("TOTAL.."+total_pedido);
			pedi.setTotal(total_pedido);
			pedidoDAO.update(pedido);
			
			pedido= new Pedido();
			total_pedido=0.0;
			request.setAttribute("total", total_pedido);
			request.setAttribute("pedido", pedido);
			request.setAttribute("Message",
					"<div class=\"alert alert-success\" role=\"alert\">\r\n" + "  Pedido Realizado" + "</div>");
			url = "/Paginas/RegistrarPedido.jsp";
			
		}


		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
