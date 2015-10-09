package TAD.graph.incrementos.testes;

import java.util.ArrayList;
import java.util.List;

import TAD.graph.incrementos.*;

public class TestaGraphIncremento1 {
	public static void main(String [] argc) {
		GraphDirMatAdj<String> mapa = new GraphDirMatAdj<String>(10);
		//GraphDirListAdj<String> mapa = new GraphDirListAdj<String>();
		GraphDirMatAdj<String> n = new GraphDirMatAdj<String>(10);
		//GraphDirListAdj<String> n = new GraphDirListAdj<String>();
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
		
		System.out.println("Is reachable POA:\t " + mapa.isReachable("POA"));
		System.out.println("Is reachable Viamão:\t " + mapa.isReachable("Viamão"));
		System.out.println("Is reachable Cidreira:\t " + mapa.isReachable("Cidreira"));
		System.out.println("Is reachable Canoas:\t " + mapa.isReachable("Canoas"));
		System.out.println("Is reachable Bagé:\t " + mapa.isReachable("Bagé"));
		System.out.println("Is reachable Passo Fundo:\t " + mapa.isReachable("Passo Fundo"));
		System.out.println("Is reachable Pananbi:\t " + mapa.isReachable("Pananbi"));

//		
//		caminho = mapa.singleSourceSingleDestRec("POA", "Bagé");
//		System.out.println("POA -> Bage  " + caminho);
//		caminho = mapa.singleSourceSingleDestRec("POA", "Cidreira");
//		System.out.println("POA --> Cidreira  "+caminho);
//		caminho = mapa.singleSourceSingleDestRec("Bagé", "Cidreira");
//		System.out.println("Bage --> Cidreira  " + caminho);
//
//		todos = mapa.traversalDepth("POA");
//		System.out.println("Traversal Depth de POA   " + todos);
//		
		
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
		
		System.out.println("Is reachable N1:\t " + n.isReachable("N1"));
		System.out.println("Is reachable N2:\t " + n.isReachable("N2"));
		System.out.println("Is reachable N3:\t " + n.isReachable("N3"));
		System.out.println("Is reachable N4:\t " + n.isReachable("N4"));
		System.out.println("Is reachable N5:\t " + n.isReachable("N5"));
		System.out.println("Is reachable N6:\t " + n.isReachable("N6"));
		System.out.println("Is reachable N7:\t " + n.isReachable("N7"));

//				
//		System.out.println("\n Grafo dos N \n");
//		caminho = n.singleSourceSingleDestRec("N1", "N7");
//		System.out.println("N1 --> N7  " + caminho);
//		caminho = n.singleSourceSingleDestRec("N6", "N1");
//		System.out.println("N6 --> N1  " + caminho);
//		caminho = n.singleSourceSingleDestRec("N5", "N4");
//		System.out.println("N5 --> N4  " + caminho);
//		caminho = n.singleSourceSingleDestRec("N5", "N7");
//		System.out.println("N5 --> N7  " + caminho);
//
//		todos = n.traversalDepth("N5");
//		System.out.println("Traversal depth do N5  " + todos);
		}
}
