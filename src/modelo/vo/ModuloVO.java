package modelo.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre", "curso", "ciclo", "horas"})
public class ModuloVO {
	private int horas, ciclo;
	private String nombre, curso;
	private Integer id;
	
	
	
	public ModuloVO() {
		
	}
	
	
	public ModuloVO(Integer id ,String nombre,int ciclo,int horas,String curso ) {
		
		this.horas = horas;
		this.ciclo = ciclo;
		this.nombre = nombre;
		this.curso = curso;
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	@XmlAttribute
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getHoras() {
		return horas;
	}
	
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCiclo() {
		return ciclo;
	}
	
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	
	
	
}
