package ec.edu.ups.Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Comentarios.class)
public abstract class Comentarios_ {

	public static volatile SingularAttribute<Comentarios, String> estado;
	public static volatile SingularAttribute<Comentarios, Persona> receptor;
	public static volatile SingularAttribute<Comentarios, Date> fechaComentario;
	public static volatile SingularAttribute<Comentarios, Date> hora;
	public static volatile SingularAttribute<Comentarios, ObjApre> objetoApredisaje;
	public static volatile SingularAttribute<Comentarios, String> comentario;
	public static volatile SingularAttribute<Comentarios, Integer> comentarioid;
	public static volatile SingularAttribute<Comentarios, Persona> emisor;

}

