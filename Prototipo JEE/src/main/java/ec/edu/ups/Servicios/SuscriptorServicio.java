package ec.edu.ups.Servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.Bussines.SuscripcionClienteNivelBussines;
import ec.edu.ups.Modelo.SuscripcionClienteNivel;
import ec.edu.ups.Modelo.Usuario;
import ec.edu.ups.Temporales.CruceNivelPersona;

@Path("/suscripcion")
public class SuscriptorServicio {
	
	@Inject
	private SuscripcionClienteNivelBussines sccBussines;
	
	
	/**
	 * para ver la spersonas que se estan suscritas en un nivel
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/listaSus")
	@Produces("application/json")
	public List<CruceNivelPersona> logginusu(@QueryParam("int") int id) {
		try {
			List<CruceNivelPersona> fnal = sccBussines.ListarCedula(id);
			return fnal;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

}
