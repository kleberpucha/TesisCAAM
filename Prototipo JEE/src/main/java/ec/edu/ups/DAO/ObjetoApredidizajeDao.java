package ec.edu.ups.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Modelo.Persona;

@Stateless
public class ObjetoApredidizajeDao {
	
	@Inject
	private EntityManager m;
		
	public ObjApre leer(int id) {
		ObjApre objApre = m.find(ObjApre.class, id);
		return objApre;
	}
	
	public void insertar(ObjApre obj) {
		m.persist(obj);		
	}
	
	public List<ObjApre> ObjetoApredisajeCruce(Persona p, Nivel l ) {
		String  jpql = "SELECT n FROM ObjApre n WHERE n.persona=:persona AND n.nivel=:nivel";
		Query query = m.createQuery(jpql, ObjApre.class);
		query.setParameter("persona", p);
		query.setParameter("nivel", l);
		List<ObjApre> listadoObj = query.getResultList();
		for (ObjApre objApre : listadoObj) {
			System.out.println("---" + objApre.getResultado());
			System.out.println(objApre.getPersona().getCedula());
			System.out.println(objApre.getNivel().getNombre());
			
		}			
		return listadoObj;
	}
	public List<ObjApre> ObjetoApredisajetodos() {
		String  jpql = "SELECT n FROM ObjApre n";
		Query query = m.createQuery(jpql, ObjApre.class);
		List<ObjApre> listadoObj = query.getResultList();
		for (ObjApre objApre : listadoObj) {
//			System.out.println(objApre.getResultado());
//			System.out.println(objApre.getPersona().getCedula());
//			System.out.println(objApre.getNivel().getNombre());	
		}			
		return listadoObj;
	}
	
	public List<ObjApre> ObjApredisajetresParametros(Persona p, Nivel l , String tarea) {
		String  jpql = "SELECT n FROM ObjApre n WHERE n.persona=:persona AND n.nivel=:nivel AND n.tarea=:tar";
		Query query = m.createQuery(jpql, ObjApre.class);
		query.setParameter("persona", p);
		query.setParameter("nivel", l);
		query.setParameter("tar", tarea);
		List<ObjApre> listadoObj = query.getResultList();
		for (ObjApre objApre : listadoObj) {
			System.out.println("---" + objApre.getResultado());
			System.out.println(objApre.getPersona().getCedula());
			System.out.println(objApre.getNivel().getNombre());
			
		}			
		return listadoObj;
	}
	
	public ObjApre ejeplojson() {
		Persona  p = new Persona();
		p.setPersonaId(1);
		Nivel n = new Nivel();
		n.setId(1);
		ObjApre a  = new ObjApre();
		a.setResultado(20);
		a.setNivel(n);
		a.setPersona(p);
		a.setTarea("Practica A");
		a.setObservacoiones("Todo esta Bien");
		return a;
				
	}
}
