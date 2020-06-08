package ec.ups.edu.jpa;

import ec.edu.ups.dao.TarjetaDAO;
import ec.edu.ups.modelo.Pedido;
import ec.edu.ups.modelo.Tarjeta;

public class JPATarjetaDAO extends JPAGenericDAO<Tarjeta, String> implements TarjetaDAO{

	public JPATarjetaDAO() {
		// TODO Auto-generated constructor stub
		super(Tarjeta.class);
	}

}
