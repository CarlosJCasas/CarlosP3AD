package modelo.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class AlumnoVO {
	private String dni, nombre, apellido1, apellido2;
	private int telf;
	private Date fnacimiento;
	
	

	public AlumnoVO() {
		
		
	}

	public AlumnoVO(String dni, String nombre, String apellido1, String apellido2, Date fnacimiento, int telf) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fnacimiento = fnacimiento;
		this.telf = telf;
	}


	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getTelf() {
		return telf;
	}
	
	public void setTelf(int telf) {
		this.telf = telf;
	}

	
}
