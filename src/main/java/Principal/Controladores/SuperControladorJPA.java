package Principal.Controladores;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import Principal.Entidades.Entidad;
import Principal.Entidades.Estudiante;
import Principal.Entidades.Materia;
import Principal.Entidades.Profesor;
import Principal.Entidades.ValoracionMateria;

public class SuperControladorJPA {
	private String nombreTabla = "";
	private Class tipoEntidad;
	private static EntityManager em = null; 
	
	
	public SuperControladorJPA(String nombreTabla,Class tipoEntidad) {
		this.nombreTabla=nombreTabla;
		this.tipoEntidad=tipoEntidad;
	}
	
	
	public static void insert(Estudiante e,Profesor p, Materia m, Integer nota, Date fecha) {
		ValoracionMateria v = new ValoracionMateria();
		v.setIdEstudiante(e.getId());
		v.setIdMateria(m.getId());
		v.set
	}
	public static void update(Entidad e) {
	EntityManager em = getEntityManager();
		em.getTransaction().begin();
			em.merge(e);
		em.getTransaction().commit();
	}
	
	public List<? extends Entidad> findAll() {		
		return (List<Entidad>)getEntityManager().createNativeQuery
				("SELECT * FROM "+ nombreTabla+";", this.tipoEntidad).getResultList();
		
	}
	
	public static ValoracionMateria obtenerValoracion(Estudiante e,Materia m, Profesor p,Integer nota) {
		try {
			return (ValoracionMateria) getEntityManager().createNativeQuery(
	                "SELECT * FROM valoracionmateria where " + e.getId() + " = idEstudiante and " + p.getId()
	                        + " = idProfesor and " + m.getId() + " = idMateria and " + nota + " = valoracion;",
	                ValoracionMateria.class).getSingleResult();
		} catch (NoResultException e2) {
}
return null;		
	}
	
	public static ValoracionMateria obtenerValoracionSinNota(Estudiante e,Materia m, Profesor p) {
		try {
			return (ValoracionMateria) getEntityManager().createNativeQuery(
	                "SELECT * FROM valoracionmateria where " + e.getId() + " = idEstudiante and " + p.getId()
	                        + " = idProfesor and " + m.getId() + " = idMateria ;" ,
	                ValoracionMateria.class).getSingleResult();
		} catch (NoResultException e2) {
}
return null;		
	}
	
	
	protected static EntityManager getEntityManager() {
		if (em == null) {
		em = Persistence.createEntityManagerFactory("CentroEducativo").createEntityManager();
		}
		return em;
		}
}
