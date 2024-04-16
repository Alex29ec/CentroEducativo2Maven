package Principal;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import Principal.Vista.Menu;
import Principal.Vista.PanelCurso;
import Principal.Vista.PanelEstudiante;
import Principal.Vista.PanelMateria;
import Principal.Vista.PanelNotaJPA;
import Principal.Vista.PanelProfesor;
import Principal.Vista.PanelValoracionMateria;


public class Principal extends JFrame{
	
	static Principal instance = null;
	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	JTabbedPane panelTabbed;
	
	public Principal() {
		
		super("Gestion de centro educativo");
		this.setBounds(0,0,800,600);
		
		
		panelTabbed = new JTabbedPane();
		PanelCurso panelcurso = new PanelCurso();
		PanelMateria panelmateria = new PanelMateria();
		PanelEstudiante panelestudiante = new PanelEstudiante();
		PanelProfesor panelprofesor = new PanelProfesor();
		PanelValoracionMateria panelvaloracion = new PanelValoracionMateria();
		PanelNotaJPA panelNota = new PanelNotaJPA();
		Menu menu = new Menu();
		
		panelTabbed.addTab("Cursos", panelcurso);
		panelTabbed.addTab("Materias", panelmateria);
		panelTabbed.addTab("Estudiante", panelestudiante);
		panelTabbed.addTab("Profesor", panelprofesor);
		panelTabbed.addTab("Valoracion", panelvaloracion);
		panelTabbed.add("Nota",panelNota);
		

		this.setJMenuBar(menu);
		panelTabbed.setSelectedIndex(0);
		
		this.getContentPane().add(panelTabbed);
		}
	public JTabbedPane getPanelTabbed() {
		return panelTabbed;
	}
	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}
}
