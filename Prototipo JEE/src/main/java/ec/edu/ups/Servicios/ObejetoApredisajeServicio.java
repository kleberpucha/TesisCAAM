package ec.edu.ups.Servicios;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.Bussines.ObjetoApredisajeBussines;
import ec.edu.ups.Modelo.ObjApre;

@Path("/ObjetoApredizaje")
public class ObejetoApredisajeServicio {
	
	@Inject
	private ObjetoApredisajeBussines objABuusines;
	/**
	 * web seervice para ingresar obejtos de aprendizaje
	 * @param obj
	 * @return
	 */
	@POST
	@Path("/insertarO")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(ObjApre obj) {	
		Response.ResponseBuilder builder =  null;
		Map<String, String> data = new HashMap<>();
		try {
			System.out.println("Paso por aqui" );
			objABuusines.insertarObjeto(obj);
			data.put("code", "1");
			data.put("message", "OK");
			builder = Response.status(Response.Status.OK).entity(data);
			System.out.println("Paso por aqui_______" );
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();	
	}

}
