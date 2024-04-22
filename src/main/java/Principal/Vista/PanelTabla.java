package Principal.Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Principal.Controladores.ControladorEstudianteJPA;
import Principal.Controladores.DatosDeTabla;
import Principal.Entidades.Estudiante;

public class PanelTabla extends JPanel {

	public Object[][] getDatosEnTabla() {
		return datosEnTabla;
	}

	public void setDatosEnTabla(Object[][] datosEnTabla) {
		this.datosEnTabla = datosEnTabla;
	}


	private DefaultTableModel dtm = null;
	private Object datosEnTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosEnTabla[] = DatosDeTabla.getTitulosColumnas();

	private static final long serialVersionUID = 1L;
	private JTable table_1;
	
	private static PanelTabla instance = null;


	public static PanelTabla getInstance() {
		if(instance == null ) {
			instance = new PanelTabla()
;		}
		return instance;
	}
	
	public PanelTabla() {
		setLayout(new BorderLayout(0, 0));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		this.dtm = getDefaultTableModelNoEditable();
		table_1 = new JTable(dtm);

		JScrollPane scrollpane=new JScrollPane(table_1);
		splitPane.setLeftComponent(scrollpane);
		
		
				
			
				table_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						int indiceFilaSel = table_1.getSelectedRow();		
						Object value = datosEnTabla[indiceFilaSel][0];
						Estudiante estselecc = ControladorEstudianteJPA.getInstance().obtenerEstudiantePorId((Integer)value);
						PanelEstudiante2 panelestudiante2 = new PanelEstudiante2(estselecc);
						JScrollPane scrollpane2 = new JScrollPane(panelestudiante2);
						splitPane.setRightComponent(scrollpane2);
						splitPane.setResizeWeight(0.25);
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
