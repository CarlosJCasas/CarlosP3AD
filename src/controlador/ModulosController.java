package controlador;

import java.sql.SQLException;
import java.util.List;

import modelo.facade.ModuloFacade;
import modelo.vo.ModuloVO;
import vista.ModulosUI;

public class ModulosController extends ModulosUI {

	@Override
	protected void agregarModulo(String nombre, int ciclo, int horas, String curso) {
		// TODO Auto-generated method stub
		try {
			ModuloFacade.addModulo(nombre, ciclo, horas, curso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void editarModulo(Integer id, String nombre, int ciclo, String curso, int horas ) {
		// TODO Auto-generated method stub
		try {
			ModuloFacade.actualizarModulo(id, nombre, ciclo, curso, horas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void eliminarModulo(Integer idModulo) throws SQLException {
		// TODO Auto-generated method stub
		
		
			ModuloFacade.eliminarModulo(idModulo);
		
	}
	
	@Override
	protected List<ModuloVO> transformarListaVO() {
		List<ModuloVO> listaModulos = null;
		try {
			listaModulos = ModuloFacade.listadoModulo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaModulos;
	}

}
