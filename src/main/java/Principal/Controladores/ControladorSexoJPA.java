package Principal.Controladores;

import Principal.Entidades.Sexo;

public class ControladorSexoJPA extends SuperControladorJPA {
		
		private static ControladorSexoJPA instance = null;
		
		public ControladorSexoJPA() {
			super("sexo",Sexo.class);
		}
		
		public static ControladorSexoJPA getInstance() {
			if(instance == null ) {
				instance = new ControladorSexoJPA()
	;		}
			return instance;
		}
		
	
}
