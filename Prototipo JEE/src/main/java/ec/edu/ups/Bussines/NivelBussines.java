package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.NivelDao;
import ec.edu.ups.Modelo.Nivel;

@Stateless
public class NivelBussines {
	
	@Inject
	private NivelDao ndao;
	
	/**
	 * Listar los niveles por el nombre
	 * @param nombre
	 * @return
	 */
	public List<Nivel> listarPersona(String nombre ){
		return ndao.listarNivelCedula(nombre);
	}
	
	public List<Nivel> listarPersona(){
		return ndao.listarNivel();
	}

}
