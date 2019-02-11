package ec.edu.ups.Vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.Bussines.NivelBussines;
import ec.edu.ups.Bussines.ObjetoApredisajeBussines;
import ec.edu.ups.Bussines.PersonaBussines;
import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Usuario;

@ManagedBean
public class ValidarVentanaBean {
	
	@Inject
	private UsuarioPreferencia uprefre;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PersonaBussines perBussines;
	
	@Inject
	private ObjetoApredisajeBussines objAbussines;
	
	@Inject
	private NivelBussines nivBussines;
	
	private List<ObjApre> objfiltrado;
	
	@PostConstruct
	public void init() {
		Usuario u = uprefre.getUsuario();
		if (u == null) {
			redirigir();
			System.out.println("Error session");
		} else {
			usuLoogin=(" " +u.getPersona().get(0).getNombre()+" "+u.getPersona().get(0).getApellido());
			objListaTotal = objAbussines.ListarobjetosTodos();
		}
		
		
	}
	
	/**
	 * medoto  para enviarnos de ubicacion de paginas 
	 * @return
	 */
	public String redirigir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/aCaam/faces/Loggin.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//Metodos para completar los cuadros de texto
	public List<String> completeText() {
		p =  perBussines.ListarTodasD();
		List<String> results = new ArrayList<String>();
		for(int i = 0; i < p.size(); i++) {
            results.add(p.get(i).getCedula());
        }
		return  results;
    }
	
	
	public List<String> completeTextNivel() {
		nivelLis = nivBussines.listarPersona();
		List<String> resultsa = new ArrayList<String>();
		for(int i = 0; i < nivelLis.size(); i++) {
            resultsa.add(nivelLis.get(i).getNombre());
        }
		return  resultsa;
    }
	
	private String usuLoogin;

	public String getUsuLoogin() {
		return usuLoogin;
	}

	public void setUsuLoogin(String usuLoogin) {
		this.usuLoogin = usuLoogin;
	}
	
	private String txt6;

	public String getTxt6() {
		return txt6;
	}
	public void setTxt6(String txt6) {
		this.txt6 = txt6;
	}
	private List<Persona> p;
	
	private List<Nivel> nivelLis;
	
	public List<Persona> getP() {
		return p;
	}
	public void setP(List<Persona> p) {
		this.p = p;
	}
	
	public String  VerStado() { //metodo que nos sirve para hacer la consulta de el id del nivel y el id cedula
		Persona p = new Persona();
		List<Persona> pr = perBussines.listarPersona(txt6);
		int a = pr.get(0).getPersonaId();
		System.err.println(a);
		p.setPersonaId(a);
		Nivel n = new Nivel();
		List<Nivel> lniv = nivBussines.listarPersona(nombrenivel);
		int b = lniv.get(0).getId();
		System.err.println("---: "+b);
		n.setId(b);	
		try {
			
			objListaTotal2 = objAbussines.listarCruce(p, n);
			
			System.out.println(objListaTotal2.size()+"datos ++++ datos ");
			
			return "ListaObjetosFilt";
			
		} catch (Exception e) {
		 e.printStackTrace();
		}
		
		return null;
		
	}
	
	private List<ObjApre> objListaTotal;
	
	private List<ObjApre> objListaTotal2;

	public List<ObjApre> getObjListaTotal() {
		return objListaTotal;
	}
	public void setObjListaTotal(List<ObjApre> objListaTotal) {
		this.objListaTotal = objListaTotal;
	}
	
	private String nombrenivel;

	public String getNombrenivel() {
		return nombrenivel;
	}
	public void setNombrenivel(String nombrenivel) {
		this.nombrenivel = nombrenivel;
	}
	public List<ObjApre> getObjfiltrado() {
		return objfiltrado;
	}
	public void setObjfiltrado(List<ObjApre> objfiltrado) {
		this.objfiltrado = objfiltrado;
	}
	public List<Nivel> getNivelLis() {
		return nivelLis;
	}
	public void setNivelLis(List<Nivel> nivelLis) {
		this.nivelLis = nivelLis;
	}
	public List<ObjApre> getObjListaTotal2() {
		return objListaTotal2;
	}
	public void setObjListaTotal2(List<ObjApre> objListaTotal2) {
		this.objListaTotal2 = objListaTotal2;
	}
	
	
	
}
