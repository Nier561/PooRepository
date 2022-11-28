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
	
	public SolicitudPersonal buscarSolicitudPersonalByCodigo(String codigo) {
		SolicitudPersonal auxSolicitudPersonal = null;
		boolean encontrado = false;
		int ind = 0;
		while(ind < listSolicitudPersonal.size() && !encontrado) {
			auxSolicitudPersonal = listSolicitudPersonal.get(ind);
			if(auxSolicitudPersonal.getCodigo().equalsIgnoreCase(codigo)) {
				encontrado = true;
			}
			ind++;
		}
		return auxSolicitudPersonal;
	}

	public void eliminarPersonal(Personal selected) {
		int ind = -1;
		ind = buscarIndByPersonal(selected.getCedula());
		listPersonal.remove(ind);
	}
	
	public int buscarIndByPersonal(String codigo) {
		int aux = -1;
		int ind = 0;
		boolean encontrado = false;
		while(ind < listPersonal.size() && !encontrado) {
			if(listPersonal.get(ind).getCedula().equalsIgnoreCase(codigo)) {
				aux = ind;
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
	
	public String identificarTipo(Personal personal) {
		String resp = null;
		if(personal instanceof Universitario) {
			resp = "Universitario";
		}
		if(personal instanceof Tecnico) {
			resp = "Tecnico";
		}
		if(personal instanceof Obrero) {
			resp = "Obrero";
		}
		return resp;
	}

	public void eliminarSolicitudPersonal(SolicitudPersonal selected) {
		int ind = -1;
		ind = buscarIndBySolicitudPersonal(selected.getCodigo());
		listSolicitudPersonal.remove(ind);
	}
	
	public int buscarIndBySolicitudPersonal(String codigo) {
		int aux = -1;
		int ind = 0;
		boolean encontrado = false;
		while(ind < listSolicitudPersonal.size() && !encontrado) {
			if(listSolicitudPersonal.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
				aux = ind;
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
	
	public Centro buscarCentroByCod(String cod) {
		Centro auxCentro = null;
		boolean encontrado = false;
		int ind = 0;
		while(ind < listCentro.size() && !encontrado) {
			auxCentro = listCentro.get(ind);
			if(auxCentro.getCodigo().equalsIgnoreCase(cod)) {
				encontrado = true;
			}
			ind++;
		}
		return auxCentro;
	}
	
	public void eliminarCentro(Centro selected) {
		int ind = -1;
		ind = buscarIndByCentro(selected.getCodigo());
		listCentro.remove(ind);
	}
	
	public int buscarIndByCentro(String codigo) {
		int aux = -1;
		int ind = 0;
		boolean encontrado = false;
		while(ind < listCentro.size() && !encontrado) {
			if(listCentro.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
				aux = ind;
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
	
	public SolicitudCentro buscarSolicitudCentroByCod(String cod) {
		SolicitudCentro auxSolCentro = null;
		boolean encontrado = false;
		int ind = 0;
		while(ind < listSolicitudCentro.size() && !encontrado) {
			auxSolCentro = listSolicitudCentro.get(ind);
			if(auxSolCentro.getCodigo().equalsIgnoreCase(cod)) {
				encontrado = true;
			}
			ind++;
		}
		return auxSolCentro;
	}
	
	public void eliminarSolicitudCentro(SolicitudCentro selected) {
		int ind = -1;
		ind = buscarIndBySolicitudCentro(selected.getCodigo());
		listSolicitudCentro.remove(ind);
	}
	
	public int buscarIndBySolicitudCentro(String codigo) {
		int aux = -1;
		int ind = 0;
		boolean encontrado = false;
		while(ind < listSolicitudCentro.size() && !encontrado) {
			if(listSolicitudCentro.get(ind).getCodigo().equalsIgnoreCase(codigo)) {
				aux = ind;
				encontrado = true;
			}
			ind++;
		}
		return aux;
	}
}
