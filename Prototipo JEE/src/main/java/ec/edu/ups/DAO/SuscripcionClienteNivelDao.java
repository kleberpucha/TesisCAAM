package ec.edu.ups.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.ResumenCliente;
import ec.edu.ups.Modelo.SuscripcionClienteNivel;
import ec.edu.ups.Temporales.CruceNivelPersona;

@Stateless
public class SuscripcionClienteNivelDao {
	
	@Inject
	private EntityManager m;
	
	public void ingresar(SuscripcionClienteNivel sus) {
		m.persist(sus);
	}
	
	/**
	 * Para podre listar a las personas que se encuentran suscritas en un nivel
	 * @param codigo
	 * @return
	 */
	
	public List<CruceNivelPersona> listarNivelCedula(int codigo){
		Persona p = new Persona();
		p.setPersonaId(codigo);
		String jpql = "SELECT t FROM SuscripcionClienteNivel t WHERE t.persona=:persona";
		Query query = m.createQuery(jpql,SuscripcionClienteNivel.class);
		query.setParameter("persona", p);
		List<SuscripcionClienteNivel> listartodos  = query.getResultList();
		List<CruceNivelPersona> temporal = new ArrayList<>();
		/**
		 * Se crea esta tabla terporal con el fin de un cruce de tablas y evitar el error lazy
		 */
		for (int i = 0; i < listartodos.size(); i++) {
			CruceNivelPersona cr = new CruceNivelPersona();
			cr.setIdNivel(listartodos.get(i).getNivel().getId());
			cr.setIdPersona(listartodos.get(i).getPersona().getPersonaId());
			cr.setNombreTipo(listartodos.get(i).getNivel().getTipo());
			cr.setNombrenivel(listartodos.get(i).getNivel().getNombre());
			cr.setIdsuscripcion(listartodos.get(i).getSusid());
			cr.setNombrePersona(listartodos.get(i).getPersona().getNombre()+""+listartodos.get(i).getPersona().getApellido());
			temporal.add(cr);
			
		}
		
		return temporal;	
	}

}
