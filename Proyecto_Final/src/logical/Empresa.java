package logical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Empresa{

	private ArrayList<SolicitudPersonal> listSolicitudPersonal;
	private ArrayList<SolicitudCentro> listSolicitudCentro;
	private ArrayList<Personal> listPersonal;
	private ArrayList<Centro> listCentro;
	private ArrayList<Integer> gens;
	private static Empresa empresa = null;
	public int generadorSolicitudPersonal = 1;
	public int generadorSolicitudCentro = 1;
	public int generadorCentro = 1;
	
	
	private Empresa() {
		super();
		this.listSolicitudPersonal = new ArrayList<SolicitudPersonal>();
		this.listSolicitudCentro = new ArrayList<SolicitudCentro>();
		this.listPersonal = new ArrayList<Personal>();
		this.listCentro = new ArrayList<Centro>();
		this.gens = new ArrayList<Integer>();
        gens.add(0, this.generadorSolicitudPersonal);
        gens.add(1, this.generadorSolicitudCentro);
        gens.add(2, this.generadorSolicitudPersonal);
	}
	
	public static Empresa getInstance(){
		   if(empresa == null){
			   empresa = new Empresa();  
		   } 	   
		return empresa;
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fileStream = new FileInputStream("save_centro.dat");
        ObjectInputStream objStream = new ObjectInputStream(fileStream);
        this.listCentro = (ArrayList<Centro>)objStream.readObject();
        objStream.close();
        
        fileStream = new FileInputStream("save_personal.dat");
        objStream = new ObjectInputStream(fileStream);
        this.listPersonal = (ArrayList<Personal>)objStream.readObject();
        objStream.close();
        
        fileStream = new FileInputStream("save_solPer.dat");
        objStream = new ObjectInputStream(fileStream);
        this.listSolicitudPersonal = (ArrayList<SolicitudPersonal>)objStream.readObject();
        objStream.close();
        
        fileStream = new FileInputStream("save_solCen.dat");
        objStream = new ObjectInputStream(fileStream);
        this.listSolicitudCentro = (ArrayList<SolicitudCentro>)objStream.readObject();
        objStream.close();
        
        fileStream = new FileInputStream("save_gens.dat");
        objStream = new ObjectInputStream(fileStream);
        this.gens = (ArrayList<Integer>)objStream.readObject();
        this.generadorCentro = this.gens.get(0);
        this.generadorSolicitudCentro = this.gens.get(1);
        this.generadorSolicitudPersonal = this.gens.get(2);
        objStream.close();
	}
	
	public void save() throws FileNotFoundException, IOException {
		FileOutputStream fileStream = new FileOutputStream("save_personal.dat");
		ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
		objStream.writeObject(listPersonal);
		objStream.flush();
		objStream.close();
		
		fileStream = new FileOutputStream("save_centro.dat");
        objStream = new ObjectOutputStream(fileStream);
		objStream.writeObject(listCentro);
		objStream.flush();
        objStream.close();
        
        fileStream = new FileOutputStream("save_solPer.dat");
        objStream = new ObjectOutputStream(fileStream);
		objStream.writeObject(listSolicitudPersonal);
		objStream.flush();
        objStream.close();
        
        fileStream = new FileOutputStream("save_solCen.dat");
        objStream = new ObjectOutputStream(fileStream);
		objStream.writeObject(listSolicitudCentro);
		objStream.flush();
        objStream.close();
        
        gens.add(0, this.generadorCentro);
        gens.add(1, this.generadorSolicitudCentro);
        gens.add(2, this.generadorSolicitudPersonal);
        fileStream = new FileOutputStream("save_gens.dat");
        objStream = new ObjectOutputStream(fileStream);
		objStream.writeObject(gens);
		objStream.flush();
        objStream.close();
	}
	

	public int match(SolicitudCentro solCen, SolicitudPersonal solPer) {
		int match = 0;
		String tipo = identificarTipo(buscarPersonalByCedula(solPer.getCedulaPersonal()));
		if(tipo.equalsIgnoreCase(solCen.getTipoPersonal()))
			match += 30;
		switch(tipo){
		
			case "Universitario":
				if(solPer.getCarrera().equalsIgnoreCase(solCen.getCarrera()))
					match += 15;
				break;
				
			case "Tecnico":
				if(solPer.getAgnosExp() >= solCen.getAnoExp())
					match += 5;
				if(solPer.getAreaTecnica().equalsIgnoreCase(solCen.getAreTecnica()))
					match += 10;
				break;
			
			case "Obrero":
				if(solPer.getOficio().equalsIgnoreCase(solCen.getOficio()))
					match += 15;
				break;
		}
		
		if(solPer.getTipoContrato().equalsIgnoreCase(solCen.getTipoContrato()))
			match += 15;
		
		if(solPer.getSueldoDeseado().equalsIgnoreCase(solCen.getSueldo()))
			match += 15;
		
		if (!solCen.getDispMudarse())
			match += 10;
		else if(solPer.getDispMudarse() == solCen.getDispMudarse())
			match += 10;
		
		if (!solCen.getIngles())
			match += 10;
		else if(solPer.getIngles() == solCen.getIngles())
			match += 10;
		
		if (!solCen.getLicenciaConducir())
			match += 5;
		else if(solPer.getLicenciaConducir() == solCen.getLicenciaConducir())
			match += 5;
		
		return match;
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
	public int getGeneradorSolicitudPersonal() {
		return generadorSolicitudPersonal;
	}
	public void setGeneradorSolicitudPersonal(int generadorSolicitudPersonal) {
		this.generadorSolicitudPersonal = generadorSolicitudPersonal;
	}
	public int getGeneradorSolicitudCentro() {
		return generadorSolicitudCentro;
	}
	public void setGeneradorSolicitudCentro(int generadorSolicitudCentro) {
		this.generadorSolicitudCentro = generadorSolicitudCentro;
	}
	public int getGeneradorCentro() {
		return generadorCentro;
	}
	public void setGeneradorCentro(int generadorCentro) {
		this.generadorCentro = generadorCentro;
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
