package modelo.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


public class ModuloVO {
	private int horas, idCiclo;
	private String nombre, curso;
	private Integer id;
	
	public ModuloVO() {
		
	}
	
	
	public ModuloVO(Integer id ,String nombre,int ciclo,int horas,String curso ) {
		
		this.horas = horas;
		this.idCiclo = ciclo;
		this.nombre = nombre;
		this.curso = curso;
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
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
		return idCiclo;
	}
	
	public void setCiclo(int ciclo) {
		this.idCiclo = ciclo;
	}
	
	
	
}
