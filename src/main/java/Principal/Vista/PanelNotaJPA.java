package Principal.Vista;

import javax.swing.JPanel;

import Principal.Entidades.Estudiante;
import Principal.Entidades.Materia;
import Principal.Entidades.Profesor;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelNotaJPA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox <Materia>jcbMateria;
	private JComboBox <Profesor>jcbProfesor;
	private JComboBox<Integer> jcbNota;
	private JList<Estudiante> listaEstudiantes;
	private JList<Estudiante> listaEstudiantesNoS;
	
	/**
	 * Create the panel.
	 */
	public PanelNotaJPA() {
		
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMateria = new JLabel("Materia: ");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);
		
		 jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblProfesor = new JLabel("Profesor: ");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.anchor = GridBagConstraints.EAST;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNota = new JLabel("Nota: ");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.anchor = GridBagConstraints.EAST;
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);
		
		jcbNota = new JComboBox<Integer>();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);
		
		JButton btnActualizarEstudiante = new JButton("Boton Actualizar Alumnado");
		GridBagConstraints gbc_btnActualizarEstudiante = new GridBagConstraints();
		gbc_btnActualizarEstudiante.anchor = GridBagConstraints.EAST;
		gbc_btnActualizarEstudiante.gridx = 1;
		gbc_btnActualizarEstudiante.gridy = 3;
		panel.add(btnActualizarEstudiante, gbc_btnActualizarEstudiante);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnGuardarNotaAlumno = new JButton("Guardar Nota Alumno Seleccionados");
		panel_1.add(btnGuardarNotaAlumno);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{200, 41, 202, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblAlumnosNoSelecccionados = new JLabel("Alumnos No Selecccionados");
		GridBagConstraints gbc_lblAlumnosNoSelecccionados = new GridBagConstraints();
		gbc_lblAlumnosNoSelecccionados.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlumnosNoSelecccionados.gridx = 0;
		gbc_lblAlumnosNoSelecccionados.gridy = 0;
		panel_2.add(lblAlumnosNoSelecccionados, gbc_lblAlumnosNoSelecccionados);
		
		JLabel lblAlumnosSeleccionados = new JLabel("Alumnos Seleccionados");
		GridBagConstraints gbc_lblAlumnosSeleccionados = new GridBagConstraints();
		gbc_lblAlumnosSeleccionados.insets = new Insets(0, 0, 5, 0);
		gbc_lblAlumnosSeleccionados.gridx = 2;
		gbc_lblAlumnosSeleccionados.gridy = 0;
		panel_2.add(lblAlumnosSeleccionados, gbc_lblAlumnosSeleccionados);
		
		JList listaEstudiantesNoS = new JList<Estudiante>();
		GridBagConstraints gbc_listaEstudiantesNoS = new GridBagConstraints();
		gbc_listaEstudiantesNoS.insets = new Insets(0, 0, 0, 5);
		gbc_listaEstudiantesNoS.fill = GridBagConstraints.BOTH;
		gbc_listaEstudiantesNoS.gridx = 0;
		gbc_listaEstudiantesNoS.gridy = 1;
		panel_2.add(listaEstudiantesNoS, gbc_listaEstudiantesNoS);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.weighty = 1.0;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{63, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton button = new JButton("<<");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_3.add(button, gbc_button);
		
		JButton button_1 = new JButton("<");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_3.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton(">");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_3.add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton(">>");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		panel_3.add(button_3, gbc_button_3);
		
		
		listaEstudiantes = new JList<Estudiante>();
		GridBagConstraints gbc_listaEstudiantes = new GridBagConstraints();
		gbc_listaEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_listaEstudiantes.gridx = 2;
		gbc_listaEstudiantes.gridy = 1;
		panel_2.add(listaEstudiantes, gbc_listaEstudiantes);

	}
	

}
