package modelo.vo;

import javax.xml.bind.annotation.XmlType;


public class CursaVO {
	private String dni;
	private int idModulo;
	private String anho;
	private double nota;
	public CursaVO() {
		
	}
	
	
	public CursaVO(String dni, int idModulo, String anho, double nota) {
		
		this.dni = dni;
		this.idModulo = idModulo;
		this.anho = anho;
		this.nota = nota;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getIdModulo() {
		return idModulo;
	}


	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}


	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
