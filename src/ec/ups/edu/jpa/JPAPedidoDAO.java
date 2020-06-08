package ec.ups.edu.jpa;

import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.Query;

import ec.edu.ups.dao.PedidoDAO;
import ec.edu.ups.modelo.Pedido;

public class JPAPedidoDAO extends JPAGenericDAO<Pedido, Integer> implements PedidoDAO{

	public JPAPedidoDAO() {
		// TODO Auto-generated constructor stub
		super(Pedido.class);
		this.em = Persistence.createEntityManagerFactory("Recuperacion2").createEntityManager();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Pedido> buscarPorTarjetaComida(String context) {
		List<Pedido> lista = null;
		Query nativeQuery = em.createNativeQuery("SELECT * FROM pedido p WHERE p.TARJETACREDITO_NUMERO = ?;",Pedido.class);
		nativeQuery.setParameter(1, context);
		return (List<Pedido>) nativeQuery.getResultList();
	

	}
}