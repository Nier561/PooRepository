package logical;

public class SolicitudPersonal {
	
	private String codigo;
	private String cedulaPersonal;
	private String tipoContrato;
	private String sueldoDeseado;
	private Boolean dispMudarse;
	private Boolean licenciaConducir;
	private Boolean ingles;
	private String carrera;
	private int agnosExp;
	private String areaTecnica;
	private String oficio;
	
	
	public SolicitudPersonal(String codigo, String cedulaPersonal, String tipoContrato, String sueldoDeseado, Boolean dispMudarse, 
			Boolean licenciaConducir, Boolean ingles, String carrera, int agnosExp, String areaTecnica, String oficio) {
		super();
		this.codigo = codigo;
		this.cedulaPersonal = cedulaPersonal;
		this.tipoContrato = tipoContrato;
		this.sueldoDeseado = sueldoDeseado;
		this.dispMudarse = dispMudarse;
		this.licenciaConducir = licenciaConducir;
		this.ingles = ingles;
		this.carrera = carrera;
		this.agnosExp = agnosExp;
		this.areaTecnica = areaTecnica;
		this.oficio = oficio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCedulaPersonal() {
		return cedulaPersonal;
	}
	public void setCedulaPersonal(String cedulaPersonal) {
		this.cedulaPersonal = cedulaPersonal;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getSueldoDeseado() {
		return sueldoDeseado;
	}
	public void setSueldoDeseado(String sueldoDeseado) {
		this.sueldoDeseado = sueldoDeseado;
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
	public int getAgnosExp() {
		return agnosExp;
	}
	public void setAgnosExp(int agnosExp) {
		this.agnosExp = agnosExp;
	}
	public String getAreaTecnica() {
		return areaTecnica;
	}
	public void setAreaTecnica(String areaTecnica) {
		this.areaTecnica = areaTecnica;
	}
	public String getOficio() {
		return oficio;
	}
	public void setOficio(String oficio) {
		this.oficio = oficio;
	}
}
