package logical;

public class Universitario extends Personal{
	
	private String carrera;
	
	public Universitario(String codigo, String nombre, String ciudad, String telefono, String tipo, String carrera) {
		super(codigo, nombre, ciudad, telefono, tipo);
		this.setCarrera(carrera);
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
}
