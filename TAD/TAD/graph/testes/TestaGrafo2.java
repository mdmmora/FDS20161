package TAD.graph.testes;

import java.util.ArrayList;
import java.util.List;

import TAD.graph.*;

public class TestaGrafo2 {
	public static void main(String [] argc) {
		GrafoDirRotMatAdj<String, Integer> mapaM = new GrafoDirRotMatAdj<>(10);
		GrafoDirRotLisAdj<String, Integer> mapaL = new GrafoDirRotLisAdj<>();
		
		mapaM.addNode("A");
		mapaM.addNode("B");
		mapaM.addNode("C");
		mapaM.addNode("D");
		mapaM.addNode("E");
		mapaM.addNode("F");
		mapaM.addNode("G");
		mapaM.addNode("H");
		mapaM.addNode("I");
		mapaM.addNode("J");

		mapaM.addEdge("A", "F", 1);
		mapaM.addEdge("A", "D", 1);
		mapaM.addEdge("B", "D", 1);
		mapaM.addEdge("C", "E", 1);
		mapaM.addEdge("D", "B", 1);
		mapaM.addEdge("D", "G", 1);
		mapaM.addEdge("D", "E", 1);
		mapaM.addEdge("E", "G", 1);
		mapaM.addEdge("E", "H", 1);
		mapaM.addEdge("F", "A", 1);
		mapaM.addEdge("F", "I", 1);
		mapaM.addEdge("G", "D", 1);
		mapaM.addEdge("G", "J", 1);
		mapaM.addEdge("H", "E", 1);
		mapaM.addEdge("H", "J", 1);
		mapaM.addEdge("I", "F", 1);
		mapaM.addEdge("J", "G", 1);
		mapaM.addEdge("J", "H", 1);
		mapaM.addEdge("J", "C", 1);

		System.out.println("\n\nGrafo mapaM:");
		System.out.println(mapaM.toString());
		
		System.out.print("\n A -> J: ");
		System.out.println(mapaM.pathFromTo("A", "J"));
		System.out.print("\n F -> B: ");
		System.out.println(mapaM.pathFromTo("F", "B"));
		System.out.print("\n J -> B: ");
		System.out.println(mapaM.pathFromTo("J", "B"));
		System.out.print("\n J -> C: ");
		System.out.println(mapaM.pathFromTo("J", "C"));
		System.out.print("\n E -> F: ");
		System.out.println(mapaM.pathFromTo("E", "F"));
		System.out.print("\n A -> E: ");
		System.out.println(mapaM.pathFromTo("A", "E"));
		System.out.print("\n B -> A: ");
		System.out.println(mapaM.pathFromTo("B", "A"));
		System.out.print("\n B -> I: ");
		System.out.println(mapaM.pathFromTo("B", "I"));


		mapaL.addNode("A");
		mapaL.addNode("B");
		mapaL.addNode("C");
		mapaL.addNode("D");
		mapaL.addNode("E");
		mapaL.addNode("F");
		mapaL.addNode("G");
		mapaL.addNode("H");
		mapaL.addNode("I");
		mapaL.addNode("J");

		mapaL.addEdge("A", "F", 1);
		mapaL.addEdge("A", "D", 1);
		mapaL.addEdge("B", "D", 1);
		mapaL.addEdge("C", "E", 1);
		mapaL.addEdge("D", "B", 1);
		mapaL.addEdge("D", "G", 1);
		mapaL.addEdge("D", "E", 1);
		mapaL.addEdge("E", "G", 1);
		mapaL.addEdge("E", "H", 1);
		mapaL.addEdge("F", "A", 1);
		mapaL.addEdge("F", "I", 1);
		mapaL.addEdge("G", "D", 1);
		mapaL.addEdge("G", "J", 1);
		mapaL.addEdge("H", "E", 1);
		mapaL.addEdge("H", "J", 1);
		mapaL.addEdge("I", "F", 1);
		mapaL.addEdge("J", "G", 1);
		mapaL.addEdge("J", "H", 1);
		mapaL.addEdge("J", "C", 1);

		System.out.println("\n\nGrafo mapaL:");
		System.out.println(mapaL.toString());
		
		System.out.print("\n A -> J: ");
		System.out.println(mapaL.pathFromTo("A", "J"));
		System.out.print("\n F -> B: ");
		System.out.println(mapaL.pathFromTo("F", "B"));
		System.out.print("\n J -> B: ");
		System.out.println(mapaL.pathFromTo("J", "B"));
		System.out.print("\n J -> C: ");
		System.out.println(mapaL.pathFromTo("J", "C"));
		System.out.print("\n E -> F: ");
		System.out.println(mapaL.pathFromTo("E", "F"));
		System.out.print("\n A -> E: ");
		System.out.println(mapaL.pathFromTo("A", "E"));
		System.out.print("\n B -> A: ");
		System.out.println(mapaL.pathFromTo("B", "A"));
		System.out.print("\n B -> I: ");
		System.out.println(mapaL.pathFromTo("B", "I"));

		
	
	}
}
