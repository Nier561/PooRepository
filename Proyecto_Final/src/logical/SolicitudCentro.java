package logical;

import java.io.Serializable;

public class SolicitudCentro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4076665654698112700L;
	private String codigo;
	private String codCentro;
	private String tipoPersonal;
	private int cantPersonal;
	private float  match;
	private String tipoContrato;
	private String sueldo;
	private Boolean dispMudarse;
	private Boolean licenciaConducir;
	private Boolean ingles;
	private String carrera;
	private String oficio;
	private int anoExp;
	private String areTecnica;
	
	
	public SolicitudCentro(String codigo, String codCentro, String tipoPersonal, int cantPersonal,
			String tipoContrato, String sueldo, Boolean dispMudarse, Boolean licenciaConducir, Boolean ingles,
			String carrera, String oficio, int anoExp, String areTecnica) {
		super();
		this.codigo = codigo;
		this.codCentro = codCentro;
		this.tipoPersonal = tipoPersonal;
		this.cantPersonal = cantPersonal;
		this.tipoContrato = tipoContrato;
		this.sueldo = sueldo;
		this.dispMudarse = dispMudarse;
		this.licenciaConducir = licenciaConducir;
		this.ingles = ingles;
		this.carrera = carrera;
		this.oficio = oficio;
		this.anoExp = anoExp;
		this.areTecnica = areTecnica;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodCentro() {
		return codCentro;
	}
	public void setCodCentro(String codCentro) {
		this.codCentro = codCentro;
	}
	public String getTipoPersonal() {
		return tipoPersonal;
	}
	public void setTipoPersonal(String tipoPersonal) {
		this.tipoPersonal = tipoPersonal;
	}
	public int getCantPersonal() {
		return cantPersonal;
	}
	public void setCantPersonal(int cantPersonal) {
		this.cantPersonal = cantPersonal;
	}
	public float getMatch() {
		return match;
	}
	public void setMatch(float match) {
		this.match = match;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getSueldo() {
		return sueldo;
	}
	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}
	public Boolean getDispMudarse() {
		return dispMudarse;
	}
	public void setDispMudarse(Boolean dispMudarse) {
		this.dispMudarse = dispMudarse;
	}
	public Boolean getLicenciaConducir() {
		return licenciaConducir;
	}
	public void setLicenciaConducir(Boolean licenciaConducir) {
		this.licenciaConducir = licenciaConducir;
	}
	public Boolean getIngles() {
		return ingles;
	}
	public void setIngles(Boolean ingles) {
		this.ingles = ingles;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
	public int getAnoExp() {
		return anoExp;
	}
	public void setAnoExp(int anoExp) {
		this.anoExp = anoExp;
	}
	public String getAreTecnica() {
		return areTecnica;
	}
	public void setAreTecnica(String areTecnica) {
		this.areTecnica = areTecnica;
	}
	
	

}
