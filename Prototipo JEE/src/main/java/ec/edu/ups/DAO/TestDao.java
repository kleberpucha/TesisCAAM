package ec.edu.ups.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Modelo.Test;

@Stateless
public class TestDao {
	
	@Inject
	private EntityManager m;
	
	public void insertartest (Test test) {
		m.persist(test);
	}
	
	public void eliminar(int id) {
		m.remove(read(id));
	}
	
	public Test read(int id) {
		Test aux = m.find(Test.class,id);
		return aux;	
	}
	public List<Test> listaTest(){
		String jpql = "SELECT t FROM Test t";
		Query query = m.createQuery(jpql,Test.class);
		List<Test>lista = query.getResultList();
		for (Test test : lista) {
			System.out.println(test.getFechaN());
			System.out.println(test.getPersona().getNombre());
			
		}
		return lista;	
	}
	
	public List<Test> ListarTodasPersonasTestPorID(int id){
		Persona p = new Persona();
		p.setPersonaId(id);
		String jpql = "SELECT t FROM Test t WHERE t.persona=:idpersona";
		Query query = m.createQuery(jpql,Test.class);
		query.setParameter("idpersona", p);
		List<Test>lista = query.getResultList();
		for (Test test : lista) {
			System.out.println(test.getPersona().getNombre());
		}
		return lista;	
	}

}
