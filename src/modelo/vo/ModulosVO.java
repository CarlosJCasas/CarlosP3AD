package modelo.vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



public class ModulosVO {
	private List<ModuloVO> mListaModulos = new ArrayList<ModuloVO>();
	

	public List<ModuloVO> getModulos() {
		return mListaModulos;
	}
	
	public void setModulos(List<ModuloVO> listaModulos) {
		this.mListaModulos = listaModulos;
	}
	
	
	
}
