package ec.edu.ups.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.Modelo.Comentarios;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Temporales.TemporalComentarios;

@Stateless
public class ComentariosDao {

	@Inject
	private EntityManager m;
	
	/**
	 * para realizar un comentario
	 * @param comentario
	 */

	public void insertar(Comentarios comentario) {
		System.out.println("ComentariosDao.insertar()");
		try {

			m.persist(comentario);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * para realizar la actualizacion de un comentario.
	 * @param comentario
	 */
	public void updateF(Comentarios comentario) {
		try {
			m.merge(comentario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Upadate....Dao");
	}
	
	/**
	 * Para ver como se ingresan en la tabla coemntarios 
	 * @return
	 */
	public Comentarios todosCoentariosDao() {

		Persona emisor = new Persona();
		emisor.setPersonaId(1);

		Persona reseptor = new Persona();
		reseptor.setPersonaId(1);

		ObjApre ombj = new ObjApre();
		ombj.setId(1);

		Comentarios comen = new Comentarios();
		comen.setComentario("para pruebas");
		comen.setComentarioid(1);
		comen.setEmisor(emisor);
		comen.setReceptor(reseptor);
		comen.setObjetoApredisaje(ombj);
		comen.setEstado("S");

		return comen;

	}
	
	/**
	 * para relizar un filtrado de las personas q solo tienen un mensaje.
	 * @param reseptor
	 * @return
	 */
	public List<TemporalComentarios> ListarNOcomentarios(Persona reseptor) {
		String stado = "N";
		String jpql = "SELECT t FROM Comentarios t WHERE t.estado=:est AND t.receptor=:per";
		Query query = m.createQuery(jpql, Comentarios.class);
		query.setParameter("per", reseptor);
		query.setParameter("est", stado);
		List<Comentarios> ListaNO = query.getResultList();
		List<TemporalComentarios> temporalComentarios = new ArrayList<>();
		for (int i = 0; i < ListaNO.size(); i++) {
			TemporalComentarios cont = new TemporalComentarios();

			cont.setIdemisor(ListaNO.get(i).getEmisor().getPersonaId());
			cont.setIdreceptor(ListaNO.get(i).getReceptor().getPersonaId());
			cont.setIdComentario(ListaNO.get(i).getComentarioid());

			cont.setHora(ListaNO.get(i).getHora());
			cont.setFecha(ListaNO.get(i).getFechaComentario());

			cont.setComentario(ListaNO.get(i).getComentario());
			cont.setEstado(ListaNO.get(i).getEstado());

			cont.setEmisor(ListaNO.get(i).getEmisor().getNombre() + " " + ListaNO.get(i).getEmisor().getApellido());
			cont.setReseptor(
					ListaNO.get(i).getReceptor().getNombre() + " " + ListaNO.get(i).getReceptor().getApellido());

			cont.setNombreTarea(ListaNO.get(i).getObjetoApredisaje().getTarea());
			cont.setNombreNivel(ListaNO.get(i).getObjetoApredisaje().getNivel().getNombre());
			cont.setIdobjetoApredizaje((ListaNO.get(i).getObjetoApredisaje().getId()));

			System.out.println("i:= " + i);

			temporalComentarios.add(cont);
		}
		return temporalComentarios;

	}

}
