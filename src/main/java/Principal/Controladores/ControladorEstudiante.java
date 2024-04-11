package Principal.Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Principal.Entidades.Estudiante;



public class ControladorEstudiante {

	private static String nombreTabla = "centroeducativo.estudiante";
	
	public static Estudiante getPrimero(){
		try {
			return getEntidad(ConnectionManager.getConexion(),"select * from "+nombreTabla+" order by id asc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Estudiante getUltimo()  {
		
		try {
			return getEntidad(ConnectionManager.getConexion(),"select * from "+nombreTabla+" order by id desc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	public static Estudiante getSiguienteyAnterior( int id) {
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
	
	public static Estudiante getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		Estudiante o = null;
		if (rs.next()) {
			o = new Estudiante();
			o.setId(rs.getInt("id"));
			o.setApellido_1(rs.getString("apellido1"));
			o.setApellido_2(rs.getString("apellido2"));
			o.setNombre(rs.getString("nombre"));
			o.setDNI(rs.getString("dni"));
			o.setDireccion(rs.getString("direccion"));
			o.setEmail(rs.getString("email"));
			o.setTelefono(rs.getString("telefono"));
			o.setIdSexo(rs.getInt("sexo_id"));
			o.setImagen(rs.getBytes("imagen"));
			o.setColorpreferido(rs.getString("colorFavorito"));
		}
		return o;
	}
	
	public static List<Estudiante> getTodos() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + nombreTabla);
			while (rs.next()) {
				Estudiante o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}

	private static Estudiante getEntidadfromCurso(ResultSet rs) throws SQLException {
		Estudiante o = null;

		o = new Estudiante();
		o.setId(rs.getInt("id"));
		o.setApellido_1(rs.getString("apellido1"));
		o.setApellido_2(rs.getString("apellido2"));
		o.setNombre(rs.getString("nombre"));
		o.setDNI(rs.getString("dni"));
		o.setDireccion(rs.getString("email"));
		o.setTelefono(rs.getString("telefono"));
		o.setIdSexo(rs.getInt("sexo_id"));
		o.setColorpreferido(rs.getString("colorFavorito"));

		return o;
	}
	
	public static int insercion(Connection conn, Estudiante f) {
		int nuevoid = SuperControlador.maxIdEnTabla("estudiante");
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "insert into estudiante values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,nuevoid);
			ps.setString(2, f.getNombre());  
			ps.setString(3, f.getApellido_1());
			ps.setString(4, f.getApellido_2());
			ps.setString(5, f.getDireccion());
			ps.setString(6, f.getDNI());
			ps.setString(7, f.getEmail());
			ps.setString(8, f.getTelefono());
			ps.setInt(9, f.getIdSexo());
			ps.setBytes(10, f.getImagen());
			ps.setString(11,f.getColorpreferido());
			ps.executeUpdate();
			return nuevoid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void modificacion(Connection conn,Estudiante f) {
		try {
			PreparedStatement ps = conn.prepareStatement(""
					+ "update estudiante set nombre=?,apellido1=?,apellido2=?,dni=?,direccion=?,email=?,telefono=?, sexo_id=?, imagen=?,colorFavorito=? where id=?");
			
			ps.setString(1,f.getNombre());
			ps.setString(2,f.getApellido_1());
			ps.setString(3,f.getApellido_2());
			ps.setString(4,f.getDNI());
			ps.setString(5,f.getDireccion());
			ps.setString(6,f.getEmail());
			ps.setString(7,f.getTelefono());
			ps.setInt(8,f.getIdSexo());
			ps.setBytes(9,f.getImagen());
			ps.setString(10, f.getColorpreferido());
			ps.setInt(11, f.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminacion (int id, Connection conn) {

		try {

			PreparedStatement ps = conn.prepareStatement(""

					+ "delete from estudiante where id = ?");

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
