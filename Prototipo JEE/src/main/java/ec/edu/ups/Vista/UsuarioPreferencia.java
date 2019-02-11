package ec.edu.ups.Vista;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.Modelo.Usuario;

@Named
@SessionScoped
public class UsuarioPreferencia  implements Serializable{
	
	/**
	 * Este clase se crea para que sea seccion 
	 * para que pueda estar utlizando en aplicacion
	 * para y evitar que otra persona pueda ingresar al link
	 */
	
	private  Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
