package TAD.graph.incrementos.testes;

import java.util.ArrayList;
import java.util.List;

import TAD.graph.incrementos.v2.*;

public class TestaGraphIncremento1_v2 {
	public static void main(String [] argc) {
		GraphDirMatAdj<String> mapa = new GraphDirMatAdj<String>(10);
//		GraphDirListAdj<String> mapa = new GraphDirListAdj<String>();
		GraphDirMatAdj<String> n = new GraphDirMatAdj<String>(10);
//		GraphDirListAdj<String> n = new GraphDirListAdj<String>();
		List<String> caminho = new ArrayList<String>();
		List<String> todos = new ArrayList<String>();
		
		mapa.addNode("POA");
		mapa.addNode("Viamão");
		mapa.addNode("Cidreira");
		mapa.addNode("Canoas");
		mapa.addNode("Bagé");
		mapa.addNode("Passo Fundo");
		mapa.addNode("Pananbi");
		
		mapa.addEdge("POA", "Viamão");
		mapa.addEdge("Viamão", "POA");
		
		mapa.addEdge("POA", "Canoas");
		mapa.addEdge("Canoas", "POA");
		
		mapa.addEdge("POA", "Bagé");
		mapa.addEdge("Bagé", "POA");
		
		mapa.addEdge("Viamão", "Cidreira");
		mapa.addEdge("Cidreira", "Viamão");
		
		mapa.addEdge("Canoas", "Cidreira");
		mapa.addEdge("Cidreira", "Canoas");
		
		mapa.addEdge("Pananbi", "Canoas");
		
		System.out.println("\n\n Grafo das Cidades\n" + mapa.toString());
		
		
		caminho = mapa.pathFromTo("POA", "Bagé");
		System.out.println("POA -> Bage  " + caminho);
		caminho = mapa.pathFromTo("POA", "Cidreira");
		System.out.println("POA --> Cidreira  "+caminho);
		caminho = mapa.pathFromTo("Bagé", "Cidreira");
		System.out.println("Bage --> Cidreira  " + caminho);

		todos = mapa.traversalDepth("POA");
		System.out.println("Traversal Depth de POA   " + todos);
		todos = mapa.traversalWidth("POA");
		System.out.println("Traversal Width de POA   " + todos);
		
		
		n.addNode("N1");
		n.addNode("N2");
		n.addNode("N3");
		n.addNode("N4");
		n.addNode("N5");
		n.addNode("N6");
		n.addNode("N7");
		
		n.addEdge("N1", "N2");
		n.addEdge("N2", "N1");
		
		n.addEdge("N2", "N3");
		n.addEdge("N3", "N2");
		
		n.addEdge("N3", "N4");
		n.addEdge("N4", "N3");		
		
		n.addEdge("N5", "N4");
		n.addEdge("N4", "N5");
		n.addEdge("N5", "N6");
		n.addEdge("N6", "N5");
		
		n.addEdge("N6", "N7");
		n.addEdge("N7", "N6");
		n.addEdge("N7", "N4");
		n.addEdge("N4", "N7");
		
		System.out.println("\n\n Grafo dos N\n" + n.toString());
		
//		System.out.println("Is reachable N1:\t " + n.isReachable("N1"));
//		System.out.println("Is reachable N2:\t " + n.isReachable("N2"));
//		System.out.println("Is reachable N3:\t " + n.isReachable("N3"));
//		System.out.println("Is reachable N4:\t " + n.isReachable("N4"));
//		System.out.println("Is reachable N5:\t " + n.isReachable("N5"));
//		System.out.println("Is reachable N6:\t " + n.isReachable("N6"));
//		System.out.println("Is reachable N7:\t " + n.isReachable("N7"));
//
//				
		System.out.println("\n Grafo dos N \n");
		caminho = n.pathFromTo("N1", "N7");
		System.out.println("N1 --> N7  " + caminho);
		caminho = n.pathFromTo("N6", "N1");
		System.out.println("N6 --> N1  " + caminho);
		caminho = n.pathFromTo("N5", "N4");
		System.out.println("N5 --> N4  " + caminho);
		caminho = n.pathFromTo("N5", "N7");
		System.out.println("N5 --> N7  " + caminho);

		todos = n.traversalDepth("N5");
		System.out.println("Traversal depth do N5  " + todos);
		todos = n.traversalWidth("N5");
		System.out.println("Traversal width do N5  " + todos);
		}
}
