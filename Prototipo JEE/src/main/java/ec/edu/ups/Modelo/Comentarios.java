package ec.edu.ups.Modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Comentarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comentarioid;
	
	@NotNull
	private String comentario;
	
	@NotNull
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="emisorFk", referencedColumnName="personaId")
	@JsonIgnore
	private Persona emisor;
	
	@ManyToOne
	@JoinColumn(name="recptorFk", referencedColumnName="personaId")
	@JsonIgnore
	private Persona receptor;
	
	@ManyToOne
	@JoinColumn(name="objApredi", referencedColumnName="id")
	@JsonIgnore
	private ObjApre objetoApredisaje;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaComentario = Calendar.getInstance().getTime();
	
	@NotNull
	@Temporal(TemporalType.TIME)
	private Date hora = Calendar.getInstance().getTime();

	public int getComentarioid() {
		return comentarioid;
	}

	public void setComentarioid(int comentarioid) {
		this.comentarioid = comentarioid;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Persona getEmisor() {
		return emisor;
	}

	public void setEmisor(Persona emisor) {
		this.emisor = emisor;
	}

	public Persona getReceptor() {
		return receptor;
	}

	public void setReceptor(Persona receptor) {
		this.receptor = receptor;
	}

	public ObjApre getObjetoApredisaje() {
		return objetoApredisaje;
	}

	public void setObjetoApredisaje(ObjApre objetoApredisaje) {
		this.objetoApredisaje = objetoApredisaje;
	}

	public Date getFechaComentario() {
		return fechaComentario;
	}

	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	
}
