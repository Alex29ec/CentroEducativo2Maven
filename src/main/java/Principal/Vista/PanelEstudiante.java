package Principal.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Principal.Controladores.ConnectionManager;
import Principal.Controladores.ControladorEstudiante;
import Principal.Entidades.Estudiante;


public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private panelDatosPersonales panelDatos = new panelDatosPersonales();

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
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
					borrar(Integer.parseInt(panelDatos.getJtfId().getText()), ConnectionManager.getConexion());
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
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiante.getPrimero();
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarUltimo() {
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiante.getUltimo();
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarSiguiente() {
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiante.getSiguienteyAnterior(panelDatos.getId() + 1);
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarAnterior() {
		Estudiante mockEstudiante = new Estudiante();
		mockEstudiante = ControladorEstudiante.getSiguienteyAnterior(panelDatos.getId() - 1);
		mostrarEntidad(mockEstudiante);
	}

	private void mostrarEntidad(Estudiante e) {

		this.panelDatos.getJtfId().setText(String.valueOf(e.getId()));
		this.panelDatos.getJtfnombre().setText(e.getNombre());
		this.panelDatos.getJtf1apellido().setText(e.getApellido_1());
		this.panelDatos.getJtf2apellido().setText(e.getApellido_2());
		this.panelDatos.getJtfdni().setText(e.getDNI());
		this.panelDatos.getJtfdireccion().setText(e.getDireccion());
		this.panelDatos.getJtfemail().setText(e.getEmail());
		this.panelDatos.getJtftelefono().setText(e.getTelefono());
		this.panelDatos.setImagen(e.getImagen());
		for (int i = 0; i < this.panelDatos.getJcbSexo().getItemCount(); i++) {
			if (this.panelDatos.getJcbSexo().getItemAt(i).getId() == e.getIdSexo()) {
				this.panelDatos.getJcbSexo().setSelectedIndex(i);
			}
		}
		this.panelDatos.setColor(e.getColorpreferido());
		setBackground();
	}

	private void guardar() {

		try {

			Estudiante o = new Estudiante();

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

				int nuevoId = ControladorEstudiante.insercion(conn, o);

				this.panelDatos.getJtfId().setText("" + nuevoId);

				JOptionPane.showMessageDialog(null, "Registro nuevo guardado con éxito");

			}

			else {

				ControladorEstudiante.modificacion(conn, o);

				JOptionPane.showMessageDialog(null, "Registro modificado con éxito");

			}

		} catch (Exception e) {

			// TODO: handle exception
			System.out.println(e);

		}

	}

	public static void borrar(int id, Connection conn) {

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
