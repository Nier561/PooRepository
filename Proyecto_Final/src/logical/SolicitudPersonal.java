package logical;

public class SolicitudPersonal {
	
	private String codigo;
	private String cedulaPersonal;
	private String tipoContrato;
	private int sueldoDeseado;
	private Boolean dispMudarse;
	private Boolean licenciaConducir;
	private Boolean ingles;
	
	
	public SolicitudPersonal(String codigo, String cedulaPersonal, String tipoContrato, int sueldoDeseado,
			Boolean dispMudarse, Boolean licenciaConducir, Boolean ingles) {
		super();
		this.codigo = codigo;
		this.cedulaPersonal = cedulaPersonal;
		this.tipoContrato = tipoContrato;
		this.sueldoDeseado = sueldoDeseado;
		this.dispMudarse = dispMudarse;
		this.licenciaConducir = licenciaConducir;
		this.ingles = ingles;
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
	public int getSueldoDeseado() {
		return sueldoDeseado;
	}
	public void setSueldoDeseado(int sueldoDeseado) {
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
	

}
