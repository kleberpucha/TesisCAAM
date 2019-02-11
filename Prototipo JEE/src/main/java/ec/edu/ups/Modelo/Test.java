package ec.edu.ups.Modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import ec.edu.ups.Modelo.Persona;;
@Entity
@Table(name = "Tbl_Test")
public class Test {
	
	/* Enitidad para guardar las preguntas del test
	 * */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testid;
	
	@NotNull(message = "Falta Responder")
	private int pre1;

	@NotNull(message = "Falta Responder")
	private int pre2;

	@NotNull(message = "Falta Responder")
	private int pre3;

	@NotNull(message = "Falta Responder")
	private int pre4;

	@NotNull(message = "Falta Responder")
	private int pre5;

	@NotNull(message = "Falta Responder")
	private int pre6;

	@NotNull(message = "Falta Responder")
	private int pre7;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date FechaN;
	
	@ManyToOne
	@JoinColumn(name="persona_id_fk", referencedColumnName="personaId")
	private Persona persona;

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public int getPre1() {
		return pre1;
	}

	public void setPre1(int pre1) {
		this.pre1 = pre1;
	}

	public int getPre2() {
		return pre2;
	}

	public void setPre2(int pre2) {
		this.pre2 = pre2;
	}

	public int getPre3() {
		return pre3;
	}

	public void setPre3(int pre3) {
		this.pre3 = pre3;
	}

	public int getPre4() {
		return pre4;
	}

	public void setPre4(int pre4) {
		this.pre4 = pre4;
	}

	public int getPre5() {
		return pre5;
	}

	public void setPre5(int pre5) {
		this.pre5 = pre5;
	}

	public int getPre6() {
		return pre6;
	}

	public void setPre6(int pre6) {
		this.pre6 = pre6;
	}

	public int getPre7() {
		return pre7;
	}

	public void setPre7(int pre7) {
		this.pre7 = pre7;
	}

	public Date getFechaN() {
		return FechaN;
	}

	public void setFechaN(Date fechaN) {
		FechaN = fechaN;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
