package modelo.facade;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.vo.ModuloVO;

public class ModuloFacade {

	public ModuloFacade() {

	}

	public static void addModulo(String nombre, int ciclo, int horas, String curso) throws SQLException {
		ModuloVO modulo = new ModuloVO(null, nombre, ciclo, horas, curso);
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String queryInsert = "INSERT INTO modulo (nombre, curso, horas, idciclo) VALUES ('"+ nombre + "','" +curso+"',"+horas+","+ciclo+")";
		statement.executeUpdate(queryInsert);
		statement.close();
		connection.close();

	}

	public static List<ModuloVO> listadoModulo() throws SQLException {
		List<ModuloVO> listaModulos = new ArrayList<>();
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT id, nombre, curso, horas, idciclo FROM modulo ORDER BY nombre";
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("nombre");
			String course = resultSet.getString("curso");
			int horas = resultSet.getInt("horas");
			int idciclo = resultSet.getInt("idciclo");
			listaModulos.add(new ModuloVO(id, name, idciclo, horas, course));
		}
		statement.close();
		connection.close();
		return listaModulos;
	}

	public static void actualizarModulo(Integer id, String nombre, int ciclo, String curso, int horas) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "UPDATE modulo SET nombre = '" + nombre + "', curso =" + curso + ", horas = "+horas+", idciclo="+ ciclo +"WHERE id =" + id;
		statement.executeUpdate(query);
		statement.close();
		connection.close();
		
	}

	public static void eliminarModulo(Integer id) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "DELETE FROM modulo WHERE id =" + id;
		statement.executeUpdate(query);
		statement.close();
		connection.close();
	
	}

}
