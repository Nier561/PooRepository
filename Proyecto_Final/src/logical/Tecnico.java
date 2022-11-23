package logical;

public class Tecnico extends Personal{

	private int anoExp;
	private String areaTecnica;
	
	public Tecnico(String codigo, String nombre, String ciudad, String telefono, String tipo, int anoExp, String areaTecnica) {
		super(codigo, nombre, ciudad, telefono, tipo);
		this.setAnoExp(anoExp);
		this.setAreaTecnica(areaTecnica);
	}

	public int getAnoExp() {
		return anoExp;
	}

	public void setAnoExp(int anoExp) {
		this.anoExp = anoExp;
	}

	public String getAreaTecnica() {
		return areaTecnica;
	}

	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}
}
