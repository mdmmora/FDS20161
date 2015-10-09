package TAD.graph.incrementos.testes;

import TAD.graph.incrementos.GraphDirListAdj;
import TAD.graph.incrementos.GraphDirMatAdj;
import java.util.ArrayList;
import java.util.List;

public class TestaGraphIncremento2 {
//	private static void testaCaminhamentos(String orig, List<String> res, GraphDirListAdj<String> g1, GraphDirMatAdj<String> g2){
//		for (int i = 0; i < 50; i++)
//			System.out.print("-");
//		System.out.println("");
//
//		res = g1.traversalBreath(orig);
//		System.out.println("\n\n Largura - Grafo Lista");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		res = g2.traversalBreath(orig);
//		System.out.println("\n\n Largura - Grafo Matriz");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		res = g1.traversalDepth(orig);
//		System.out.println("\n\n Profundidade - Grafo Lista");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		res = g2.traversalDepth(orig);
//		System.out.println("\n\n Profundidade - Grafo Matriz");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		for (int i = 0; i < 50; i++)
//			System.out.print("-");
//		System.out.println("");
//
//	}
	
	public static void main(String[] args) {
//		GraphDirListAdj<String> grf1 = new GraphDirListAdj<String>();
//		GraphDirListAdj<Integer> grf0 = new GraphDirListAdj<Integer>();
//		GraphDirMatAdj<String> grf2 = new GraphDirMatAdj<String>(10);
//		GraphDirMatAdj<String> grf3_1 = new GraphDirMatAdj<String>(10);
//		GraphDirListAdj<String> grf3_2 = new GraphDirListAdj<String>();
		List<String> res = null;
//		
//		grf0.addNode(1);
//		grf0.addNode(2);
//		grf0.addNode(3);
//		grf0.addNode(4);
//		grf0.addEdge(1, 2);
//		grf0.addEdge(2, 3);
//		grf0.addEdge(2, 4);
//		
//		
//		grf1.addNode(new String("A"));
//		grf1.addNode(new String("B"));
//		grf1.addNode(new String("C"));
//		grf1.addNode(new String("D"));
//		grf1.addNode(new String("E"));
//		grf2.addNode(new String("A"));
//		grf2.addNode(new String("B"));
//		grf2.addNode(new String("C"));
//		grf2.addNode(new String("D"));
//		grf2.addNode(new String("E"));
//		
//		grf1.addEdge("A", "B");
//		grf1.addEdge("A", "C");
//		grf1.addEdge("B", "D");
//		grf1.addEdge("B", "E");
//		grf1.addEdge("C", "D");
//		grf1.addEdge("C", "E");
//		grf2.addEdge("A", "B");
//		grf2.addEdge("A", "C");
//		grf2.addEdge("B", "D");
//		grf2.addEdge("B", "E");
//		grf2.addEdge("C", "D");
//		grf2.addEdge("C", "E");
//		
//		grf3_1.addNode("1");
//		grf3_1.addNode("2");
//		grf3_1.addNode("3");
//		grf3_1.addNode("4");
//		grf3_1.addNode("5");
//		grf3_1.addNode("6");
//		
//		grf3_1.addEdge("1", "2");
//		grf3_1.addEdge("2", "3");
//		grf3_1.addEdge("3", "4");
//		grf3_1.addEdge("4", "5");
//		grf3_1.addEdge("4", "6");
//
//		grf3_2.addNode("1");
//		grf3_2.addNode("2");
//		grf3_2.addNode("3");
//		grf3_2.addNode("4");
//		grf3_2.addNode("5");
//		grf3_2.addNode("6");
//		
//		grf3_2.addEdge("1", "2");
//		grf3_2.addEdge("2", "3");
//		grf3_2.addEdge("3", "4");
//		grf3_2.addEdge("4", "5");
//		grf3_2.addEdge("4", "6");
//
//		
//		System.out.println("Grafo 0 - Lista: \n" + grf0.toString());
//		System.out.println("Grafo 1 - Lista: \n" + grf1.toString());
//		System.out.println("Grafo 2 - Matriz: \n" + grf2.toString());
//		System.out.println("Grafo 3_1 - Matriz: \n" + grf3_1.toString());
//		
//		res = grf1.traversalDepth("A");
//		System.out.println("\n\n Profundidade - Grafo 1 - Lista");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//
//		res = grf2.traversalDepth("A");
//		System.out.println("\n\n Profundidade - Grafo 2 - Matriz");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		
//		res = grf3_1.traversalDepth("1");
//		System.out.println("\n\n Profundidade - Grafo 3_1 - Matriz");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//		
//		res = grf3_2.traversalDepth("1");
//		System.out.println("\n\n Profundidade - Grafo 3_2 - Lista");
//		for (String s:res)
//			System.out.print(s + " ");
//		System.out.println("");
//
//		System.out.println("\n\n Caminho de A até E - Grafo 1 - Lista");
//		System.out.println("\n " + grf1.singleSourceSingleDestRec("A", "E"));
//		
//
//		System.out.println("\n\n Caminho de A até E - Grafo 2 - Matriz");
//		System.out.println("\n " + grf2.singleSourceSingleDestRec("A", "E"));
//		
//		System.out.println("Alcaçavel:");
//		System.out.println("A? Deveria ser false ->" + grf1.isReachable("A"));
//		System.out.println("D? Deveria ser true ->" + grf1.isReachable("D"));
//		System.out.println("E? Deveria ser true ->" + grf1.isReachable("E"));
//		
//		System.out.println("Dois níveis a frente:");
//		System.out.println("Do A: ->" + grf1.getTwoLevelsAhead("A"));
		
		for (int i = 0; i < 50; i++)
			System.out.print("=");
		System.out.println("");
		
		GraphDirListAdj<String> g1 = new GraphDirListAdj<String>();
		GraphDirMatAdj<String> g2 = new GraphDirMatAdj<String>(11);
		
		g1.addNode(new String("A"));
		g2.addNode(new String("A"));
		g1.addNode(new String("B"));
		g2.addNode(new String("B"));
		g1.addNode(new String("C"));
		g2.addNode(new String("C"));
		g1.addNode(new String("D"));
		g2.addNode(new String("D"));
		g1.addNode(new String("E"));
		g2.addNode(new String("E"));
		g1.addNode(new String("F"));
		g2.addNode(new String("F"));
		g1.addNode(new String("G"));
		g2.addNode(new String("G"));
		g1.addNode(new String("H"));
		g2.addNode(new String("H"));
		g1.addNode(new String("I"));
		g2.addNode(new String("I"));
		g1.addNode(new String("J"));
		g2.addNode(new String("J"));
		g1.addNode(new String("K"));
		g2.addNode(new String("K"));

		g1.addEdge("A", "D");
		g2.addEdge("A", "D");
		
		g1.addEdge("B", "A");
		g2.addEdge("B", "A");
		
		g1.addEdge("C", "E");
		g2.addEdge("C", "E");
		
		g1.addEdge("D", "E");
		g2.addEdge("D", "E");

		g1.addEdge("D", "G");
		g2.addEdge("D", "G");
		
		g1.addEdge("D", "F");
		g2.addEdge("D", "F");

		g1.addEdge("E", "B");
		g2.addEdge("E", "B");
		
		g1.addEdge("E", "G");
		g2.addEdge("E", "G");

		g1.addEdge("E", "H");
		g2.addEdge("E", "H");

		g1.addEdge("F", "G");
		g2.addEdge("F", "G");

		g1.addEdge("G", "J");
		g2.addEdge("G", "J");

		g1.addEdge("G", "K");
		g2.addEdge("G", "K");

		g1.addEdge("I", "F");
		g2.addEdge("I", "F");

		g1.addEdge("J", "I");
		g2.addEdge("J", "I");

		g1.addEdge("K", "H");
		g2.addEdge("K", "H");
		
		System.out.println("Grafo - Lista: \n" + g1.toString());
		System.out.println("Grafo - Matriz: \n" + g2.toString());

//		testaCaminhamentos("C", res, g1, g2);

	}

}
