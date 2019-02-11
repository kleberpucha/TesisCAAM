package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.PersonaDao;
import ec.edu.ups.Modelo.Persona;

@Stateless
public class PersonaBussines {
	
	
	@Inject
	private PersonaDao perdao;
	
	/**
	 * Listar las personas por su numero de cedula
	 * @param cedula
	 * @return
	 */
	public List<Persona> listarPersona(String cedula){
		return perdao.listarPersona(cedula);
	}
	
	
	public List<Persona> ListarTodasD(){
		try {
			return perdao.ListarTodas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Persona> listarPersonaIDp(int id ){
		return perdao.listarPersonaID(id);
	}

}
