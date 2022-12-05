package logical;

import java.io.Serializable;

public abstract class Personal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2274528870932035678L;
	protected String cedula;
	protected String nombre;
	protected String ciudad;
	protected String telefono;
	protected boolean empleado;
	
	public Personal(String cedula, String nombre, String ciudad, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.empleado = false;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCodigo(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isEmpleado() {
		return empleado;
	}

	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
}
