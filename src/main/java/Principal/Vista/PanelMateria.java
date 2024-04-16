package Principal.Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import Principal.Controladores.ConnectionManager;
import Principal.Controladores.ControladorCurso;
import Principal.Controladores.ControladorMateria;
import Principal.Entidades.Curso;
import Principal.Entidades.Materia;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class PanelMateria extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfAcronimo;
	private JTextField jtfNombre;
	private JComboBox<Curso> jcbCurso;
	/**
	 * Create the panel.
	 */
	
	
	
	
	public PanelMateria() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		button.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/gotostart.png")));
		toolBar.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/previous.png")));
		toolBar.add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		button_1.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/next.png")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cargarUltimo();
			}
		});
		button_2.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/gotoend.png")));
		toolBar.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		button_3.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/nuevo.png")));
		toolBar.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		button_4.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/guardar.png")));
		toolBar.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		button_5.setIcon(new ImageIcon(PanelMateria.class.getResource("../res/eliminar.png")));
		toolBar.add(button_5);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Gestion Materia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.weightx = 2.0;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblId = new JLabel("ID: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso: ");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.anchor = GridBagConstraints.EAST;
		gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurso.gridx = 0;
		gbc_lblCurso.gridy = 2;
		panel.add(lblCurso, gbc_lblCurso);
		
		jcbCurso = new JComboBox<Curso> ();
		GridBagConstraints gbc_jcbCurso = new GridBagConstraints();
		gbc_jcbCurso.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCurso.gridx = 1;
		gbc_jcbCurso.gridy = 2;
		panel.add(jcbCurso, gbc_jcbCurso);
		cargarTodoscursos();
		
		JLabel lblAcronimo = new JLabel("Acronimo: ");
		GridBagConstraints gbc_lblAcronimo = new GridBagConstraints();
		gbc_lblAcronimo.anchor = GridBagConstraints.EAST;
		gbc_lblAcronimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcronimo.gridx = 0;
		gbc_lblAcronimo.gridy = 3;
		panel.add(lblAcronimo, gbc_lblAcronimo);
		
		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.anchor = GridBagConstraints.NORTH;
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 1;
		gbc_jtfAcronimo.gridy = 3;
		panel.add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 0, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 4;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 4;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

	}

	private void cargarPrimero() {
		Materia o = ControladorMateria.getPrimero();
		muestraenPantalla(o);
	}
	
	private void cargarUltimo() {
		Materia o = ControladorMateria.getUltimo();
		muestraenPantalla(o);
	}
	
	
	private void cargarTodoscursos() {
		List <Curso> l = ControladorCurso.getTodos();
		for (Curso o: l) {
			jcbCurso.addItem(o);
		}
	}
	private void muestraenPantalla(Materia o) {
		if(o!= null) {
			this.jtfId.setText(""+o.getId());
			for (int i = 0; i < jcbCurso.getItemCount(); i++) {
				if(jcbCurso.getItemAt(i).getId()==o.getCursoId()) {
				jcbCurso.setSelectedIndex(i);
				}
			}
			jtfAcronimo.setText(o.getAcronimo());
			jtfNombre.setText(o.getNombre());
		}
	}
private void cargarAnterior() {
		
		Materia o = ControladorMateria.getSiguienteyAnterior(Integer.parseInt(jtfId.getText())-1);
		muestraenPantalla(o);
	}
private void cargarSiguiente() {
		
		Materia o = ControladorMateria.getSiguienteyAnterior(Integer.parseInt(jtfId.getText())+1);
		muestraenPantalla(o);
	}
private void nuevo() {
	this.jtfId.setText("");
	this.jtfAcronimo.setText("");
	this.jtfNombre.setText("");
}

private void guardar() {
	try {

		Materia f = new Materia();
		f.setId(-1);
		if (!this.jtfId.getText().trim().equals("")) {
			f.setId(Integer.parseInt(this.jtfId.getText()));
		}

		f.setAcronimo(this.jtfAcronimo.getText());
		f.setNombre(this.jtfNombre.getText());
		
		

		// Se decide a ver si guardar o insertar

		Connection conn = ConnectionManager.getConexion();
		if (f.getId() == -1) {
			int nuevoid = ControladorMateria.insercion(conn, f);
			jtfId.setText("" + nuevoid);
		} else
			ControladorMateria.modificacion(conn, f);

	} catch (Exception ex) {
		// TODO: handle exception
		ex.printStackTrace();
	}

}

private void eliminar() {

	try {

		String respuestas[] = new String[] { "Sí", "No" };

		int opcionElegida = JOptionPane.showOptionDialog(
				null,
				"¿Realmente desea eliminar el registro?",

				"Eliminación de curso",

				JOptionPane.DEFAULT_OPTION,

				JOptionPane.WARNING_MESSAGE,

				null, respuestas,

				respuestas[1]);

		if (opcionElegida == 0) {

			if (!this.jtfId.getText().trim().equals("")) {

				int id = Integer.parseInt(this.jtfId.getText());
				Connection conn = ConnectionManager.getConexion();
				ControladorMateria.eliminacion(id, ConnectionManager.getConexion());
				Materia fabriAMostrar = ControladorMateria.getSiguienteyAnterior((id-1));
				if(fabriAMostrar!=null) {
					muestraenPantalla(fabriAMostrar);
				}else {
					fabriAMostrar = ControladorMateria.getSiguienteyAnterior( (id-1));
					if(fabriAMostrar!=null) {
						 muestraenPantalla(fabriAMostrar);
					}
					else {
						nuevo();
					}
				}
			}
		}
	}
	catch (Exception ex) {
		ex.printStackTrace();
	}
}
}
