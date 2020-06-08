package ec.edu.ups.dao;

import ec.ups.edu.jpa.JPADAOFactory;

public abstract class DAOFactory {

	protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
	return factory;
    }

	public abstract void createTables();
    public abstract PedidoDAO getPedidoDAO();
    public abstract ComidaDAO getComidaDAO();
    public abstract TarjetaDAO getTarjetaDAO();

    
}
