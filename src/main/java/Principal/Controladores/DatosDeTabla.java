package Principal.Controladores;

import java.util.List;

import Principal.Entidades.Estudiante;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "DNI", "Direccion", "Email", "Telefono", "IdSexo","Color Preferido","Imagen"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> personas = (List<Estudiante>) ControladorEstudianteJPA.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[personas.size()][11];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < personas.size(); i++) {
			Estudiante persona = personas.get(i);
			datos[i][0] = persona.getId();
			datos[i][1] = persona.getNombre();
			datos[i][2] = persona.getApellido_1();
			datos[i][3] = persona.getApellido_2();
			datos[i][4] = persona.getDNI();
			datos[i][5] = persona.getDireccion();
			datos[i][6] = persona.getEmail();
			datos[i][7] = persona.getTelefono();
			datos[i][8] = persona.getIdSexo();
			datos[i][9] = persona.getColorpreferido();
			datos[i][10] = persona.getImagen();
		}
		
		return datos;
	}
	
	
}
