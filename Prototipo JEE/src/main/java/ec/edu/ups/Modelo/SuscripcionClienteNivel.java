package ec.edu.ups.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.*;

@Entity
@Table(name="tbl_suscripcion")
public class SuscripcionClienteNivel {
	/* Cada usuario puede estar suscrito a uno a mas niveles para poder 
	 * realizar lso talleres.
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int susid;
	
	@ManyToOne
	@JoinColumn(name="peridFk", referencedColumnName="personaId")
	@JsonIgnore
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="nividFk", referencedColumnName="nivel_id")
	@JsonIgnore
	private Nivel nivel;

	public int getSusid() {
		return susid;
	}

	public void setSusid(int susid) {
		this.susid = susid;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
	

}
