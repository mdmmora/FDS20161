package TAD.testes;
import java.util.*;
import TAD.trees.*;

public class TestaArvBin1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] vetStr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		BinaryTreeLinked <String> arv = new BinaryTreeLinked<String>(vetStr);
		String res;
		List<String> resVet;

		System.out.println("Traversal Pre:");
		resVet = arv.traversalPre();
		for (String aux:resVet)
			System.out.print(aux + " ");
		

		System.out.println("\nTraversal Pos:");
		resVet = arv.traversalPos();
		for (String aux:resVet)
			System.out.print(aux + " ");
	

		System.out.println("\nTraversal Central:");
		resVet = arv.traversalCentral();
		for (String aux:resVet)
			System.out.print(aux + " ");
				
		System.out.println("\nElementos Internos:");
		resVet = arv.getInternalElelments();
		for (String aux:resVet)
			System.out.print(aux + " ");
				
		System.out.println("\nPath Size:");
		System.out.println("A -> " + arv.getPathSize("A"));
		System.out.println("B -> " + arv.getPathSize("B"));
		System.out.println("C -> " + arv.getPathSize("C"));
		System.out.println("D -> " + arv.getPathSize("D"));
		System.out.println("E -> " + arv.getPathSize("E"));
		System.out.println("F -> " + arv.getPathSize("F"));
		System.out.println("G -> " + arv.getPathSize("G"));
		System.out.println("H -> " + arv.getPathSize("H"));
		System.out.println("I -> " + arv.getPathSize("I"));
		System.out.println("J -> " + arv.getPathSize("J"));
		System.out.println("K -> " + arv.getPathSize("K"));
		System.out.println("L -> " + arv.getPathSize("L"));

	}
}
