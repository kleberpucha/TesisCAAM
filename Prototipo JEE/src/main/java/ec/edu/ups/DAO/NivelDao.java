package ec.edu.ups.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Nivel;
@Stateless
public class NivelDao {
	
	@Inject
	private EntityManager m;
	
	public List<Nivel> listarNivelCedula(String nombre ){
		String jpql = "SELECT t FROM Nivel t WHERE t.nombre=:cedula";
		Query query = m.createQuery(jpql,Nivel.class);
		query.setParameter("cedula", nombre);
		List<Nivel> nivel = query.getResultList();
		for (Nivel nivel2 : nivel) {
			System.out.println(nivel2.getId());
		}
		return nivel;	
	}
	
	public List<Nivel> listarNivel(){
		String jpql = "SELECT t FROM Nivel t";
		Query query = m.createQuery(jpql,Nivel.class);
		List<Nivel> nivel = query.getResultList();
		for (Nivel nivel2 : nivel) {
			System.out.println(nivel2.getId());
		}
		return nivel;	
	}

}
