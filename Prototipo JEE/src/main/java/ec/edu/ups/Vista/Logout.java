package ec.edu.ups.Vista;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
public class Logout {
	/**
	 * para poder salir de la aplicacion.
	 */
	@Inject
	private UsuarioPreferencia usupre;
	
	@Inject
	private FacesContext FacesContext;
	
	@PostConstruct
	public void init() {
		System.out.println(usupre.getUsuario().getCodigo());
		
	}
	
	public String salir() {
		usupre.setUsuario(null);
		redirigir();
		return "index?faces-redirect=true";
	}
	
	public String redirigir() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		try {
			externalContext.redirect("/aCaam/");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
