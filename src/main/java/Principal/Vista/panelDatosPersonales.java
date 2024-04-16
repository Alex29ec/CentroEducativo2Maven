package Principal.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;

import Principal.Controladores.ControladorSexo;
import Principal.Entidades.Sexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class panelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableMostrarUltimoRegistro;
	private Runnable runnableMostrarSiguienteRegistro;
	private Runnable runnableMostrarAnteriorRegistro;
	private Runnable runnableGuardar;
	private Runnable runnableEliminar;
	private JTextField jtfId;
	private JTextField jtfnombre;
	private JTextField jtf1apellido;
	private JTextField jtf2apellido;
	private JTextField jtfdni;
	private JTextField jtfdireccion;
	private JTextField jtfemail;
	private JTextField jtftelefono;
	private int anchoImagen, altoImagen;
	public JPanel panel;
	private JScrollPane scrollPane;

	private byte[] imagen;
	private static JComboBox<Sexo> jcbSexo;
	private JTextField jtfColor;
	JColorChooser jColorChooser;

	public panelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarPrimerRegistro.run();
			}
		});

		button.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/gotostart.png")));
		toolBar.add(button);

		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarAnteriorRegistro.run();
				;
			}
		});
		button_1.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/previous.png")));
		toolBar.add(button_1);

		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarSiguienteRegistro.run();
			}
		});
		button_2.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/next.png")));
		toolBar.add(button_2);

		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarUltimoRegistro.run();
			}
		});
		button_3.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/gotoend.png")));
		toolBar.add(button_3);

		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();

			}
		});
		button_4.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/nuevo.png")));
		toolBar.add(button_4);

		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGuardar.run();
			}
		});
		button_5.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/guardar.png")));
		toolBar.add(button_5);

		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableEliminar.run();
			}
		});

		button_6.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("../res/eliminar.png")));
		toolBar.add(button_6);

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 150, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblTituloDelComponente = new JLabel("Titulo del componente");
		GridBagConstraints gbc_lblTituloDelComponente = new GridBagConstraints();
		gbc_lblTituloDelComponente.gridwidth = 3;
		gbc_lblTituloDelComponente.insets = new Insets(0, 0, 5, 0);
		gbc_lblTituloDelComponente.gridx = 0;
		gbc_lblTituloDelComponente.gridy = 0;
		panel.add(lblTituloDelComponente, gbc_lblTituloDelComponente);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);

		JPopupMenu popupMenu = getPopUpMenu();

		popupMenu.addMouseListener(new MouseAdapter() {

			@Override

			public void mousePressed(MouseEvent e) {

				showPopup(e);

			}

			@Override

			public void mouseReleased(MouseEvent e) {

				showPopup(e);

			}

			private void showPopup(MouseEvent e) {

				if (e.isPopupTrigger()) {

					popupMenu.show(e.getComponent(), e.getX(), e.getY());

				}

			}

		});
		

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);

		jtfnombre = new JTextField();
		GridBagConstraints gbc_jtfnombre = new GridBagConstraints();
		gbc_jtfnombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfnombre.gridx = 1;
		gbc_jtfnombre.gridy = 2;
		panel.add(jtfnombre, gbc_jtfnombre);
		jtfnombre.setColumns(10);

		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		GridBagConstraints gbc_lblPrimerApellido = new GridBagConstraints();
		gbc_lblPrimerApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerApellido.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerApellido.gridx = 0;
		gbc_lblPrimerApellido.gridy = 3;
		panel.add(lblPrimerApellido, gbc_lblPrimerApellido);

		jtf1apellido = new JTextField();
		GridBagConstraints gbc_jtf1apellido = new GridBagConstraints();
		gbc_jtf1apellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtf1apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf1apellido.gridx = 1;
		gbc_jtf1apellido.gridy = 3;
		panel.add(jtf1apellido, gbc_jtf1apellido);
		jtf1apellido.setColumns(10);

		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 4;
		panel.add(lblSegundoApellido, gbc_lblSegundoApellido);

		jtf2apellido = new JTextField();
		GridBagConstraints gbc_jtf2apellido = new GridBagConstraints();
		gbc_jtf2apellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtf2apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf2apellido.gridx = 1;
		gbc_jtf2apellido.gridy = 4;
		panel.add(jtf2apellido, gbc_jtf2apellido);
		jtf2apellido.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo: ");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 5;
		panel.add(lblSexo, gbc_lblSexo);

		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		panel.add(jcbSexo, gbc_jcbSexo);

		JLabel lblDni = new JLabel("DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 6;
		panel.add(lblDni, gbc_lblDni);

		jtfdni = new JTextField();
		GridBagConstraints gbc_jtfdni = new GridBagConstraints();
		gbc_jtfdni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdni.gridx = 1;
		gbc_jtfdni.gridy = 6;
		panel.add(jtfdni, gbc_jtfdni);
		jtfdni.setColumns(10);

		JButton btnNewButton = new JButton("Seleccionar Imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		panel.add(btnNewButton, gbc_btnNewButton);

		JLabel lblDireccion = new JLabel("Direccion:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 7;
		panel.add(lblDireccion, gbc_lblDireccion);

		jtfdireccion = new JTextField();
		GridBagConstraints gbc_jtfdireccion = new GridBagConstraints();
		gbc_jtfdireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfdireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdireccion.gridx = 1;
		gbc_jtfdireccion.gridy = 7;
		panel.add(jtfdireccion, gbc_jtfdireccion);
		jtfdireccion.setColumns(10);

		JLabel lblEmail = new JLabel("Email: ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 8;
		panel.add(lblEmail, gbc_lblEmail);

		jtfemail = new JTextField();
		GridBagConstraints gbc_jtfemail = new GridBagConstraints();
		gbc_jtfemail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfemail.gridx = 1;
		gbc_jtfemail.gridy = 8;
		panel.add(jtfemail, gbc_jtfemail);
		jtfemail.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 9;
		panel.add(lblTelefono, gbc_lblTelefono);

		jtftelefono = new JTextField();
		GridBagConstraints gbc_jtftelefono = new GridBagConstraints();
		gbc_jtftelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtftelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtftelefono.gridx = 1;
		gbc_jtftelefono.gridy = 9;
		panel.add(jtftelefono, gbc_jtftelefono);
		jtftelefono.setColumns(10);

		JLabel lblNewLabel = new JLabel("Color preferido: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 10;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 10;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		JButton btnSeleccionarColor = new JButton("Cambiar color");
		btnSeleccionarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnSeleccionarColor = new GridBagConstraints();
		gbc_btnSeleccionarColor.gridx = 2;
		gbc_btnSeleccionarColor.gridy = 10;
		panel.add(btnSeleccionarColor, gbc_btnSeleccionarColor);

		cargarTodosSexo();
	}

	private JPopupMenu getPopUpMenu() {

		JPopupMenu menu = new JPopupMenu();

		JMenuItem item1 = new JMenuItem(

				"La dimensión de la imagen es " + this.anchoImagen + "x" + this.altoImagen + " pixeles");

		JMenuItem item2 = new JMenuItem("Cambiar Imagen");

		menu.add(item1);

		menu.add(item2);

		item2.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				seleccionaImagen();

			}

		});

		return menu;

	}

	public void setColor(String str) {
		this.getJtfColor().setText(str);
	}

	public String getColor() {
		return (this.getJtfColor().getText());
	}

	/**
	 * 
	 * @param newTitulo
	 */
	public void setTitulo(String newTitulo) {
		this.lblTitulo.setText(newTitulo);
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.getJtfId().setText("" + id);
	}

	public int getId() {
		return Integer.parseInt(this.getJtfId().getText());
	}

	public Runnable getRunnableGuardar() {
		return runnableGuardar;
	}

	public void setRunnableGuardar(Runnable runnableGuardar) {
		this.runnableGuardar = runnableGuardar;
	}

	public Runnable getRunnableEliminar() {
		return runnableEliminar;
	}

	public void setRunnableEliminar(Runnable runnableEliminar) {
		this.runnableEliminar = runnableEliminar;
	}

	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}

	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}

	public Runnable getRunnableMostrarUltimoRegistro() {
		return runnableMostrarUltimoRegistro;
	}

	public void setRunnableMostrarUltimoRegistro(Runnable runnableMostrarUltimoRegistro) {
		this.runnableMostrarUltimoRegistro = runnableMostrarUltimoRegistro;
	}

	public Runnable getRunnableMostrarSiguienteRegistro() {
		return runnableMostrarSiguienteRegistro;
	}

	public void setRunnableMostrarSiguienteRegistro(Runnable runnableMostrarSiguienteRegistro) {
		this.runnableMostrarSiguienteRegistro = runnableMostrarSiguienteRegistro;
	}

	public Runnable getRunnableMostrarAnteriorRegistro() {
		return runnableMostrarAnteriorRegistro;
	}

	public void setRunnableMostrarAnteriorRegistro(Runnable runnableMostrarAnteriorRegistro) {
		this.runnableMostrarAnteriorRegistro = runnableMostrarAnteriorRegistro;
	}

	public static void cargarTodosSexo() {
		List<Sexo> l = ControladorSexo.getTodos();
		for (Sexo o : l) {
			jcbSexo.addItem(o);
		}
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfColor() {
		return jtfColor;
	}

	public void setJtfColor(JTextField jtfColor) {
		this.jtfColor = jtfColor;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public JTextComponent getJtfNombre() {
		return jtfnombre;
	}

	public static JComboBox<Sexo> getJcbSexo() {
		return jcbSexo;
	}

	public static void setJcbSexo(JComboBox<Sexo> jcbSexo) {
		panelDatosPersonales.jcbSexo = jcbSexo;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JTextField getJtfnombre() {
		return jtfnombre;
	}

	public void setJtfnombre(JTextField jtfnombre) {
		this.jtfnombre = jtfnombre;
	}

	public JTextField getJtf1apellido() {
		return jtf1apellido;
	}

	public void setJtf1apellido(JTextField jtf1apellido) {
		this.jtf1apellido = jtf1apellido;
	}

	public JTextField getJtf2apellido() {
		return jtf2apellido;
	}

	public void setJtf2apellido(JTextField jtf2apellido) {
		this.jtf2apellido = jtf2apellido;
	}

	public JTextField getJtfdni() {
		return jtfdni;
	}

	public void setJtfdni(JTextField jtfdni) {
		this.jtfdni = jtfdni;
	}

	public JTextField getJtfdireccion() {
		return jtfdireccion;
	}

	public void setJtfdireccion(JTextField jtfdireccion) {
		this.jtfdireccion = jtfdireccion;
	}

	public JTextField getJtfemail() {
		return jtfemail;
	}

	public void setJtfemail(JTextField jtfemail) {
		this.jtfemail = jtfemail;
	}

	public JTextField getJtftelefono() {
		return jtftelefono;
	}

	public void setJtftelefono(JTextField jtftelefono) {
		this.jtftelefono = jtftelefono;
	}

	public int getSexo() {
		Sexo o;

		o = (Sexo) this.jcbSexo.getSelectedItem();

		return o.getId();

	}

	private void nuevo() {

		jtfId.setText("");

		jtfnombre.setText("");

		jtfdni.setText("");

		jtf1apellido.setText("");

		jtf2apellido.setText("");

		jtfdireccion.setText("");

		jtftelefono.setText("");

		jtfemail.setText("");

		jcbSexo.setSelectedItem(null);

		jtfColor.setText("");

	}

	private void seleccionaImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() && (f.getAbsolutePath().toLowerCase().endsWith(".jpg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".jpeg")
						|| f.getAbsolutePath().toLowerCase().endsWith(".png")
						|| f.getAbsolutePath().toLowerCase().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					this.imagen = Files.readAllBytes(fichero.toPath());
					mostrarImagen();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] img) {

		if (img != null && img.length > 0) {

			this.imagen = img;

			ImageIcon icono = new ImageIcon(this.imagen);

			this.anchoImagen = icono.getIconWidth();

			this.altoImagen = icono.getIconHeight();

		} else {

			this.imagen = null;

			JLabel lblicono = new JLabel("Sin Icono");

			this.scrollPane.setViewportView(lblicono);

			this.anchoImagen = 0;

			this.altoImagen = 0;
		}

		mostrarImagen();

	}
	private static void addPopup(Component component, final JPopupMenu popup) {

		component.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {

				if (e.isPopupTrigger()) {

					showMenu(e);

				}

			}


			public void mouseReleased(MouseEvent e) {

				if (e.isPopupTrigger()) {

					showMenu(e);

				}

			}


			private void showMenu(MouseEvent e) {

				popup.show(e.getComponent(), e.getX(), e.getY());

			}

		});

	}

	private void mostrarImagen() {
		if (imagen != null && imagen.length > 0) {
			ImageIcon icono = new ImageIcon(imagen);
			JLabel lblIcono = new JLabel(icono);
			this.scrollPane.setViewportView(lblIcono);
		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}

	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.panel.setBackground(color);
		}
	}
}
