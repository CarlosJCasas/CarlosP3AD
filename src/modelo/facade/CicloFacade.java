package modelo.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.CicloVO;

public class CicloFacade {

	public static void addCiclo(Integer id, String nombre, String nivel, Integer curso) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "INSERT INTO ciclo (id, nombre, nivel, curso) VALUES (" + id + ",'" + nombre + "','"
				+ nivel + "'," + curso + ")";

		statement.executeUpdate(query);
		statement.close();
		connection.close();
	}

	public static List<CicloVO> listadoCiclos() throws SQLException {
		List<CicloVO> listaCiclos = new ArrayList<CicloVO>();
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "SELECT id, nombre, nivel, curso FROM ciclo ORDER BY id";

		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String nombre = resultSet.getString("nombre");
			String nivel = resultSet.getString("nivel");
			Integer curso = resultSet.getInt("curso");
			listaCiclos.add(new CicloVO(id, nombre, nivel, curso));

		}

		statement.close();
		connection.close();

		return listaCiclos;

	}

	public static void actualizarCiclo(Integer id, String nombre, String nivel, Integer curso) throws SQLException {

		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "UPDATE ciclo SET nombre='" + nombre + "', nivel ='" + nivel + "', curso=" + curso
				+ " WHERE id =" + id;

		statement.executeUpdate(query);
		statement.close();
		connection.close();

	}

	public static void eliminarCiclo(Integer id) throws SQLException {

		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "DELETE FROM ciclo WHERE id = " + id;

		statement.executeUpdate(query);
		statement.close();
		connection.close();

	}

}
