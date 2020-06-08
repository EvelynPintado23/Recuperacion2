package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tarjeta
 *
 */
@Entity
@Table(name = "tarjeta")
public class Tarjeta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String numero_tarjeta;
	private String nombre;
	private String fecha_caducidad;
	private String ccv;
	
	@OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedido;
    
    
	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarjeta(String numero_tarjeta, String nombre, String fecha_caducidad, String ccv,
			List<Pedido> pedido) {
		super();
		this.numero_tarjeta = numero_tarjeta;
		this.nombre = nombre;
		this.fecha_caducidad = fecha_caducidad;
		this.ccv = ccv;
		this.pedido = pedido;
	}
	
	public Tarjeta(String numero_tarjeta, String nombre, String fecha_caducidad, String ccv) {
		super();
		this.numero_tarjeta = numero_tarjeta;
		this.nombre = nombre;
		this.fecha_caducidad = fecha_caducidad;
		this.ccv = ccv;

	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(String fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccv == null) ? 0 : ccv.hashCode());
		result = prime * result + ((fecha_caducidad == null) ? 0 : fecha_caducidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numero_tarjeta == null) ? 0 : numero_tarjeta.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
		Tarjeta other = (Tarjeta) obj;
		if (ccv == null) {
			if (other.ccv != null)
				return false;
		} else if (!ccv.equals(other.ccv))
			return false;
		if (fecha_caducidad == null) {
			if (other.fecha_caducidad != null)
				return false;
		} else if (!fecha_caducidad.equals(other.fecha_caducidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numero_tarjeta == null) {
			if (other.numero_tarjeta != null)
				return false;
		} else if (!numero_tarjeta.equals(other.numero_tarjeta))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tarjeta [numero_tarjeta=" + numero_tarjeta + ", nombre=" + nombre + ", fecha_caducidad="
				+ fecha_caducidad + ", ccv=" + ccv + ", pedido=" + pedido + "]";
	}
	
}
