package modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.vo.AlumnoVO;

public class AlumnoFacade {
	private static List<AlumnoVO> listaAlumnos;

	public AlumnoFacade() {

	}

	public static void addAlumno(String dni, String nombre, String ap1, String ap2, int telefono, Date fecha)
			throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "INSERT INTO alumno (dni, nombre, primerap, segunap, telefono, f_naci) VALUES ('" + dni
				+ "','" + nombre + "','" + ap1 + "','" + ap2 + "'," + telefono + ",'"
				+ new Date(fecha.getTime()) + "')";
		statement.executeUpdate(query);
		statement.close();
		connection.close();

	}

	public static List<AlumnoVO> listadoAlumnos() throws SQLException {
		List<AlumnoVO> listaAlumnos = new ArrayList<AlumnoVO>();
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT dni, nombre, primerap,segunap,telefono,f_naci FROM alumno ORDER BY dni";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String dni = resultSet.getString("dni");
			String nombre = resultSet.getString("nombre");
			String ap1 = resultSet.getString("primerap");
			String ap2 = resultSet.getString("segunap");
			int telefono = resultSet.getInt("telefono");
			Date fnaci = resultSet.getDate("f_naci");
			listaAlumnos.add(new AlumnoVO(dni, nombre, ap1, ap2, fnaci, telefono));
		}
		statement.close();
		connection.close();
		return listaAlumnos;
	}

	public static void actualizarAlumno(String dni, String nombre, String ap1, String ap2, int telefono, Date fecha)
			throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "UPDATE alumno SET nombre ='" + nombre + "', primerap ='" + ap1 + "', segunap = '" + ap2
				+ "', telefono =" + telefono + ", f_naci = '" + new java.sql.Date(fecha.getTime()) + "' WHERE dni = '"
				+ dni + "'";
		statement.executeUpdate(query);
		statement.close();
		connection.close();

	}

	public static void eliminarAlumno(String dni) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "DELETE FROM alumno WHERE dni ='" + dni +"'";
		statement.executeUpdate(query);
		statement.close();
		connection.close();

	}
}
