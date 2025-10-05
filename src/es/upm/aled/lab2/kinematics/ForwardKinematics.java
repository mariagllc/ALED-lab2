package es.upm.aled.lab2.kinematics;

import es.upm.aled.lab2.gui.Node;

/**
 * This class implements a forward kinematics algorithm using recursion. It
 * expects a tree of Segments (defined by its length and angle with respect to
 * the previous Segment in the tree) and returns a tree of Nodes (defined by
 * their absolute coordinates in a 2-dimensional space).
 * 
 * @author rgarciacarmona
 */
public class ForwardKinematics {

	/**
	 * Returns a tree of Nodes to be used by SkeletonPanel to draw the position of
	 * an exoskeleton. This method is the public facade to a recursive method that
	 * builds the result from a tree of Segments defined by their angle and length,
	 * and the relationship between them (which Segment is children of which).
	 * 
	 * @param root    The root of the tree of Segments.
	 * @param originX The X coordinate for the origin point of the tree.
	 * @param originY The Y coordinate for the origin point of the tree.
	 * @return The tree of Nodes that represent the exoskeleton position in absolute
	 *         coordinates.
	 */
	// Public method: returns the root of the position tree
	public static Node computePositions(Segment root, double originX, double originY) {
		// TODO: Implemente este método
		return computePositions(root, originX, originY, 0);
	}

	// Private helper method that implements the recursive algorithm
	private static Node computePositions(Segment link, double baseX, double baseY, double accumulatedAngle) {
		// TODO: Implemente este método
		// código general, para comprobarlo
		long startTime = System.nanoTime();
		double newAccumulatedAngle = accumulatedAngle + link.getAngle();
		double newBaseX = baseX + link.getLength()*Math.cos(newAccumulatedAngle);
		double newBaseY = baseY + link.getLength()*Math.sin(newAccumulatedAngle);
		Node n =new Node( newBaseX, newBaseY);
		// hay que crear un Node. el único nodo que no tendrá hijos es el último de cada rama
		//Para este problema,elcasobasedeberáocurrircuandoelSegment que
		//se pasa al método recursivo no tenga hijos. Si se da esta circunstancia, deberá construirse
		//el Node pertinente, pero este no tendrá tampoco hijos. CASO BASE
		if(link.getChildren().isEmpty()) {
			long runningTime = System.nanoTime() - startTime;
			System.out.println("Tiempo de computePositions para un segmento con "
			+ link.getChildren().size() + " hijos: "
			+ runningTime + " nanosegundos");
			return n;						//el ultimo nodo q calculas es el que no tiene más hijos
		}
		//Paso recursivo:
		for(Segment child : link.getChildren()) {
			n.addChild(computePositions(child,newBaseX,newBaseY,newAccumulatedAngle));
		}
		long runningTime = System.nanoTime() - startTime;
		System.out.println("Tiempo de computePositions para un segmento con "
		+ link.getChildren().size() + " hijos: "
		+ runningTime + " nanosegundos");
		return n;
	}
}






















