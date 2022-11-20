package logical;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<SolicitudPersonal> listSolicitudPersonal;
	private ArrayList<SolicitudCentro> listSolicitudCentro;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Centro> listCentro;
	
	
	public Empresa(ArrayList<SolicitudPersonal> listSolicitudPersonal, ArrayList<SolicitudCentro> listSolicitudCentro,
			ArrayList<Personal> listPersonal, ArrayList<Centro> listCentro) {
		super();
		this.listSolicitudPersonal = listSolicitudPersonal;
		this.listSolicitudCentro = listSolicitudCentro;
		this.listPersonal = listPersonal;
		this.listCentro = listCentro;
	}
	
	
	public ArrayList<SolicitudPersonal> getListSolicitudPersonal() {
		return listSolicitudPersonal;
	}
	public void setListSolicitudPersonal(ArrayList<SolicitudPersonal> listSolicitudPersonal) {
		this.listSolicitudPersonal = listSolicitudPersonal;
	}
	public ArrayList<SolicitudCentro> getListSolicitudCentro() {
		return listSolicitudCentro;
	}
	public void setListSolicitudCentro(ArrayList<SolicitudCentro> listSolicitudCentro) {
		this.listSolicitudCentro = listSolicitudCentro;
	}
	public ArrayList<Personal> getListPersonal() {
		return listPersonal;
	}
	public void setListPersonal(ArrayList<Personal> listPersonal) {
		this.listPersonal = listPersonal;
	}
	public ArrayList<Centro> getListCentro() {
		return listCentro;
	}
	public void setListCentro(ArrayList<Centro> listCentro) {
		this.listCentro = listCentro;
	}
	

}
