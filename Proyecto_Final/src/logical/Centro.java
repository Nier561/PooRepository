package logical;

import java.io.Serializable;

public class Centro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1722582895446153972L;
	private String codigo;
	private String nombre;
	private String ciudad;
	private String telefono;
	
	
	public Centro(String codigo, String nombre, String ciudad, String telefono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.telefono = telefono;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	

}
