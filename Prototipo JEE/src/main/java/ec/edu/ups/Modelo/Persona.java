package ec.edu.ups.Modelo;


import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="Tbl_persona", uniqueConstraints= {@UniqueConstraint(columnNames="cedula")})
public class Persona {
	/*Entidad donde se guardaran los datos de las personas.
	 *  */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personaId;
	
	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "Solo ingresar letras") 
	private String nombre;
	
	@NotNull
	@Pattern(regexp = "[^0-9]*", message = "No debe tener nùmeros") 
	private String apellido;
	
	@NotNull(message = "Error en la cedula")
	private String cedula;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date FechaN;
	
	@NotNull
	@Size(min = 8, max = 12, message = "Error en nuemero de caracteres")
	private String telefono;
	
	@Email(message="Ingrese correctamente el correo")
	private String email;
	
	@NotNull
	private int tipo;
		
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Date getFechaN() {
		return FechaN;
	}
	public void setFechaN(Date fechaN) {
		FechaN = fechaN;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
