package modelo.facade;

import java.io.File;
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
	
	public static void addCursa() {
		try {
			
			listaCursa = new ArrayList<CursaVO>();
			CursaVO cursa = new CursaVO();
			cursa.setAnho("");
			cursa.setNota(0);
			listaCursa.add(cursa);
			
			CursanVO cursan = new CursanVO();
			cursan.setListaCursa(listaCursa);

			File file = new File("src\\cursaXML.xml");
			JAXBContext context = JAXBContext.newInstance(CursaVO.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cursan, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void listadoCursa() {
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(CursaVO.class);
			Unmarshaller ums=ctx.createUnmarshaller();
			CursanVO cursan=(CursanVO)ums.unmarshal(new File("src\\cursaXML.xml"));
			
			for(CursaVO cur : cursan.getListaCursa()) {
				cur.toString();
			}
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void actualizarCursa(Integer id, String dni) {
		
			try {
				ModuloVO modulo = new ModuloVO();
				AlumnoVO alumno = new AlumnoVO();
				CursaVO cursa = new CursaVO();
				for (int i = 0 ; i<listaCursa.size(); i++) {
					if (alumno.getDni().equals(dni) && modulo.getId().equals(id)) {
						listaCursa.set(i, cursa);
					}
				}
				CursanVO cursan = new CursanVO();
				cursan.setListaCursa(listaCursa);
				File file = new File("src\\cursaXML.xml");
				JAXBContext context = JAXBContext.newInstance(CursaVO.class);
				Marshaller marshaller = context.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				marshaller.marshal(cursan, file);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

	public static void eliminarCursa(Integer id, String dni) {
		
		try {
			ModuloVO modulo = new ModuloVO();
			AlumnoVO alumno = new AlumnoVO();
			CursaVO cursa = new CursaVO();
			for (int i = 0 ; i<listaCursa.size(); i++) {
				if (alumno.getDni().equals(dni) && modulo.getId().equals(id)) {
					listaCursa.remove(i);
				}
			}
			CursanVO cursan = new CursanVO();
			cursan.setListaCursa(listaCursa);
			File file = new File("src\\cursaXML.xml");
			JAXBContext context = JAXBContext.newInstance(CursaVO.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cursan, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
