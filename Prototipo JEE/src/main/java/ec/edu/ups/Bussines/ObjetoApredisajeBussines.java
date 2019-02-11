package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.ObjetoApredidizajeDao;
import ec.edu.ups.Modelo.Nivel;
import ec.edu.ups.Modelo.ObjApre;
import ec.edu.ups.Modelo.Persona;

@Stateless
public class ObjetoApredisajeBussines {

	@Inject
	private ObjetoApredidizajeDao obaDaos;

	public List<ObjApre> ListarobjetosTodos() {
		return obaDaos.ObjetoApredisajetodos();
	}

	public boolean insertarObjeto(ObjApre obj) throws Exception {

		ObjApre aux = obaDaos.leer(obj.getId());
		if (aux != null)
			throw new Exception("Persona ya existe");
		else
			obaDaos.insertar(obj);

		return true;

	}

	public List<ObjApre> listarCruce(Persona p, Nivel l) {

		return obaDaos.ObjetoApredisajeCruce(p, l);

	}

	public List<ObjApre> liestarcontresparametros(Persona p, Nivel l, String tarea) {
		return obaDaos.ObjApredisajetresParametros(p, l, tarea);
	}

	public ObjApre ejeploejeplo() {
		return obaDaos.ejeplojson();
		
	}
}
