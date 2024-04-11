package Principal.Controladores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Principal.Entidades.Sexo;


public class ControladorSexo {

	public static String nombreTabla = "centroeducativo.sexo";
	
	public static List<Sexo> getTodos() {
		List<Sexo> l = new ArrayList<Sexo>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + nombreTabla);
			while (rs.next()) {
				Sexo o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}
	
	private static Sexo getEntidadfromCurso(ResultSet rs) throws SQLException {
		Sexo o = null;

		o = new Sexo();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));

		return o;
	}
	
}
