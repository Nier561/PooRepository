package logical;

public class SolicitudPersonal {
	
	private String codigo;
	private String codigoPersonal;
	private String tipoContrato;
	private int sueldoDeseado;
	private Boolean dispMudarse;
	private Boolean licenciaConducir;
	private Boolean ingles;
	
	
	public SolicitudPersonal(String codigo, String codigoPersonal, String tipoContrato, int sueldoDeseado,
			Boolean dispMudarse, Boolean licenciaConducir, Boolean ingles) {
		super();
		this.codigo = codigo;
		this.codigoPersonal = codigoPersonal;
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
	public String getCodigoPersonal() {
		return codigoPersonal;
	}
	public void setCodigoPersonal(String codigoPersonal) {
		this.codigoPersonal = codigoPersonal;
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
