package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.TestDao;
import ec.edu.ups.Modelo.Test;

@Stateless
public class TestBussines {

	@Inject
	private TestDao testdao;
	
	/**
	 * para ingresar una test y estar seguros para ver si no tienenn un id 
	 * en caso contrario seri
	 * @param test
	 */
	public void save(Test test) {
		Test aux = testdao.read(test.getTestid());

		if (aux != null) {

		} else {

			testdao.insertartest(test);
			System.out.println("Se inserto");
		}
	}

	public List<Test> listar() {
		return testdao.listaTest();
	}
	
	public void eliminar(int id) throws Exception {

		Test aux = testdao.read(id);

		if (aux == null) {

			throw new Exception("Persona no existe *****");

		} else {
			testdao.eliminar(id);

		}
	}
	/**
	 * Para extraer ciertos test para poder sacar el reporte
	 * @param id
	 * @return
	 */
	public List<Test> ListarTodasPersonasTestID(int id){
		return testdao.ListarTodasPersonasTestPorID(id);
	}

}
