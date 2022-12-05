package logical;

import java.io.Serializable;

public class Obrero extends Personal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4470469073842879170L;
	private String oficio;
	
	public Obrero(String cedula, String nombre, String ciudad, String telefono, String oficio) {
		super(cedula, nombre, ciudad, telefono);
		this.setOficio(oficio);
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

}
