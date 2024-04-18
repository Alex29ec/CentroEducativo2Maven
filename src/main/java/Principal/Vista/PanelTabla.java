package Principal.Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;


	public PanelTabla() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);

	}

}
