package ec.edu.ups.Modelo;

import java.util.Calendar;
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

@Entity
@Table(name="tbl_objetoApredizaje")
public class ObjApre {
	
	/*En esta entidad se guardan todas las tareas  que 
	 * se realizan en la aplicacion movil.
	 *  */
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String tarea;
	@NotNull
	private String observacoiones;
	@NotNull
	private int resultado;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaTaller = Calendar.getInstance().getTime();
	
	@ManyToOne
	@JoinColumn(name="persona_id_fk", referencedColumnName="personaId")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="nivel_id_fk", referencedColumnName="nivel_id")
	private Nivel nivel ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getObservacoiones() {
		return observacoiones;
	}

	public void setObservacoiones(String observacoiones) {
		this.observacoiones = observacoiones;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	public Date getFechaTaller() {
		return fechaTaller;
	}

	public void setFechaTaller(Date fechaTaller) {
		this.fechaTaller = fechaTaller;
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
