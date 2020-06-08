package ec.edu.ups.test;

import ec.edu.ups.dao.ComidaDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TarjetaDAO;
import ec.edu.ups.modelo.Comida;
import ec.edu.ups.modelo.Tarjeta;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ComidaDAO comida = DAOFactory.getFactory().getComidaDAO();
		//Comida comi = new Comida("Arroz",50.23);
		//comida.create(comi);
		
		TarjetaDAO tarjeta = DAOFactory.getFactory().getTarjetaDAO();
		//Tarjeta tarjetai = new Tarjeta("4521354796","Visa","05/24",874);
		//Tarjeta tarjetai2 = new Tarjeta("5315247965","Mastercard","11/20",123);
		
		
		//tarjeta.create(tarjetai);
		//tarjeta.create(tarjetai2);
	}

}
