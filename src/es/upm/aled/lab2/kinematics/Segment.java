package es.upm.aled.lab2.kinematics;
import java.util.ArrayList;
import java.util.List;



// TODO: Implemente la clase
public class Segment {

	private double length; // longitud en cm
	private double angle; // angulo en rad
	private List<Segment> children;
	
	/**
	 * Builds a new Segment with its angle, length and children.
	 * 
	 * @param length, its length in centimeters.
	 * @param angle, its angle in radians. 
	 */
	
	public Segment(double length, double angle) {
		this.length =length;
		this.angle = angle;
		this.children = new ArrayList<>();// lista de segmentos hijo de cada segmento 
	}
	/**
	 * Returns the length of the segment.
	 * 
	 * @return The length of the segment.
	 * .
	 */

	public double getLength() {
		return length;
	}



	public double getAngle() {
		return angle;
	}



	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public List<Segment> getChildren(){
		return children;
	}

	public void addChild(Segment child) {
		if (!children.contains(child) && !isInTree(child)) //que el nodo a añadir no esté ya 
			children.add(child);
		
	}

	public boolean isInTree(Segment segment) {
		for(Segment child: children) {
			if(child == segment || child.isInTree(segment)) // se comprueba que el child d la iteración no sea el mismo q le he pasado ni que esté ya en el árbol genealógico más abajo o así
				return true;
			}
		return false;
	}
}
