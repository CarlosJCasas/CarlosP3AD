package controlador;

import java.util.List;

import modelo.facade.ModuloFacade;
import vista.ModulosUI;

public class ControladorModulos extends ModulosUI {

	@Override
	protected void agregarModulo(String nombre, int ciclo, int horas, String curso) {
		// TODO Auto-generated method stub
		ModuloFacade.addModulo(nombre, ciclo, horas, curso);
		
	}

	@Override
	protected void editarModulo(Integer id, String nombre, int ciclo, String curso, int horas ) {
		// TODO Auto-generated method stub
		ModuloFacade.actualizarModulo(id, nombre, ciclo, curso, horas);
	}

	@Override
	protected void eliminarModulo(Integer idModulo) {
		// TODO Auto-generated method stub
		
		ModuloFacade.eliminarModulo(idModulo);
	}
	
	@Override
	protected List<String[]> transformarListaVO() {
		// TODO Auto-generated method stub
		return ModuloFacade.listadoModulo();
	}

}
