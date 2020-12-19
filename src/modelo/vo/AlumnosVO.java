package modelo.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class AlumnosVO {
	private List<AlumnoVO> alumnos;

	public AlumnosVO() {
		
	}
	
	public AlumnosVO(List<AlumnoVO> listadoAlumnos) {
		this.alumnos = listadoAlumnos;
	}

	public List<AlumnoVO> getListadoAlumnos() {
		return alumnos;
	}
	@XmlElement(name="alumno")
	public void setListadoAlumnos(List<AlumnoVO> listadoAlumnos) {
		this.alumnos = listadoAlumnos;
	}
		
}
