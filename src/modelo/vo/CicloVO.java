package modelo.vo;

public class CicloVO {

	private Integer id;
	private String nombre;
	private String nivel;
	private int curso;

	public CicloVO(Integer id, String nombre, String nivel, int curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nivel = nivel;
		this.curso = curso;
	}

	public CicloVO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	
}
