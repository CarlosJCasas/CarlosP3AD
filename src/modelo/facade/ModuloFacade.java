package modelo.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelo.vo.ModuloVO;
import modelo.vo.ModulosVO;

public class ModuloFacade {

	public ModuloFacade() {

	}

	public static void addModulo(String nombre, int ciclo, int horas, String curso) {
		ModuloVO modulo = new ModuloVO(null, nombre, ciclo, horas, curso);
		try {
			JAXBContext context;
			context = JAXBContext.newInstance(ModulosVO.class);
			Unmarshaller unmarsh = context.createUnmarshaller();
			File file = new File("src\\modulosXML.xml");
			ModulosVO listaModulos = (ModulosVO) unmarsh.unmarshal(file);
			if (listaModulos != null) {
				int mayor = 0;
				// If the list of ModuloVO is not empty search wich one has the higher id in the
				// list
				if (!listaModulos.getModulos().isEmpty()) {
					for (ModuloVO mod : listaModulos.getModulos()) {
						if (mod.getId() > mayor) {
							mayor = mod.getId();
						}
					}
					modulo.setId(mayor + 1);
				} else {
					modulo.setId(mayor);
				}
				listaModulos.addModulo(modulo);
				Marshaller marsh = context.createMarshaller();
				marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marsh.marshal(listaModulos, file);
			}
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static List<String[]> listadoModulo() {
		//List of an Array of strings
		//Each item is a List<String> of ModuloVO attributes
		List<String[]> listadoModulos = new ArrayList<String[]>();
		try {
			JAXBContext context = JAXBContext.newInstance(ModulosVO.class);
			Unmarshaller unmarsh = context.createUnmarshaller();
			File file = new File("src\\modulosXML.xml");
			ModulosVO modulos = (ModulosVO) unmarsh.unmarshal(file);
			
			// Modulos.getmodulos() return a List<ModuloVO>
			//If the list is not empty list each ModuloVO in a String[]
			if (!modulos.getModulos().isEmpty()) {
				String[] itemsModulo;
				for(ModuloVO modulo : modulos.getModulos()) {
					itemsModulo = new String[5];
					itemsModulo[0]=modulo.getNombre();
					itemsModulo[1]=""+modulo.getCiclo();
					itemsModulo[2]=modulo.getCurso();
					itemsModulo[3]=""+modulo.getHoras();
					itemsModulo[4]=""+modulo.getId();
					listadoModulos.add(itemsModulo);
				}
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listadoModulos;

	}

	public static void actualizarModulo(Integer id, String nombre, int ciclo, String curso, int horas) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ModulosVO.class);
			Unmarshaller unmarsh = context.createUnmarshaller();
			File file = new File("src\\modulosXML.xml");
			ModulosVO listaModulos = (ModulosVO) unmarsh.unmarshal(file);
			
			if(listaModulos != null) {
				for(ModuloVO mod : listaModulos.getModulos()) {
					if(mod.getId() == id) {
						mod.setNombre(nombre);
						mod.setCiclo(ciclo);
						mod.setCurso(curso);
						mod.setHoras(horas);
					}
				}
				Marshaller marsh = context.createMarshaller();
				marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marsh.marshal(listaModulos, file);
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void eliminarModulo(Integer id) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(ModulosVO.class);
			Unmarshaller unmarsh = context.createUnmarshaller();
			File file = new File("src\\modulosXML.xml");
			ModulosVO listaModulos = (ModulosVO) unmarsh.unmarshal(file);
			if(listaModulos!=null) {
				for(ModuloVO modulo : listaModulos.getModulos()) {
					if(modulo.getId().equals(id));
					listaModulos.getModulos().remove(modulo);
					break;
				}
			}
			
			Marshaller marsh = context.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marsh.marshal(listaModulos, file);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
