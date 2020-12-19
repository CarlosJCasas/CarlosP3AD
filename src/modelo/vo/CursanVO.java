package modelo.vo;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CursanVO {
	
	private List<CursaVO> listaCursa;

	public List<CursaVO> getListaCursa() {
		return listaCursa;
	}
	@XmlElement(name="cursan")
	public void setListaCursa(List<CursaVO> listaCursa) {
		this.listaCursa = listaCursa;
	}
}
