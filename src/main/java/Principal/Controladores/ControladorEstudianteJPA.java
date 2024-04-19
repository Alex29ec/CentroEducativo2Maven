package Principal.Controladores;

import Principal.Entidades.Estudiante;

public class ControladorEstudianteJPA extends SuperControladorJPA{
	
	private static ControladorEstudianteJPA instance = null;
	
	public ControladorEstudianteJPA() {
		super("estudiante",Estudiante.class);
	}
	
	public static ControladorEstudianteJPA getInstance() {
		if(instance == null ) {
			instance = new ControladorEstudianteJPA()
;		}
		return instance;
	}
	public Estudiante obtenerEstudiantePorId(int idEstudiante) {
        return  (Estudiante) getEntityManager().createNativeQuery("SELECT * FROM estudiante where id = " + idEstudiante, Estudiante.class).getSingleResult();

    }
	
}
