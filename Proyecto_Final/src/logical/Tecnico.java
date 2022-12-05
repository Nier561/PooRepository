package logical;

import java.io.Serializable;

public class Tecnico extends Personal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4404297198586163246L;
	private int anoExp;
	private String areaTecnica;
	
	public Tecnico(String cedula, String nombre, String ciudad, String telefono, int anoExp, String areaTecnica) {
		super(cedula, nombre, ciudad, telefono);
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
