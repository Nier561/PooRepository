package logical;

public abstract class Personal {
	
	protected String cedula;
	protected String nombre;
	protected String ciudad;
	protected String telefono;
	protected String tipo;
	protected boolean empleado;
	
	public Personal(String cedula, String nombre, String ciudad, String telefono, String tipo) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.tipo = tipo;
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
	
	public String getTIpo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isEmpleado() {
		return empleado;
	}

	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
}
