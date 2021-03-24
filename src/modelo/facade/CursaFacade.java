package modelo.facade;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelo.vo.AlumnoVO;
import modelo.vo.CursaVO;
import modelo.vo.CursanVO;
import modelo.vo.ModuloVO;

public class CursaFacade {
	private static ArrayList<CursaVO> listaCursa;

	public CursaFacade() {
	
	}
	
	public static void addCursa(CursaVO cursa) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query ="INSERT INTO alumno_modulo (alumno_id, modulo_id, anho, nota) VALUES ('"+cursa.getDni()+"',"+cursa.getIdModulo()+",'"+cursa.getAnho()+"',"+cursa.getNota()+")";
		statement.executeUpdate(query);
		statement.close();
		connection.close();
	}

	public static List<CursaVO> listadoCursa() throws SQLException {
		List<CursaVO> listaCursan = new ArrayList<>();
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query ="SELECT alumno_id, modulo_id, anho, nota FROM alumno_modulo ORDER BY alumno_id";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			String alDni = resultSet.getString("alumno_id");
			int modId = resultSet.getInt("modulo_id");
			String year = resultSet.getString("anho");
			Double nota = resultSet.getDouble("nota");
			listaCursan.add(new CursaVO(alDni, modId, year, nota));
		}
		statement.close();
		connection.close();
		return listaCursan;
	}

	public static void actualizarCursa(Integer idmod, String dnial, String anho, Double nota) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query ="UPDATE alumno_modulo SET alumno_id ='"+dnial+"', modulo_id ="
		+idmod+",anho = '"+anho+"', nota ="+nota;
		statement.executeUpdate(query);
		statement.close();
		connection.close();
	}

	public static void eliminarCursa(Integer id, String dni) throws SQLException {
		Connection connection = DataBaseConnection.getConnection();
		Statement statement = connection.createStatement();
	
		String query ="DELETE FROM alumno_modulo WHERE alumno_id ='"+dni+"' AND modulo_id = "+id;
		statement.executeUpdate(query);
		statement.close();
		connection.close();
	}
}
