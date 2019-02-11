package ec.edu.ups.Vista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import ec.edu.ups.Bussines.PersonaBussines;
import ec.edu.ups.Bussines.SuscripcionClienteNivelBussines;
import ec.edu.ups.Bussines.UsuarioBussines;
import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.SuscripcionClienteNivel;
import ec.edu.ups.Modelo.Usuario;
//import ec.edu.ups.Util.Validadores;

@ManagedBean
public class UsuarioBeanInserar {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PersonaBussines perBussiens;
	
	@Inject
	private SuscripcionClienteNivelBussines suscripBussines;
	
	@Inject
	private UsuarioBussines usubusines;
	private Usuario newusuario;
	
	
	
	@PostConstruct
	public void init() {
		newusuario = new Usuario();
		newusuario.addPersona(new Persona());
		usuario = usubusines.getListadoUsuario();			
	}
	public String addUsuario() {
		try {
			newusuario.addPersona(new Persona());
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
public String guardarF() {
		
		try {
			Boolean respuesta = usubusines.guardar(newusuario);
			if (respuesta) {
				System.out.println("Ingresado Correcto");
				asignarcurso();
				return "Pasiente?faces-redirect=true";	
			}
				else {
					System.out.println("No Ingresado ya existe o la cedula es incorrecta");
					FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error en la cedula", "Error");
		            facesContext.addMessage("Error al Ingresar", m);
					
					return "";	
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al guardar");
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), "Error");
	        facesContext.addMessage(null, m);
		}
		return null;
}
	
	private List<Usuario> usuario;
	

	public void setNewusuario(Usuario newusuario) {
		this.newusuario = newusuario;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
	public void validar ( String cedula) {
		//System.out.println(v.validadorDeCedula(cedula));
	}
	public UsuarioBussines getUsubusines() {
		return usubusines;
	}
	public void setUsubusines(UsuarioBussines usubusines) {
		this.usubusines = usubusines;
	}
	public Usuario getNewusuario() {
		return newusuario;
	}
	public String eliminar(int codigo) {		
		try {
			usubusines.eliminar(codigo);
			System.out.println("Persona Eliminada");
			return "ListarUsu?faces-redirect=true"; //para q se recarge desde el comienzo  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al Eliminar");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(){
		
		try {
			System.err.println("error en el +++"+newusuario.getCodigo());
			System.err.println("error en el +++"+newusuario.getUsuario());
			usubusines.actualizarDatosUsuario(newusuario);
			System.out.println("Nivel Actualizado");
			return "ListarUsu?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
            facesContext.addMessage(null, m);
		}
		return null;
	}

	
	public String editar(Usuario Usuario) {	
		newusuario = Usuario ;
		return "ListarNiveles";
	}
	public String listarFinal() {
		return "ListarUsu.xhtml";
	}
	
	
	
	/*
	 * metodos del dialog
	 */    
     
	public void asignarcurso() {
		Persona p = new Persona();
		List<Persona> personan= perBussiens.listarPersona(newusuario.getPersona().get(0).getCedula());
		p.setPersonaId(personan.get(0).getPersonaId());
		SuscripcionClienteNivel niv = new SuscripcionClienteNivel();
		Nivel n = new Nivel();
		n.setId(1);
		niv.setNivel(n);
		niv.setPersona(p);
				
		suscripBussines.ingresarSus(niv);
		
		
	}
   
}
