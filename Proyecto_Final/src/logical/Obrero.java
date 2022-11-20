package logical;

public class Obrero extends Personal{

	private String oficio;
	
	public Obrero(String codigo, String nombre, String ciudad, String telefono, String oficio) {
		super(codigo, nombre, ciudad, telefono);
		this.setOficio(oficio);
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

}
