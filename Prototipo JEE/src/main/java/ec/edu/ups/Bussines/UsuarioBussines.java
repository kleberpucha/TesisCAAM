package ec.edu.ups.Bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.DAO.UsuarioDAO;
import ec.edu.ups.Modelo.ResumenCliente;
import ec.edu.ups.Modelo.Usuario;

@Stateless
public class UsuarioBussines {

	@Inject
	private UsuarioDAO udao;
	
	/**
	 * Para relizar el login para ingresar a la pagina o aplicacion web
	 * @param un
	 * @param pass
	 * @return lista de usaurio 
	 */
	public List<Usuario> compararLoggin(String un, String pass) {
		return udao.listadosocioLog(un, pass);
	}
	
	/**
	 * Para realizar el ingreso del el cliente en la aplicacion 
	 * para no exponer todos los datos
	 * @param un
	 * @param pass
	 * @return
	 */
	public List<ResumenCliente> aplicacionLoggin(String un, String pass) {
		return udao.logginaplicacion(un, pass);
	}

	/**
	 * Ingresa el usuario con las contraseñas.
	 * @param usuario
	 * @return
	 */
	public boolean guardar(Usuario usuario) {
		Usuario aux = udao.read(usuario.getCodigo());
		if (aux != null) {
			return false;
		} else {
			if (validadorDeCedula(usuario.getPersona().get(0).getCedula())) {
				udao.insert(usuario);
				return true;
			} else
				return false;
		}

	}

	public List<Usuario> getListadoUsuario() {
		return udao.getUsuariotoal();
	}

	public void actualizarU(Usuario usuario) {
		udao.update(usuario);
	}

	public List<Usuario> getListaFiltrada(int id) {
		return udao.getUsuarioFiltrado(id);
	}
	/**
	 * Parametro para eliminar
	 * @param codigo
	 * @throws Exception
	 */

	public void eliminar(int codigo) throws Exception {

		Usuario aux = udao.read(codigo);
		if (aux == null) {
			throw new Exception("Persona no existe");

		} else {
			udao.eliminar(codigo);
		}

	}
	
	/* Para del parametro para actualizar los datos;
	 * @param usuario
	 * 
	 * */
	
	public void actualizarDatosUsuario(Usuario usuario) throws Exception {

		Usuario aux = udao.read((usuario.getCodigo()));

		if (aux == null) {
			throw new Exception("Nivel no existe");
		} else {

			udao.actulizarDatos(usuario);

		}

	}

	/**
	 * Este es el metodo para validar cedula
	 * 
	 * @param cedula
	 * @return ture
	 */
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}
}
