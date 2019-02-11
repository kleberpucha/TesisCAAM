package ec.edu.ups.Vista;

import java.io.IOException;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

import ec.edu.ups.Bussines.PersonaBussines;
import ec.edu.ups.Bussines.TestBussines;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Test;
import ec.edu.ups.Modelo.Usuario;

@ManagedBean
public class PersonaBean {

	@Inject
	private PersonaBussines perBussines;

	@Inject
	private TestBussines Tbussines;

	@Inject
	private FacesContext facesContext;

	private Test newtest;

	private List<Persona> pr;

	private List<Persona> listaUsuarios;

	private List<Test> tesf;

	@Inject
	private UsuarioPreferencia uprefre;

	@PostConstruct
	public void init() {

		Usuario u = uprefre.getUsuario();
		if (u == null) {
			redirigir();
			System.out.println("Error session");
		} else {
			usuLoogin = (u.getPersona().get(0).getNombre() + " " + u.getPersona().get(0).getApellido());
			newtest = new Test();
			newtest.setPersona(new Persona());
			tesf = Tbussines.listar();
			try {
				listaUsuarios = perBussines.ListarTodasD();
				System.out.println("Paso por el constructor");
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}

		}

	}

	public String listarporcedula() {
		Persona prf = new Persona();
		pr = perBussines.listarPersona(cedula);
		prf.setPersonaId(pr.get(0).getPersonaId());
		try {
			if (pr.size() == 0) {

				error();

			} else {
				info(pr.get(0).getNombre(), pr.get(0).getApellido());
				newtest.setPersona(prf);
				Tbussines.save(newtest);
				return "Pasiente?faces-redirect=true";
			}

		} catch (Exception e) {
			error();
			e.printStackTrace();
		}
		return null;

	}

	public String redirigir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/aCaam/faces/Loggin.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Test getNewtest() {
		return newtest;
	}

	public void setNewtest(Test newtest) {
		this.newtest = newtest;
	}

	public List<Test> getTesf() {
		return tesf;
	}

	public void setTesf(List<Test> tesf) {
		this.tesf = tesf;
	}

	public List<Persona> getPr() {
		return pr;
	}

	public void setPr(List<Persona> pr) {
		this.pr = pr;
	}

	public void info(String nombre, String Apellido) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Persona Ingresada:" + nombre + " " + Apellido));
	}

	public void warn() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", "Llenar todos los datos"));
	}

	public void fatal() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));

	}

	public void onClose(CloseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed",
				"Closed panel id:'" + event.getComponent().getId() + "'");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void onToggle(ToggleEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled",
				"Status:" + event.getVisibility().name());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	private String usuLoogin;

	public String getUsuLoogin() {
		return usuLoogin;
	}

	public void setUsuLoogin(String usuLoogin) {
		this.usuLoogin = usuLoogin;
	}

	public List<Persona> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Persona> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	private String cedulafiltradoTest;

	public String getCedulafiltradoTest() {
		return cedulafiltradoTest;
	}

	public void setCedulafiltradoTest(String cedulafiltradoTest) {
		this.cedulafiltradoTest = cedulafiltradoTest;
	}

	
	private List<Test> tst;

	public List<Test> getTst() {
		return tst;
	}

	public void setTst(List<Test> tst) {
		this.tst = tst;
	}
	
	//metodos para poder listar por el id para cargar en la tabla.
	
	public String listarporelId() {
		List<Persona> per =perBussines.listarPersona(cedulafiltradoTest);
		System.out.println(per.get(0).getPersonaId()+ "  ::1234341234134132412341");
		tst = Tbussines.ListarTodasPersonasTestID(per.get(0).getPersonaId());
		nombreTestF = per.get(0).getNombre() +" " + per.get(0).getApellido();
		return null;
	}
	
	private String nombreTestF;

	public String getNombreTestF() {
		return nombreTestF;
	}

	public void setNombreTestF(String nombreTestF) {
		this.nombreTestF = nombreTestF;
	}

}
