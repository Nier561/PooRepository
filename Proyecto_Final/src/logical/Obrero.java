package logical;

public class Obrero extends Personal{

	private String oficio;
	
	public Obrero(String cedula, String nombre, String ciudad, String telefono, String tipo,String oficio) {
		super(cedula, nombre, ciudad, telefono, tipo);
		this.setOficio(oficio);
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

}
