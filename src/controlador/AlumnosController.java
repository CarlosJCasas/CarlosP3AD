package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.facade.AlumnoFacade;
import modelo.facade.CursaFacade;
import modelo.vo.AlumnoVO;
import modelo.vo.CursaVO;
import vista.AlumnosUI;

public class AlumnosController extends AlumnosUI{
	
	

	public AlumnosController() {
		super();
		
	}

	
	
	public AlumnosController(Integer idModulo) {
		super(idModulo);
	}



	@Override
	protected void addAlumno(String dni, String nombre, String ap1, String ap2, int telefono, Date fecha) throws SQLException {
		
			AlumnoFacade.addAlumno(dni, nombre, ap1, ap2, telefono, fecha);
		
	}

	@Override
	protected void actualizarAlumno(String dni, String nombre, String ap1, String ap2, int telefono, Date fecha) {
		// TODO Auto-generated method stub
		try {
			AlumnoFacade.actualizarAlumno(dni, nombre, ap1, ap2, telefono, fecha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarAlumno(String dni) {
		// TODO Auto-generated method stub
		try {
			AlumnoFacade.eliminarAlumno(dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected List<AlumnoVO> listadoAlumnos() {
		List<AlumnoVO> listaAlumnos = new ArrayList<AlumnoVO>();
		try {
			listaAlumnos = AlumnoFacade.listadoAlumnos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAlumnos;
	}

	@Override
	protected void addCursa(CursaVO cursa) {
		// TODO Auto-generated method stub
		try {
			CursaFacade.addCursa(cursa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void actualizarCursa(Integer idmod, String dnial, String anho, Double nota) {
		// TODO Auto-generated method stub
		try {
			CursaFacade.actualizarCursa(idmod, dnial, anho, nota);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarCursa(Integer id, String dni) {
		// TODO Auto-generated method stub
		try {
			CursaFacade.eliminarCursa(id, dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected List<CursaVO> listadoCursa() {
		List<CursaVO> listaCursa = new ArrayList<>();
		try {
			listaCursa = CursaFacade.listadoCursa();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCursa;
	}
	
	
}
