package Principal.Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import Principal.Controladores.ConnectionManager;
import Principal.Controladores.ControladorCurso;
import Principal.Entidades.Curso;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class PanelCurso extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfdescripcion;

	/**
	 * Create the panel.
	 */
	public PanelCurso() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});

		
		btnPrimero.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAntes = new JButton("");
		btnAntes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cargarAnterior();
			}
		});
		btnAntes.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/previous.png")));
		toolBar.add(btnAntes);
		
		JButton btnDespues = new JButton("");
		btnDespues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnDespues.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/next.png")));
		toolBar.add(btnDespues);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
				
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		button.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/nuevo.png")));
		toolBar.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		button_1.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/guardar.png")));
		toolBar.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			eliminar();
			}
		});
		button_2.setIcon(new ImageIcon(PanelCurso.class.getResource("../res/eliminar.png")));
		toolBar.add(button_2);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{164, 122, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblGestionDeCurso = new JLabel("Gestion de Curso");
		GridBagConstraints gbc_lblGestionDeCurso = new GridBagConstraints();
		gbc_lblGestionDeCurso.gridwidth = 2;
		gbc_lblGestionDeCurso.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeCurso.gridx = 0;
		gbc_lblGestionDeCurso.gridy = 0;
		panel.add(lblGestionDeCurso, gbc_lblGestionDeCurso);
		
		JLabel lblId = new JLabel("Id: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 2;
		panel.add(lblDescripcion, gbc_lblDescripcion);
		
		jtfdescripcion = new JTextField();
		GridBagConstraints gbc_jtfdescripcion = new GridBagConstraints();
		gbc_jtfdescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdescripcion.gridx = 1;
		gbc_jtfdescripcion.gridy = 2;
		panel.add(jtfdescripcion, gbc_jtfdescripcion);
		jtfdescripcion.setColumns(10);

	}
	
	private void cargarPrimero() {
		Curso o = ControladorCurso.getPrimero();
		muestraenPantalla(o);
	}
	
	private void cargarUltimo() {
		Curso o = ControladorCurso.getUltimo();
		muestraenPantalla(o);
	}
	
	private void muestraenPantalla(Curso o) {
		this.jtfId.setText(""+o.getId());
		this.jtfdescripcion.setText("" + o.getDescripcion());
	}
	
	private void cargarAnterior() {
		
		Curso o = ControladorCurso.getSiguienteyAnterior(Integer.parseInt(jtfId.getText())-1);
		muestraenPantalla(o);
	}
	private void cargarSiguiente() {
		
		Curso o = ControladorCurso.getSiguienteyAnterior(Integer.parseInt(jtfId.getText())+1);
		muestraenPantalla(o);
	}
	private void nuevo() {
		this.jtfId.setText("");
		this.jtfdescripcion.setText("");
	}
	private void guardar() {
		try {

			Curso f = new Curso();
			f.setId(-1);
			if (!this.jtfId.getText().trim().equals("")) {
				f.setId(Integer.parseInt(this.jtfId.getText()));
			}

			f.setDescripcion(this.jtfdescripcion.getText());
			
			Connection conn = ConnectionManager.getConexion();
			if (f.getId() == -1) {
				int nuevoid = ControladorCurso.insercion(conn, f);
				jtfId.setText("" + nuevoid);
			} else
				ControladorCurso.modificacion(conn, f);

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
					ControladorCurso.eliminacion(id, ConnectionManager.getConexion());
					Curso fabriAMostrar = ControladorCurso.getSiguienteyAnterior((id-1));
					if(fabriAMostrar!=null) {
						muestraenPantalla(fabriAMostrar);
					}else {
						fabriAMostrar = ControladorCurso.getSiguienteyAnterior( (id-1));
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
