package modelo.facade;


import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelo.vo.AlumnoVO;
import modelo.vo.AlumnosVO;

public class AlumnoFacade {
	private static List<AlumnoVO> listaAlumnos;

	public AlumnoFacade() {

	}

	public static void addAlumno() {
		
		try {
			AlumnoVO alumno = new AlumnoVO();
			alumno.setDni("");
			alumno.setNombre("");
			alumno.setApellido1("");
			alumno.setApellido2("");
			alumno.setTelf(123456789);
			
			listaAlumnos.add(alumno);
			
			AlumnosVO alumnos = new AlumnosVO();
			alumnos.setListadoAlumnos(listaAlumnos);
			File file = new File("src\\alumnoXML.xml");
			JAXBContext contexto = JAXBContext.newInstance(AlumnoVO.class);
			Marshaller marshall = contexto.createMarshaller();
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(alumnos,file);
					
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void listadoAlumnos() {
		try {
			File file = new File("src\\alumnoXML.xml");
			JAXBContext contexto = JAXBContext.newInstance(AlumnoVO.class);
			Unmarshaller unmarshal = contexto.createUnmarshaller();
			AlumnosVO alumnos = (AlumnosVO) unmarshal.unmarshal(file);
			
			for (AlumnoVO alum : alumnos.getListadoAlumnos()) {
				System.out.println(alum.toString());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void actualizarAlumno(String dni) {
			
			try {
				
				AlumnoVO alum = new AlumnoVO();
				for(int i = 0; i<listaAlumnos.size();i++) {
					if(listaAlumnos.get(i).getDni()==dni){
						listaAlumnos.set(i, alum);
					}
				}
				AlumnosVO alumns = new AlumnosVO();
				alumns.setListadoAlumnos(listaAlumnos);
				
				File file = new File("src\\alumnoXML.xml");
				JAXBContext contexto = JAXBContext.newInstance(AlumnoVO.class);
				Marshaller marshall = contexto.createMarshaller();
				marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshall.marshal(alumns,file);
						
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public static void eliminarAlumno(String dni) {
		
		try {
			AlumnoVO alum = new AlumnoVO();
			for(int i = 0; i<listaAlumnos.size();i++) {
				if(listaAlumnos.get(i).getDni()==dni){
					listaAlumnos.set(i, alum);
				}
			}
			
			AlumnosVO alumns = new AlumnosVO();
			alumns.setListadoAlumnos(listaAlumnos);
			
			File file = new File("src\\alumnoXML.xml");
			JAXBContext contexto = JAXBContext.newInstance(AlumnoVO.class);
			Marshaller marshall = contexto.createMarshaller();
			marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshall.marshal(alumns,file);
					
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
