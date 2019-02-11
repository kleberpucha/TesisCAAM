package ec.edu.ups.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.ResumenCliente;
import ec.edu.ups.Modelo.Usuario;

@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager m;

	public List<Usuario> listadosocioLog(String un, String pass) {
		System.out.println("loggin");
		String  jpql = "SELECT s FROM Usuario s WHERE s.usuario=:un AND s.contrasenia=:pass";
		Query query = m.createQuery(jpql, Usuario.class);
		query.setParameter("un", un);
		query.setParameter("pass", pass);
		List<Usuario> listado = query.getResultList();
		for (Usuario usuario : listado) {
			System.out.println(usuario.getContrasenia());
			System.out.println(usuario.getPersona().get(0).getTipo());
			System.out.println(usuario.getPersona().get(0).getPersonaId());
		}
		return listado;
	}
	public Usuario read(int id) {
		Usuario aux = m.find(Usuario.class, id);
		return aux;

	}
	
	public void insert(Usuario usuario) {
		m.persist(usuario);
	}
	
	public List<Usuario> getUsuariotoal(){
		String jpql = "SELECT p FROM Usuario p";
		Query query = m.createQuery(jpql,Usuario.class);
		List<Usuario>lista = query.getResultList();
		return lista;		
	}
	
	public void update (Usuario usuario) {
		m.merge(usuario);
		System.out.println("Upadate....Dao");
		
	}
	
	public List<Usuario> getUsuarioFiltrado(int id){
		String jpql2 = "SELECT p FROM Usuario p WHERE p.codigo=:un";
		Query query2 = m.createQuery(jpql2,Usuario.class);
		query2.setParameter("un", id);
		List<Usuario>listaFiltrado = query2.getResultList();
		return listaFiltrado;		
	}
	
	public void eliminar (int id) {
		m.remove(read(id));
		
	}
	
	public void actulizarDatos(Usuario usuario) {
		m.merge(usuario);
		
		
	}
	
	public List<ResumenCliente> logginaplicacion(String un, String pass) {
		System.out.println("loggin");
		String  jpql = "SELECT s FROM Usuario s WHERE s.usuario=:un AND s.contrasenia=:pass";
		Query query = m.createQuery(jpql, Usuario.class);
		query.setParameter("un", un);
		query.setParameter("pass", pass);
		List<Usuario> listado = query.getResultList();
		List<ResumenCliente> temporal = new ArrayList<>();
		for (Usuario usuario : listado) {
			ResumenCliente nuevo = new ResumenCliente();
			nuevo.setNombretotal(usuario.getPersona().get(0).getNombre()+" "+usuario.getPersona().get(0).getApellido());
			nuevo.setIdPersona(usuario.getPersona().get(0).getPersonaId());
			nuevo.setIdusuario(usuario.getCodigo());
			temporal.add(nuevo);		}
		return temporal;
	}
	

}
