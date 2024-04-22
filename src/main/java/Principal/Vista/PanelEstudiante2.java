package Principal.Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import Principal.Controladores.ControladorEstudianteJPA;
import Principal.Controladores.ControladorSexoJPA;
import Principal.Controladores.DatosDeTabla;
import Principal.Entidades.Estudiante;
import Principal.Entidades.Sexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEstudiante2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfNombre;
	private JTextField jtf1Apellido;
	private JTextField jtf2Apellido;
	private JTextField jtfDNI;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JTextField jtfColor;
	JComboBox <Sexo>jcbSexo;
	private JScrollPane jspImagen;
	private byte[] imagen ; 

	public PanelEstudiante2(Estudiante es) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblEstudiantes = new JLabel("Estudiantes:");
		GridBagConstraints gbc_lblEstudiantes = new GridBagConstraints();
		gbc_lblEstudiantes.gridwidth = 2;
		gbc_lblEstudiantes.insets = new Insets(0, 0, 5, 0);
		gbc_lblEstudiantes.gridx = 0;
		gbc_lblEstudiantes.gridy = 0;
		panel.add(lblEstudiantes, gbc_lblEstudiantes);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField(es.getNombre());
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("1 apellido:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		panel.add(lblApellido, gbc_lblApellido);
		
		jtf1Apellido = new JTextField(es.getApellido_1());
		GridBagConstraints gbc_jtf1Apellido = new GridBagConstraints();
		gbc_jtf1Apellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtf1Apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf1Apellido.gridx = 1;
		gbc_jtf1Apellido.gridy = 2;
		panel.add(jtf1Apellido, gbc_jtf1Apellido);
		jtf1Apellido.setColumns(10);
		
		JLabel lblApellido_1 = new JLabel("2 apellido:");
		GridBagConstraints gbc_lblApellido_1 = new GridBagConstraints();
		gbc_lblApellido_1.anchor = GridBagConstraints.EAST;
		gbc_lblApellido_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido_1.gridx = 0;
		gbc_lblApellido_1.gridy = 3;
		panel.add(lblApellido_1, gbc_lblApellido_1);
		
		jtf2Apellido = new JTextField(es.getApellido_2());
		GridBagConstraints gbc_jtf2Apellido = new GridBagConstraints();
		gbc_jtf2Apellido.insets = new Insets(0, 0, 5, 0);
		gbc_jtf2Apellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf2Apellido.gridx = 1;
		gbc_jtf2Apellido.gridy = 3;
		panel.add(jtf2Apellido, gbc_jtf2Apellido);
		jtf2Apellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		panel.add(lblDni, gbc_lblDni);
		
		jtfDNI = new JTextField(es.getDNI());
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 4;
		panel.add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 5;
		panel.add(lblDireccion, gbc_lblDireccion);
		
		jtfDireccion = new JTextField(es.getDireccion());
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 5;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		panel.add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField(es.getEmail());
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 7;
		panel.add(lblTelefono, gbc_lblTelefono);
		
		jtfTelefono = new JTextField(es.getTelefono());
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblIdsexo = new JLabel("Idsexo: ");
		GridBagConstraints gbc_lblIdsexo = new GridBagConstraints();
		gbc_lblIdsexo.anchor = GridBagConstraints.EAST;
		gbc_lblIdsexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdsexo.gridx = 0;
		gbc_lblIdsexo.gridy = 8;
		panel.add(lblIdsexo, gbc_lblIdsexo);
		
		jcbSexo = new JComboBox<Sexo>();
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 8;
		panel.add(jcbSexo, gbc_jcbSexo);
		
		JLabel lblColorPreferido = new JLabel("Color Preferido");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 9;
		panel.add(lblColorPreferido, gbc_lblColorPreferido);
		
		jtfColor = new JTextField(es.getColorpreferido());
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 0);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		JLabel lblImagen = new JLabel("Imagen:");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.anchor = GridBagConstraints.EAST;
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 0;
		gbc_lblImagen.gridy = 10;
		panel.add(lblImagen, gbc_lblImagen);
		
		jspImagen = new JScrollPane();
		GridBagConstraints gbc_jspImagen = new GridBagConstraints();
		gbc_jspImagen.gridheight = 2;
		gbc_jspImagen.insets = new Insets(0, 0, 5, 0);
		gbc_jspImagen.fill = GridBagConstraints.BOTH;
		gbc_jspImagen.gridx = 1;
		gbc_jspImagen.gridy = 10;
		panel.add(jspImagen, gbc_jspImagen);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar(es);
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 12;
		panel.add(btnGuardar, gbc_btnGuardar);

		Color color = Color.decode(es.getColorpreferido());
		this.setBackground(color);
		cargarTodosSexos();
		seleccionarSexo(es.getIdSexo());
		setImagen(imagen, es);
	}
	
	private void cargarTodosSexos() {
        List<Sexo> l = (List<Sexo>) new ControladorSexoJPA().getInstance().findAll();
        for (Sexo o : l) {
            this.jcbSexo.addItem(o);
        }

    }

    public void seleccionarSexo(int idSexo) {
        for (int i = 0; i < this.jcbSexo.getItemCount(); i++) {
            if (this.jcbSexo.getItemAt(i).getId() == idSexo) {
                this.jcbSexo.setSelectedIndex(i);
            }
        }
    }
    
    public void setImagen(byte[] img, Estudiante e) {

        if (img == null) {
//            System.out.println("Se recibe la imagen bien");
            JLabel lblicono = new JLabel("Sin Icono");
            this.jspImagen.setViewportView(lblicono);
        }
        mostrarImagen(e);
        }
    private int setSexoId() {
    	Sexo o = (Sexo)jcbSexo.getSelectedItem();
    	return o.getId();
    }
    
    private void guardar(Estudiante e) {
    	e.setNombre(jtfNombre.getText()); 
    	e.setApellido_1(jtf1Apellido.getText()); 
    	e.setApellido_2(jtf2Apellido.getText()); 
    	e.setDNI(jtfDNI.getText()); 
    	e.setDireccion(jtfDireccion.getText()); 
    	e.setEmail(jtfEmail.getText()); 
    	e.setTelefono(jtfTelefono.getText()); 
    	e.setColorpreferido(jtfColor.getText());
    	e.setIdSexo(setSexoId());
    	
    	PanelTabla.getInstance().setDatosEnTabla(DatosDeTabla.getDatosDeTabla());
    	
    	ControladorEstudianteJPA.getInstance().update(e);
    	JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
    	
    }
    
    
    private void mostrarImagen(Estudiante e) {
        if (e.getImagen()!= null && e.getImagen().length > 0) {
//            System.out.println(e.getImagen());
            ImageIcon icono = new ImageIcon(e.getImagen());
            
            JLabel lblIcono = new JLabel(icono);
            this.jspImagen.setViewportView(lblIcono);
//            System.out.println("Se intenta cagar la imagen bien");
        } else {
            JLabel lblIcono = new JLabel("Sin imagen");
            this.jspImagen.setViewportView(lblIcono);
        }
        
        this.revalidate();
         this.repaint();
    }
}
