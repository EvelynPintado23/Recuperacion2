package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.modelo.Pedido;

/**
 * Servlet implementation class ListarPedido
 */
@WebServlet("/ListarPedido")
public class ListarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PedidoDAO pedidoDAO =DAOFactory.getFactory().getPedidoDAO();
		String url = "";
		if(request.getParameter("pedidos").contentEquals("all")) {
		final java.util.List<Pedido> pedidos= Collections.unmodifiableList(new ArrayList<>(pedidoDAO.findAll()));
		System.out.println(pedidos);
		request.setAttribute("ListPedidos", pedidos);		
		url = "/Publica/listar_pedidos.jsp";
   
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PedidoDAO pedidoDAO =DAOFactory.getFactory().getPedidoDAO();
		System.out.println(request.getParameter("search"));
		List<Pedido> pedidos= pedidoDAO.buscarPorTarjetaComida(request.getParameter("search"));		
		System.out.println(pedidos);
		request.setAttribute("ListPedidos", pedidos);		
		String url = "/Publica/listar_pedidos.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
