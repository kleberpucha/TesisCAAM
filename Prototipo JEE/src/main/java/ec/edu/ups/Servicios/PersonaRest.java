package ec.edu.ups.Servicios;


import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.Bussines.PersonaBussines;
import ec.edu.ups.Bussines.UsuarioBussines;
import ec.edu.ups.Modelo.Usuario;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.ResumenCliente;

@Path("/persona")
public class PersonaRest {
	
	@Inject
	private UsuarioBussines ub;
	
	@Inject
	private PersonaBussines perb;
	
	
	/**
	 * para realizar el ingreso se recibe los parametros
	 * @param usu
	 * @param contra
	 * @return
	 * nos devuelve una lista con todos los datos
	 */
	@GET
	@Path("/loggin")
	@Produces("application/json")
	public List<Usuario> logginusu(@QueryParam("usuario") String usu, @QueryParam("contrasena") String contra ) {
		try {
			return ub.compararLoggin(usu, contra);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * par realizar el loggin de la aplicaicion
	 * @param usu
	 * @param contra
	 * @return
	 */
	@GET
	@Path("/logginAplicacion")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ResumenCliente> loggina(@QueryParam("usuario") String usu, @QueryParam("contrasena") String contra ) {
		try {
			return ub.aplicacionLoggin(usu, contra);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	/**
	 * para borrar a una persona
	 * @param id
	 * @return
	 */
	@GET
	@Path("/borrarPersona")
	@Produces("application/json")
	public String borrar(@QueryParam("usuario") String id) {
		try {
			ub.eliminar(Integer.parseInt(id));			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";	
	}
	
	/**
	 * para listar a una persona 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/perId")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> logginusu(@QueryParam("ID") int id ) {
		try {
			return perb.listarPersonaIDp(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	

}
