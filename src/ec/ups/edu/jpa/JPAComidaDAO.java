package ec.ups.edu.jpa;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.modelo.Comida;
import ec.edu.ups.modelo.Pedido;

public class JPAComidaDAO extends JPAGenericDAO<Comida, Integer> implements ComidaDAO {

	public JPAComidaDAO() {
		// TODO Auto-generated constructor stub
		super(Comida.class);
	}
}
