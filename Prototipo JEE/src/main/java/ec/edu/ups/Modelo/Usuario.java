package ec.edu.ups.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Tbl_Usuario", uniqueConstraints = { @UniqueConstraint(columnNames = "usuario") })
public class Usuario {
	
	/* Entidad para el usuario el cual va a tener el la contraseña
	 * el usuario
	 * */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@NotNull
	private String usuario;
	@NotNull
	private String contrasenia;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_fk_id")
	private List<Persona> persona;

	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

	public void addPersona(Persona persona) {
		if (this.persona == null) {
			this.persona = new ArrayList<>();
			this.persona.add(persona);
		}
	}

}
