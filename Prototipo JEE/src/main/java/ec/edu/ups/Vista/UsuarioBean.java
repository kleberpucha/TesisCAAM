package ec.edu.ups.Vista;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.Bussines.UsuarioBussines;
import ec.edu.ups.Modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	
	private List<Usuario> listausu;
	public String nombreusuario;
	public String password;
	public Usuario newUsuario;
	
	
	
	public UsuarioPreferencia getUprefre() {
		return uprefre;
	}
	public void setUprefre(UsuarioPreferencia uprefre) {
		this.uprefre = uprefre;
	}
	public List<Usuario> getListausu() {
		return listausu;
	}
	public void setListausu(List<Usuario> listausu) {
		this.listausu = listausu;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private UsuarioBussines busaurio;
	
	@Inject
	private UsuarioPreferencia uprefre;


	@PostConstruct
	public void init() {
		
		Usuario u = uprefre.getUsuario();
		
		if (u == null) {
		
			System.out.println("Se encuentra logeado");
			
		} else {
			
		redirigir();	

		}
		
		
	}
	
	public String redirigir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/aCaam/faces/Pasiente.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String logeosexist() {
		
		return "Loggin?faces-redirect=true";
		
	}
	
	/**
	 * metodo para realizar el ingreso madiante un loggin
	 * @return
	 */
	public String loggin() {
		
		try {
			if(nombreusuario!=null && password!=null) {
				System.out.println("LogginEntrada");
				this.listausu=busaurio.compararLoggin(nombreusuario, password);
				
				if(listausu.size()>0) {
					
					System.out.println("lista++++++++" +listausu);
					idpersona = (listausu.get(0).getCodigo());
					nombreUs= (listausu.get(0).getUsuario());
					uprefre.setUsuario(listausu.get(0));
					if (listausu.get(0).getPersona().get(0).getTipo() == 2) {
						uprefre.setUsuario(null);
						RedirigirUsuario();
						
					} else {
						
						return "Pasiente?faces-redirect=true";
					}
					
					
				}else {
					return"Terapista?faces-redirect=true";		
				}			
			}
		}catch (Exception e) {
				System.out.println("error");
		}
		return "";
	}
	
	public String RedirigirUsuario() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("http://35.247.151.29:8100");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int idpersona;
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}
	
	public String nombreUs;



	public String getNombreUs() {
		return nombreUs;
	}
	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}
	
	
	public void verdatos() {
		
		System.out.println(listausu.get(0));
		
		
	}
	
	public void actualizar() {
		try {
			
			busaurio.actualizarU(newUsuario);
			System.out.println("Exitaso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public Usuario getNewUsuario() {
		return newUsuario;
	}
	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}	
	
		
		
}
