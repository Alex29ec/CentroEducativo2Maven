package Principal.Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Principal.Entidades.Curso;


public class ControladorCurso extends SuperControlador {

	public static String nombreTabla = "centroeducativo.curso";

	public static List<Curso> getTodos() {
		List<Curso> l = new ArrayList<Curso>();
		try {
			ResultSet rs = ConnectionManager.getConexion().createStatement()
					.executeQuery("select * from " + nombreTabla);
			while (rs.next()) {
				Curso o = getEntidadfromCurso(rs);
				l.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	private static Curso getEntidadfromCurso(ResultSet rs) throws SQLException {
		Curso o = null;

		o = new Curso();
		o.setId(rs.getInt("id"));
		o.setDescripcion(rs.getString("descripcion"));

		return o;
	}

	public static Curso getPrimero() {
		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id asc limit 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Curso getUltimo() {

		try {
			return getEntidad(ConnectionManager.getConexion(),
					"select * from " + nombreTabla + " order by id desc limit 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Curso getSiguienteyAnterior(int id) {
		if (id > getUltimo().getId()) {
			return getPrimero();
		} else if (id < getPrimero().getId()) {
			return getUltimo();
		}
		try {
			return getEntidad(ConnectionManager.getConexion(), "select * from " + nombreTabla + " where id=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Curso getEntidad(Connection conn, String sql) throws SQLException {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery(sql);
		Curso o = null;

		if (rs.next()) {
			o = new Curso();
			o.setId(rs.getInt("id"));
			o.setDescripcion(rs.getString("descripcion"));
		}
		return o;
	}

	public static int insercion(Connection conn, Curso f) {
		int nuevoid = SuperControlador.maxIdEnTabla("curso");
		try {
			PreparedStatement ps = conn.prepareStatement("" + "insert into curso (id,descripcion) values(?,?)");
			ps.setInt(1, nuevoid);
			ps.setString(2, f.getDescripcion());

			ps.executeUpdate();
			return nuevoid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public static void modificacion(Connection conn, Curso f) {
		try {
			PreparedStatement ps = conn.prepareStatement("" + "update curso set descripcion=? where id=?");
			ps.setInt(2, f.getId());
			ps.setString(1, f.getDescripcion());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminacion(int id, Connection conn) {

		try {

			PreparedStatement ps = conn.prepareStatement(""

					+ "delete from curso where id = ?");

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
