package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.ComentariosDao;
import ec.edu.ups.Modelo.Comentarios;
import ec.edu.ups.Modelo.Persona;
import ec.edu.ups.Temporales.TemporalComentarios;

@Stateless
public class ComentariosBussines {

	@Inject
	private ComentariosDao cmDao;
	
	/**
	 * Para insertar un comentario 
	 * @param comentario
	 */
	public void inserta(Comentarios comentario) {
		try {
			
			cmDao.insertar(comentario);
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	public void update (Comentarios comentario) {
		
		cmDao.updateF(comentario);
	}
	
	public void updateAplicacion (Comentarios comentario) {
		
		cmDao.updateF(comentario);
	}
	
	/**
	 * LIsta temporal con datos de varias tablas 
	 * de los comentarios
	 * @param idPersona
	 * @return
	 */
	public List<TemporalComentarios> ListadoNocomentarios(int idPersona){
		Persona p = new Persona();
		System.out.println("paso no comarios");
		p.setPersonaId(idPersona);
		System.out.println("PasoNoBussines");
		return cmDao.ListarNOcomentarios(p);
	}
	
	public Comentarios todosCoentariosAplicacion(){
		return cmDao.todosCoentariosDao();
		
	}
	
}
