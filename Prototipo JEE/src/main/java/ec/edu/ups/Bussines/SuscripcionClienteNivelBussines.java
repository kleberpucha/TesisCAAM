package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.SuscripcionClienteNivelDao;
import ec.edu.ups.Modelo.SuscripcionClienteNivel;
import ec.edu.ups.Temporales.CruceNivelPersona;

@Stateless
public class SuscripcionClienteNivelBussines {
	
	@Inject
	private SuscripcionClienteNivelDao scdoa;
	
	/**
	 * Se ingresa el codigo 
	 * @param codigo
	 * @return
	 * una tabla temporal con el cruce de personas con nivel
	 */
	public List<CruceNivelPersona> ListarCedula(int codigo){
			
		List<CruceNivelPersona> fin = scdoa.listarNivelCedula(codigo);
		fin.size();
		return fin;	
	}
	
	public void ingresarSus(SuscripcionClienteNivel sus) {
		scdoa.ingresar(sus);
	}
	
}
