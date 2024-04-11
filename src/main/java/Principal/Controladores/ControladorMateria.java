package Principal.Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Principal.Entidades.Materia;




public class ControladorMateria extends SuperControlador{
	
	public static String nombreTabla = "centroeducativo.materia";
	
	public static Materia getPrimero(){
		try {
			return getEntidad(ConnectionManager.getConexion(),"select * from "+nombreTabla+" order by id asc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static List<Materia> getTodos() {
		List<Materia> l = new ArrayList<Materia>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + nombreTabla);
			while (rs.next()) {
				Materia o = getEntidadfromMateria(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	private static Materia getEntidadfromMateria(ResultSet rs) throws SQLException {
		Materia o = null;

		o = new Materia();
		o.setId(rs.getInt("id"));
		o.setNombre(rs.getString("nombre"));
		o.setAcronimo(rs.getString("acronimo"));
		o.setCursoId(rs.getInt("curso_id"));
		return o;
	}
	
	public static Materia getUltimo()  {
		
		try {
			return getEntidad(ConnectionManager.getConexion(),"select * from "+nombreTabla+" order by id desc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	public static Materia getSiguienteyAnterior( int id) {
		if(id > getUltimo().getId()) {
            return getPrimero();
        } else 
        	if (id < getPrimero().getId()) {
            return getUltimo();
        }
		try {
			return getEntidad(ConnectionManager.getConexion(),"select * from "+nombreTabla+" where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Materia getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		Materia o = null;
		
		if (rs.next()) {
			o = new Materia();
			o.setId(rs.getInt("id"));
			o.setCursoId(rs.getInt("curso_id"));
			o.setNombre(rs.getString("nombre"));
			o.setAcronimo(rs.getString("acronimo"));
		}
		return o;
	}
	public static int insercion(Connection conn, Materia f) {
		int nuevoid = SuperControlador.maxIdEnTabla("materia");
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into materia (id,nombre,acronimo,curso_id) values(?,?,?,1)");
			ps.setInt(1,nuevoid);
			ps.setString(2, f.getNombre());
			ps.setString(3, f.getAcronimo());
			
			ps.executeUpdate();
			return nuevoid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void modificacion(Connection conn,Materia f) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "update materia set nombre=?,acronimo=?, curso_id=1 where id=?");
			
			ps.setString(1,f.getNombre());
			ps.setString(2, f.getAcronimo());
			
			ps.setInt(3, f.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminacion (int id, Connection conn) {

		try {

			PreparedStatement ps = conn.prepareStatement(""

					+ "delete from materia where id = ?");

			ps.setInt(1, id);

			

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
