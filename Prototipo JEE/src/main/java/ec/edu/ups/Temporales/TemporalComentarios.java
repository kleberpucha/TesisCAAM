package ec.edu.ups.Temporales;

import java.util.Date;

public class TemporalComentarios {
	
	//Esta tabla nos sirve para mostrar los datos que nos interesan de los comentarios
	
	private int idemisor;
	private int idreceptor;
	private int idComentario;
	private int idobjetoApredizaje;

	
	private Date hora;
	private Date Fecha;
	
	private String comentario;
	private String estado;
	
	private String emisor;
	private String Reseptor;
	
	private String nombreTarea;
	private String nombreNivel;
	
	

	public String getNombreTarea() {
		return nombreTarea;
	}
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}
	public String getNombreNivel() {
		return nombreNivel;
	}
	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}
	public void setIdemisor(int idemisor) {
		this.idemisor = idemisor;
	}
	public int getIdreceptor() {
		return idreceptor;
	}
	public void setIdreceptor(int idreceptor) {
		this.idreceptor = idreceptor;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
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
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getReseptor() {
		return Reseptor;
	}
	public void setReseptor(String reseptor) {
		Reseptor = reseptor;
	}
	public int getIdemisor() {
		return idemisor;
	}
	public int getIdobjetoApredizaje() {
		return idobjetoApredizaje;
	}
	public void setIdobjetoApredizaje(int idobjetoApredizaje) {
		this.idobjetoApredizaje = idobjetoApredizaje;
	}
	
	

}
