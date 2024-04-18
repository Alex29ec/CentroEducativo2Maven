package Principal.Vista;

import javax.swing.JButton;
import javax.swing.JPanel;


import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import Principal.Controladores.DatosDeTabla;

public class PanelTabla extends JPanel {

	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();

	private static final long serialVersionUID = 1L;
	private JTable table;


	public PanelTabla() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		splitPane.setLeftComponent(dtm);

		// Inicializo el DefaultTableModel
				this.dtm = getDefaultTableModelNoEditable();
				// Creo la tabla con el DefaultTableModel del método más abajo
				JTable jTable = new JTable(dtm);
				
				// Demostración de como acceder al clic del ratón sobre la tabla y sobrescribir un valor en la misma
				jTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						int indiceFilaSel = jTable.getSelectedRow();

					}
				});
	}
	
	
	private DefaultTableModel getDefaultTableModelNoEditable () {
		DefaultTableModel dtm = new DefaultTableModel(datosEnTabla, titulosEnTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column != 1) {
					return false;
				}
				return true;
			}
		};
		return dtm;
	}
	
}
