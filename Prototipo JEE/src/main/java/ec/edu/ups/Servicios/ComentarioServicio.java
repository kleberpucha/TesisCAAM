package ec.edu.ups.Servicios;

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

import ec.edu.ups.Bussines.ComentariosBussines;
import ec.edu.ups.Modelo.Comentarios;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Temporales.TemporalComentarios;

@Path("/ComentarioServicio")
public class ComentarioServicio {

	@Inject
	private ComentariosBussines comentBusines;
	
	/**
	 * Recive el id para poder ver los comentarios no leidos
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/comentariosNo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TemporalComentarios> NoComentario(@QueryParam("ID") int id) {
		return comentBusines.ListadoNocomentarios(id);
	}

	@GET
	@Path("/comentariosTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public Comentarios comentarioFinal() {
		return comentBusines.todosCoentariosAplicacion();
	}
	/**
	 * Este webservices nos sirve para inserar nuevos comentarios
	 * @param comen
	 * @return
	 */
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Comentarios comen) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			System.out.println("Paso por aqui");
			comentBusines.updateAplicacion(comen);
			data.put("code", "1");
			data.put("message", "OK");
			builder = Response.status(Response.Status.OK).entity(data);
			System.out.println("Paso por aqui_______");

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
