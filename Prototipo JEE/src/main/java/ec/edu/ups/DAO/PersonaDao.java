package ec.edu.ups.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Test;

@Stateless
public class PersonaDao {

	@Inject
	private EntityManager m;
	
	/**
	 * Para listar las personas por su cedula
	 * @param cedula
	 * @return
	 */
	public List<Persona> listarPersona(String cedula ){
		String jpql = "SELECT t FROM Persona t WHERE t.cedula=:cedula";
		Query query = m.createQuery(jpql,Persona.class);
		query.setParameter("cedula", cedula);
		List<Persona> persona = query.getResultList();
		for (Persona persona2 : persona) {
			//System.out.println(persona2.getApellido());
		}
		return persona;	
	}
	/**
	 * para realizar un listado de todas las personas
	 * @return
	 */
	
	public List<Persona> ListarTodas(){
		int dos =2;
		String jpql = "SELECT t FROM Persona t WHERE t.tipo=:dos";
		Query query = m.createQuery(jpql,Persona.class);
		query.setParameter("dos", dos);
		List<Persona> persona = query.getResultList();
		for (Persona persona2 : persona) {
			System.out.println(persona2.getApellido());
		}
		return persona;	
	}
	
	public List<Persona> listarPersonaID(int id ){
		String jpql = "SELECT t FROM Persona t WHERE t.personaId=:idp";
		Query query = m.createQuery(jpql,Persona.class);
		query.setParameter("idp", id);
		List<Persona> persona = query.getResultList();
		for (Persona persona2 : persona) {
			///datos de persona
		}
		return persona;	
	}
	
	
}
