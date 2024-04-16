package Principal.Vista;

import javax.swing.JPanel;

import Principal.Controladores.ControladorEstudianteJPA;
import Principal.Controladores.ControladorMateria;
import Principal.Controladores.ControladorMateriaJPA;
import Principal.Controladores.ControladorProfesorJPA;
import Principal.Controladores.ControladorValoracionMateria;
import Principal.Controladores.ControladorValoracionMateriaJPA;
import Principal.Controladores.SuperControlador;
import Principal.Controladores.SuperControladorJPA;
import Principal.Entidades.Estudiante;
import Principal.Entidades.Materia;
import Principal.Entidades.Profesor;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PanelNotaJPA extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Integer> jcbNota;
	private JList<Estudiante> listaEstudiantes;
	private JList<Estudiante> listaEstudiantesNoS;
	private DefaultListModel<Estudiante> listaMEstudiantes;
	private DefaultListModel<Estudiante> listaMEstudiantesNoS;
	private JTextField jtfFecha;

	/**
	 * Create the panel.
	 */
	public PanelNotaJPA() {

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 56, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		gbc_jcbMateria.gridwidth = 2;
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
		gbc_jcbProfesor.gridwidth = 2;
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
		gbc_jcbNota.gridwidth = 2;
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);

		JButton btnActualizarEstudiante = new JButton("Boton Actualizar Alumnado");
		btnActualizarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarEstudiantes();
			}
		});
		
		JLabel lblFecha = new JLabel("Fecha: ");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 3;
		panel.add(lblFecha, gbc_lblFecha);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 3;
		panel.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		GridBagConstraints gbc_btnActualizarEstudiante = new GridBagConstraints();
		gbc_btnActualizarEstudiante.anchor = GridBagConstraints.EAST;
		gbc_btnActualizarEstudiante.gridx = 2;
		gbc_btnActualizarEstudiante.gridy = 4;
		panel.add(btnActualizarEstudiante, gbc_btnActualizarEstudiante);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);

		JButton btnGuardarNotaAlumno = new JButton("Guardar Nota Alumno Seleccionados");
		btnGuardarNotaAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel_1.add(btnGuardarNotaAlumno);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 200, 41, 202, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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

		listaEstudiantesNoS = new JList(this.getListaMEstudiantesNoS());
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
		gbl_panel_3.columnWidths = new int[] { 63, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasartodosASeleccionados();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_3.add(button, gbc_button);

		JButton button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarunoASeleccionados();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 1;
		panel_3.add(button_1, gbc_button_1);

		JButton button_2 = new JButton("<");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarunoANOSeleccionados();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 2;
		panel_3.add(button_2, gbc_button_2);

		JButton button_3 = new JButton("<<");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasartodosANOSeleccionados();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 3;
		panel_3.add(button_3, gbc_button_3);

		listaEstudiantes = new JList(this.getListaMEstudiantes());
		GridBagConstraints gbc_listaEstudiantes = new GridBagConstraints();
		gbc_listaEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_listaEstudiantes.gridx = 2;
		gbc_listaEstudiantes.gridy = 1;
		panel_2.add(listaEstudiantes, gbc_listaEstudiantes);

		CargarTodosMateria();
		CargarTodosProfesores();
		CargarNotas();
	}

	public DefaultListModel<Estudiante> getListaMEstudiantes() {
		if (this.listaMEstudiantes == null) {
			this.listaMEstudiantes = new DefaultListModel<Estudiante>();

		}
		return listaMEstudiantes;
	}

	public void setListaMEstudiantes(DefaultListModel<Estudiante> listaMEstudiantes) {
		this.listaMEstudiantes = listaMEstudiantes;
	}

	public DefaultListModel<Estudiante> getListaMEstudiantesNoS() {
		if (this.listaMEstudiantesNoS == null) {
			this.listaMEstudiantesNoS = new DefaultListModel<Estudiante>();
		}
		return listaMEstudiantesNoS;
	}

	public void setListaMEstudiantesNoS(DefaultListModel<Estudiante> listaMEstudiantesNoS) {
		this.listaMEstudiantesNoS = listaMEstudiantesNoS;
	}

	public void CargarTodosMateria() {
		List<Materia> l = (List<Materia>) new ControladorMateriaJPA().getInstance().findAll();
		for (Materia m : l) {
			jcbMateria.addItem(m);
		}
	}

	public void CargarTodosProfesores() {
		List<Profesor> l = (List<Profesor>) new ControladorProfesorJPA().getInstance().findAll();
		for (Profesor m : l) {
			jcbProfesor.addItem(m);
		}
	}
private List<Estudiante> getEstudiantesSeleccionados() {
        
        List<Estudiante> l = new ArrayList<Estudiante>();
        for (int i = 0; i < this.listaMEstudiantes.size(); i++) {
            Estudiante e = this.listaMEstudiantes.get(i);
            l.add(this.listaMEstudiantes.get(i));
        }
        
        return l;
    }
	private void guardar(){
	    

        List<Estudiante> estudiantes = getEstudiantesSeleccionados();
        if (estudiantes != null) {

            for (Estudiante estudiante : estudiantes) {
                
                if (SuperControladorJPA.obtenerValoracionSinNota(estudiante, (Materia)this.jcbMateria.getSelectedItem(), (Profesor)this.jcbProfesor.getSelectedItem()) == null) {
                    
                    ControladorValoracionMateriaJPA.insert(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem(), (Integer)this.jcbNota.getSelectedItem(), jtfFecha);
                }
                else {
                    ControladorValoracionMateriaJPA.update(estudiante, (Profesor)this.jcbProfesor.getSelectedItem(), (Materia)this.jcbMateria.getSelectedItem(), (Integer)this.jcbNota.getSelectedItem(), jtfFecha);;
                }
            }
            
            
        }

        
        
    }

	private void CargarEstudiantes() {
		this.listaMEstudiantes.clear();
		this.listaMEstudiantesNoS.clear();
		List<Estudiante> l = (List<Estudiante>) new ControladorEstudianteJPA().getInstance().findAll();
		for (Estudiante estudiante : l) {
			if (SuperControladorJPA.obtenerValoracion(estudiante, (Materia) this.jcbMateria.getSelectedItem(),
					(Profesor) this.jcbProfesor.getSelectedItem(), (Integer) jcbNota.getSelectedItem()) != null) {
				this.listaMEstudiantes.addElement(estudiante);
			} else {
				this.listaMEstudiantesNoS.addElement(estudiante);
			}
		}
	}

	private void pasartodosASeleccionados() {
		this.listaMEstudiantes.removeAllElements();
		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudianteJPA.getInstance().findAll();
		for (Estudiante estudiante : estudiantes) {
			this.listaMEstudiantes.addElement(estudiante);
		}
		this.listaMEstudiantesNoS.removeAllElements();
	}

	private void pasartodosANOSeleccionados() {
		this.listaMEstudiantesNoS.removeAllElements();

		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudianteJPA.getInstance().findAll();
		for (Estudiante estudiante : estudiantes) {
			this.listaMEstudiantesNoS.addElement(estudiante);
		}
		this.listaMEstudiantes.removeAllElements();
	}
	
	private void pasarunoASeleccionados() {
		Estudiante Eseleccionado = null;
		int seleccionado = listaEstudiantesNoS.getSelectedIndex();
		if(seleccionado != -1) {
			Eseleccionado = listaMEstudiantesNoS.getElementAt(seleccionado);
		}
		listaMEstudiantes.addElement(Eseleccionado);
		listaMEstudiantesNoS.remove(seleccionado);
	}
	private void pasarunoANOSeleccionados() {
		Estudiante Eseleccionado = null;
		int seleccionado = listaEstudiantes.getSelectedIndex();
		if(seleccionado != -1) {
			Eseleccionado = listaMEstudiantes.getElementAt(seleccionado);
		}
		listaMEstudiantesNoS.addElement(Eseleccionado);
		listaMEstudiantes.remove(seleccionado);
	}
		

	public void CargarNotas() {
		jcbNota.addItem(Integer.valueOf(0));
		jcbNota.addItem(Integer.valueOf(1));
		jcbNota.addItem(Integer.valueOf(2));
		jcbNota.addItem(Integer.valueOf(3));
		jcbNota.addItem(Integer.valueOf(4));
		jcbNota.addItem(Integer.valueOf(5));
		jcbNota.addItem(Integer.valueOf(6));
		jcbNota.addItem(Integer.valueOf(7));
		jcbNota.addItem(Integer.valueOf(8));
		jcbNota.addItem(Integer.valueOf(9));
		jcbNota.addItem(Integer.valueOf(10));
	}
}
