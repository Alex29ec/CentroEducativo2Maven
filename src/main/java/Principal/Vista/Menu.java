package Principal.Vista;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import Principal.Principal;




public class Menu extends JMenuBar {
	/**
	 * 
	 */
	public Menu () {
		// Menú Archivo de la aplicación
        JMenu menuArchivo = new JMenu("Archivo");
        
        menuArchivo.add(crearNuevoMenuItem("Curso", 0));

        menuArchivo.add(crearNuevoMenuItem("Materia", 1));

        menuArchivo.add(crearNuevoMenuItem("Estudiante",2));

        menuArchivo.add(crearNuevoMenuItem("Profesor", 3));
        this.add(menuArchivo);
      
	}
	
	
	
	/**
	 * Menú Item para salir de la aplicación
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String titulo, int n) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Principal.getInstance().getPanelTabbed().setSelectedIndex(n);
            }
        });
        
        return item;
	}
	
	

}
