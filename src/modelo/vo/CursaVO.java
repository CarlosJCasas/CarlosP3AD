package modelo.vo;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder= {"anho","nota"})
public class CursaVO {
	private String anho;
	private double nota;
	public CursaVO() {
		
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
