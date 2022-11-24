package logical;

import java.util.ArrayList;

public class Empresa {
	
	private ArrayList<SolicitudPersonal> listSolicitudPersonal;
	private ArrayList<SolicitudCentro> listSolicitudCentro;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Centro> listCentro;
	private static Empresa empresa = null;
	public static int generadorSolicitudPersonal = 1;
	public static int generadorSolicitudCentro = 1;
	public static int generadorCentro = 1;
	
	private Empresa() {
		super();
		this.listSolicitudPersonal = new ArrayList<SolicitudPersonal>();
		this.listSolicitudCentro = new ArrayList<SolicitudCentro>();
		this.listPersonal = new ArrayList<Personal>();
		this.listCentro = new ArrayList<Centro>();
	}
	
	public static Empresa getInstance(){
		   if(empresa == null){
			   empresa = new Empresa();  
		   } 	   
		return empresa;
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
	
	public void insertarPersonal(Personal personal) {
		listPersonal.add(personal);
	}
	
	public void insertarCentro(Centro centro) {
		listCentro.add(centro);
		generadorCentro++;
	}
	
	public void insertarSolicitudPersonal(SolicitudPersonal sp) {
		listSolicitudPersonal.add(sp);
		generadorSolicitudPersonal++;
	}
	
	public void insertarSolicitudCentro(SolicitudCentro sc) {
		listSolicitudCentro.add(sc);
		generadorSolicitudCentro++;
	}
	
	public Personal buscarPersonalByCedula(String cedula) {
		Personal auxPersonal = null;
		boolean encontrado = false;
		int ind = 0;
		while(ind < listPersonal.size() && !encontrado) {
			auxPersonal = listPersonal.get(ind);
			if(auxPersonal.getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
			}
			ind++;
		}
		return auxPersonal;
	}
}
