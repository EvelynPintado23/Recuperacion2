package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private Date fecha;
	private String cliente;
	private double total;
	private String observaciones;
	
	@ManyToOne()
    @JoinColumn(name = "tarjeta_num_tarj")
    private Tarjeta tarjeta;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comida> comida;
	
	public Pedido() {
		super();
	}

	public Pedido(int numero, Date fecha, String cliente, double total, String observaciones, Tarjeta tarjeta,
			List<Comida> comida) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.cliente = cliente;
		this.total = total;
		this.observaciones = observaciones;
		this.tarjeta = tarjeta;
		this.comida = comida;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date fecha2) {
		this.fecha = fecha2;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Comida> getComida() {
		return comida;
	}

	public void setComida(List<Comida> comida) {
		this.comida = comida;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + numero;
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((tarjeta == null) ? 0 : tarjeta.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (numero != other.numero)
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (tarjeta == null) {
			if (other.tarjeta != null)
				return false;
		} else if (!tarjeta.equals(other.tarjeta))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", total=" + total
				+ ", observaciones=" + observaciones + ", tarjeta=" + tarjeta + ", comida=" + comida + "]";
	}

   
}
