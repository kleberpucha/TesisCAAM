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

import ec.edu.ups.Bussines.ComentariosBussines;
import ec.edu.ups.Bussines.NivelBussines;
import ec.edu.ups.Bussines.ObjetoApredisajeBussines;
import ec.edu.ups.Bussines.PersonaBussines;
import ec.edu.ups.Modelo.Comentarios;
import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Usuario;
import ec.edu.ups.Temporales.TemporalComentarios;

@ManagedBean
public class ComentariosBean {

	@Inject
	private ObjetoApredisajeBussines objAbussines;

	@Inject
	private NivelBussines nivBussines;

	@Inject
	private PersonaBussines perbussiens;

	@Inject
	private ComentariosBussines cmBussines;

	@Inject
	private FacesContext FacesContext;

	@Inject
	private UsuarioPreferencia uprefre;

	private List<TemporalComentarios> tempocomentarios;
	
	/**
	 * si el usuario no tiene seccion 
	 * 
	 */
	@PostConstruct
	public void init() {
		
		Usuario u = uprefre.getUsuario();

		if (u == null) {
			redirigir();
			System.out.println("Error session");
		} else {
			usuLoogin = (" " + u.getPersona().get(0).getNombre() + " " + u.getPersona().get(0).getApellido());
			tempocomentarios = cmBussines.ListadoNocomentarios(u.getPersona().get(0).getPersonaId());
		}
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

	public void ListarNo() {

		Usuario u = uprefre.getUsuario();
		System.out.println(u.getPersona().get(0).getPersonaId());

		System.out.println(tempocomentarios.size());
	}

	public String updateComentario(String codigo, String detalle, String idemisor , String idreseptor, String idobjeto  ) {	
		
		try {
			System.out.println("____________________________");
			System.out.println("codigo"+ codigo +"detalle"+ detalle +"emosor"+ idemisor +"Receptor"+ idreseptor +"Idobjeoto"+ idobjeto);
			
			Persona emisor = new Persona();
			emisor.setPersonaId(Integer.parseInt(idemisor));
			
			Persona reseptor = new Persona();
			reseptor.setPersonaId(Integer.parseInt(idreseptor));
			
			ObjApre ombj = new ObjApre();
			ombj.setId(Integer.parseInt(idobjeto));
			
			Comentarios comen = new Comentarios();
			comen.setComentario(detalle);
			comen.setComentarioid(Integer.parseInt(codigo));
			comen.setEmisor(emisor);
			comen.setReceptor(reseptor);
			comen.setObjetoApredisaje(ombj);
			comen.setEstado("S");
			cmBussines.update(comen);
			System.out.println("____________________________");
			Visto();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// metodos insertar y actualizar

	public String insertar() {
		try {
			System.out.println("--1--");
			Persona receptor = new Persona();
			List<Persona> a = perbussiens.listarPersona(cedula);
			receptor.setPersonaId(a.get(0).getPersonaId());
			System.out.println("--receptro--" + a.get(0).getPersonaId());
			Nivel nf = new Nivel();
			List<Nivel> niv = nivBussines.listarPersona(nivel);
			nf.setId(niv.get(0).getId());
			System.out.println("--nivel--" + niv.get(0).getId());
			ObjApre o = new ObjApre();
			int valorid = returnidobjeto();
			o.setId(valorid);
			System.out.println("--objeto--" + valorid);

			Comentarios comentarioin = new Comentarios();
			Usuario un = uprefre.getUsuario();
			Persona emisor = new Persona();

			emisor.setPersonaId(un.getPersona().get(0).getPersonaId());
			System.out.println("--emisor--" + un.getPersona().get(0).getPersonaId());
			comentarioin.setEmisor(emisor);
			comentarioin.setEstado("N");
			comentarioin.setReceptor(receptor);
			comentarioin.setComentario(comentario);
			comentarioin.setObjetoApredisaje(o);

			cmBussines.inserta(comentarioin);
			info();

		} catch (Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
			// error();
		}
		return null;
	}

	public int returnidobjeto() {

		Persona p1 = new Persona();
		List<Persona> a = perbussiens.listarPersona(cedula);
		p1.setPersonaId(a.get(0).getPersonaId());
		System.out.println("  adadadad " + a.get(0).getPersonaId());
		Nivel nf = new Nivel();
		List<Nivel> niv = nivBussines.listarPersona(nivel);
		nf.setId(niv.get(0).getId());
		System.out.println("  adadadad " + a.get(0).getPersonaId());
		List<ObjApre> n = objAbussines.liestarcontresparametros(p1, nf, tarea);
		System.out.println(n.get(0).getId() + "  ++++ ");
		return n.get(0).getId();
	}

	// metodos para compleatar y luego insertar el comentario
	public List<String> completetaTarea() {
		List<ObjApre> p = objAbussines.ListarobjetosTodos();
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < p.size(); i++) {
			results.add(p.get(i).getTarea());
		}
		return results;
	}

	public List<String> completeText() {
		p = perbussiens.ListarTodasD();
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < p.size(); i++) {
			results.add(p.get(i).getCedula());
		}
		return results;
	}

	public List<String> completeTextNivel() {
		nivelLis = nivBussines.listarPersona();
		List<String> resultsa = new ArrayList<String>();
		for (int i = 0; i < nivelLis.size(); i++) {
			resultsa.add(nivelLis.get(i).getNombre());
		}
		return resultsa;
	}

	public void actualizar() {

	}

	// getters and setters
	private List<ObjApre> objListaTotal;
	private String usuLoogin;
	private String tarea;
	private String cedula;
	private String nivel;
	private String comentario;
	private List<Persona> p;
	private List<Nivel> nivelLis;

	public List<ObjApre> getObjListaTotal() {
		return objListaTotal;
	}

	public void setObjListaTotal(List<ObjApre> objListaTotal) {
		this.objListaTotal = objListaTotal;
	}

	public String getUsuLoogin() {
		return usuLoogin;
	}

	public void setUsuLoogin(String usuLoogin) {
		this.usuLoogin = usuLoogin;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public PersonaBussines getPerbussiens() {
		return perbussiens;
	}

	public void setPerbussiens(PersonaBussines perbussiens) {
		this.perbussiens = perbussiens;
	}

	public List<Persona> getP() {
		return p;
	}

	public void setP(List<Persona> p) {
		this.p = p;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	// PARA MOSTRAR LOS DATOS DE INGRESOS O DENEGADOS

	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Comentario Realizado"));
	}

	public void Visto() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Visto"));
	}

	public void warn() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
	}

	public void fatal() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
	}

	public List<TemporalComentarios> getTempocomentarios() {
		return tempocomentarios;
	}

	public void setTempocomentarios(List<TemporalComentarios> tempocomentarios) {
		this.tempocomentarios = tempocomentarios;
	}

}
