package Principal.Vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Principal.Controladores.ConnectionManager;
import Principal.Controladores.ControladorProfesor;
import Principal.Entidades.Profesor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PanelProfesor extends JPanel {

	private static final long serialVersionUID = 1L;
	private panelDatosPersonales panelDatos = new panelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelProfesor() {
		setLayout(new BorderLayout(0, 0));
		panelDatos.getJtfId().setEnabled(false);
		this.add(panelDatos, BorderLayout.CENTER);

		
		
		this.panelDatos.setRunnableGuardar(new Runnable() {
			@Override
			public void run() {
				guardar();
			}
		});
		
		this.panelDatos.setRunnableEliminar(new Runnable() {
			@Override
			public void run() {
				try {
					borrar(Integer.parseInt(panelDatos.getJtfId().getText()),ConnectionManager.getConexion());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		this.panelDatos.setRunnableMostrarPrimerRegistro(new Runnable() {
			@Override
			public void run() {
				mostrarPrimero();
			}
		});

		this.panelDatos.setRunnableMostrarUltimoRegistro(new Runnable() {
			@Override
			public void run() {
				mostrarUltimo();
			}
		});
		this.panelDatos.setRunnableMostrarAnteriorRegistro(new Runnable() {
			@Override
			public void run() {
				mostrarAnterior();
			}
		});
		this.panelDatos.setRunnableMostrarSiguienteRegistro(new Runnable() {
			@Override
			public void run() {
				mostrarSiguiente();
			}
		});
	}

	private void mostrarPrimero() {
		Profesor mockProfesor = new Profesor();
		mostrarEntidad(mockProfesor);
	}

	private void mostrarUltimo() {
		Profesor mockProfesor = new Profesor();
		mockProfesor = ControladorProfesor.getUltimo();
		mostrarEntidad(mockProfesor);
	}

	private void mostrarSiguiente() {
		Profesor mockProfesor = new Profesor();
		mockProfesor = ControladorProfesor.getFabricanteSiguienteAnterior(panelDatos.getId() + 1);
		mostrarEntidad(mockProfesor);
	}

	private void mostrarAnterior() {
		Profesor mockProfesor = new Profesor();
		mockProfesor = ControladorProfesor.getFabricanteSiguienteAnterior(panelDatos.getId() - 1);
		mostrarEntidad(mockProfesor);
	}

private void mostrarEntidad(Profesor e) {
		
        this.panelDatos.getJtfId().setText(String.valueOf(e.getId()));
        this.panelDatos.getJtfnombre().setText(e.getNombre());
        this.panelDatos.getJtf1apellido().setText(e.getApellido_1());
        this.panelDatos.getJtf2apellido().setText(e.getApellido_2());
        this.panelDatos.getJtfdni().setText(e.getDNI());
        this.panelDatos.getJtfdireccion().setText(e.getDireccion());
        this.panelDatos.getJtfemail().setText(e.getEmail());
        this.panelDatos.getJtftelefono().setText(e.getTelefono());
        this.panelDatos.getJcbSexo().setSelectedIndex(e.getIdSexo()-1);
        this.panelDatos.setImagen(e.getImagen());
        
        for (int i = 0; i < this.panelDatos.getJcbSexo().getItemCount(); i++) {
            if (this.panelDatos.getJcbSexo().getItemAt(i).getId() == e.getIdSexo()) {
            this.panelDatos.getJcbSexo().setSelectedIndex(i);
            }
            }
        this.panelDatos.getJtfColor().setText(e.getColorpreferido());
        
		setBackground();
    
	}

	private void guardar() {

		try {

			Profesor o = new Profesor();

			o.setId(-1);

			if (!this.panelDatos.getJtfId().getText().trim().equals("")) {

				o.setId(Integer.parseInt(this.panelDatos.getJtfId().getText()));

			}
			
			o.setNombre(this.panelDatos.getJtfNombre().getText());

			o.setDNI(this.panelDatos.getJtfdni().getText());

			o.setApellido_1(this.panelDatos.getJtf1apellido().getText());

			o.setApellido_2(this.panelDatos.getJtf2apellido().getText());

			o.setDireccion(this.panelDatos.getJtfdireccion().getText());

			o.setEmail(this.panelDatos.getJtfemail().getText());

			o.setTelefono(this.panelDatos.getJtftelefono().getText());

			o.setIdSexo(this.panelDatos.getSexo());

			o.setImagen(this.panelDatos.getImagen());
			

			o.setColorpreferido(this.panelDatos.getColor());
			

			Connection conn = ConnectionManager.getConexion();

			if (o.getId() == -1) {

				int nuevoId = ControladorProfesor.insercion(o, conn);

				this.panelDatos.getJtfId().setText("" + nuevoId);

				JOptionPane.showMessageDialog(null, "Registro nuevo guardado con éxito");

			}

			else {

				ControladorProfesor.modificacion(o, conn);

				JOptionPane.showMessageDialog(null, "Registro modificado con éxito");

			}

		} catch (Exception e) {

			// TODO: handle exception

		}

	}

	

	

	

	public static void borrar (int id, Connection conn) {

		try {

			PreparedStatement ps = conn.prepareStatement(""

					+ "delete from profesor where id = ?");

			ps.setInt(1, id);

			

			ps.executeUpdate();

			

			JOptionPane.showMessageDialog(null, "Registro borrado con éxtito");

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
	private void setBackground() {
        if (!this.panelDatos.getJtfColor().getText().isBlank()) {
            Color color = Color.decode(this.panelDatos.getJtfColor().getText());
            this.panelDatos.panel.setBackground(color);
        } else {
            this.panelDatos.panel.setBackground(Color.WHITE);
        }
    }

}