package TAD.graph.testes;

import java.util.ArrayList;
import java.util.List;

import TAD.graph.*;

public class TestaGrafo {
	public static void main(String [] argc) {
		GrafoDirRotMatAdj<String, Double> mapa = new GrafoDirRotMatAdj<String, Double>(10);
		GrafoDirRotMatAdj<String, String> n = new GrafoDirRotMatAdj<String, String>(10);
		GrafoDirRotMatAdj<String, Double> n2 = new GrafoDirRotMatAdj<String, Double>(10);
		GrafoDirRotMatAdj<String, Double> n3 = new GrafoDirRotMatAdj<String, Double>(10);

		GrafoDirRotLisAdj<String, Double> mapa1 = new GrafoDirRotLisAdj<String, Double>();
//		GrafoDirRotLisAdj<String, String> n = new GrafoDirRotLisAdj<String, String>();
		GrafoDirRotLisAdj<String, Double> n22 = new GrafoDirRotLisAdj<String, Double>();
//		GrafoDirRotLisAdj<String, Double> n3 = new GrafoDirRotLisAdj<String, Double>();

		
		List<String> caminho = new ArrayList<String>();
		
		mapa.addNode("POA");
		mapa.addNode("Viamão");
		mapa.addNode("Cidreira");
		mapa.addNode("Canoas");
		mapa.addNode("Bagé");
		mapa.addNode("Curitiba");
		
		mapa.addEdge("POA", "Viamão", 30.0);
		mapa.addEdge("Viamão", "POA", 30.0);
		
		mapa.addEdge("POA", "Canoas", 20.0);
		mapa.addEdge("Canoas", "POA", 20.0);
		
		mapa.addEdge("POA", "Bagé", 800.0);
		mapa.addEdge("Bagé", "POA", 800.0);
		
		mapa.addEdge("Bagé", "Curitiba", 1200.0);
		mapa.addEdge("Curitiba", "Bagé", 1200.0);
		
		mapa.addEdge("Viamão", "Cidreira", 75.0);
		mapa.addEdge("Cidreira", "Viamão", 75.0);
		
		mapa.addEdge("Canoas", "Cidreira", 87.0);
		mapa.addEdge("Cidreira", "Canoas", 87.0);
		
		mapa1.addNode("POA");
		mapa1.addNode("Viamão");
		mapa1.addNode("Cidreira");
		mapa1.addNode("Canoas");
		mapa1.addNode("Bagé");
		mapa1.addNode("Curitiba");
		
		mapa1.addEdge("POA", "Viamão", 30.0);
		mapa1.addEdge("Viamão", "POA", 30.0);
		
		mapa1.addEdge("POA", "Canoas", 20.0);
		mapa1.addEdge("Canoas", "POA", 20.0);
		
		mapa1.addEdge("POA", "Bagé", 800.0);
		mapa1.addEdge("Bagé", "POA", 800.0);
		
		mapa1.addEdge("Bagé", "Curitiba", 1200.0);
		mapa1.addEdge("Curitiba", "Bagé", 1200.0);
		
		mapa1.addEdge("Viamão", "Cidreira", 75.0);
		mapa1.addEdge("Cidreira", "Viamão", 75.0);
		
		mapa1.addEdge("Canoas", "Cidreira", 87.0);
		mapa1.addEdge("Cidreira", "Canoas", 87.0);

		System.out.println("\n\nMapa V0:");
		System.out.println(mapa.toString());
		
		caminho = mapa.pathFromTo("POA", "Bagé");
		System.out.println(caminho);
		caminho = mapa.pathFromTo("POA", "Cidreira");
		System.out.println(caminho);
		caminho = mapa.pathFromTo("Bagé", "Cidreira");
		System.out.println(caminho);
		caminho = mapa.pathFromTo("POA", "Curitiba");
		System.out.println(caminho);

		System.out.println("\n\nMapa V1:");
		System.out.println(mapa1.toString());

		caminho = mapa1.pathFromTo("POA", "Bagé");
		System.out.println(caminho);
		caminho = mapa1.pathFromTo("POA", "Cidreira");
		System.out.println(caminho);
		caminho = mapa1.pathFromTo("Bagé", "Cidreira");
		System.out.println(caminho);
		caminho = mapa1.pathFromTo("POA", "Curitiba");
		System.out.println(caminho);

		
		n.addNode("N1");
		n.addNode("N2");
		n.addNode("N3");
		n.addNode("N4");
		n.addNode("N5");
		n.addNode("N6");
		n.addNode("N7");
		
		n.addEdge("N1", "N2", "r2");
		n.addEdge("N2", "N1", "r1");
		n.addEdge("N1", "N4", "r6");
		
		n.addEdge("N2", "N3", "r3");
		
		n.addEdge("N3", "N4", "r4");
		n.addEdge("N4", "N3", "r5");		
		
		n.addEdge("N5", "N4", "r7");
		n.addEdge("N5", "N6", "r9");
		n.addEdge("N6", "N5", "r10");
		
		n.addEdge("N6", "N7", "r11");
		n.addEdge("N7", "N4", "r8");

		System.out.println("\n\nGrafo N - V0:");
		System.out.println(n.toString());

		System.out.println("\n Grafo dos N \n");
		System.out.print("N1 -> N7  ");
		caminho = n.pathFromTo("N1", "N7");
		System.out.println(caminho);
		System.out.print("N6 -> N1  ");
		caminho = n.pathFromTo("N6", "N1");
		System.out.println(caminho);
		System.out.print("N5 -> N4  ");
		caminho = n.pathFromTo("N5", "N4");
		System.out.println(caminho);
		System.out.print("N5 -> N7  ");
		caminho = n.pathFromTo("N5", "N7");
		System.out.println(caminho);

		
		n2.addNode("N1");
		n2.addNode("N2");
		n2.addNode("N3");
		n2.addNode("N4");
		n2.addNode("N5");
		n2.addNode("N6");
		n2.addNode("N7");
		
		n2.addEdge("N1", "N2", 10.0);
		n2.addEdge("N2", "N1", 10.0);

		n2.addEdge("N2", "N3", 7.0);
		n2.addEdge("N3", "N2", 7.0);

		n2.addEdge("N3", "N4", 15.0);
		n2.addEdge("N4", "N3", 15.0);

		n2.addEdge("N4", "N1", 9.0);
		n2.addEdge("N1", "N4", 9.0);
		
		n2.addEdge("N4", "N5", 5.0);
		n2.addEdge("N5", "N4", 5.0);

		n2.addEdge("N5", "N6", 4.0);
		n2.addEdge("N6", "N5", 4.0);

		n2.addEdge("N6", "N7", 2.0);
		n2.addEdge("N7", "N6", 2.0);
		
		n2.addEdge("N7", "N4", 3.0);
		n2.addEdge("N4", "N7", 3.0);

		System.out.println("\n\nGrafo N - V2:");
		System.out.println(n2.toString());
		
		n22.addNode("N1");
		n22.addNode("N2");
		n22.addNode("N3");
		n22.addNode("N4");
		n22.addNode("N5");
		n22.addNode("N6");
		n22.addNode("N7");
		
		n22.addEdge("N1", "N2", 10.0);
		n22.addEdge("N2", "N1", 10.0);

		n22.addEdge("N2", "N3", 7.0);
		n22.addEdge("N3", "N2", 7.0);

		n22.addEdge("N3", "N4", 15.0);
		n22.addEdge("N4", "N3", 15.0);

		n22.addEdge("N4", "N1", 9.0);
		n22.addEdge("N1", "N4", 9.0);
		
		n22.addEdge("N4", "N5", 5.0);
		n22.addEdge("N5", "N4", 5.0);

		n22.addEdge("N5", "N6", 4.0);
		n22.addEdge("N6", "N5", 4.0);

		n22.addEdge("N6", "N7", 2.0);
		n22.addEdge("N7", "N6", 2.0);
		
		n22.addEdge("N7", "N4", 3.0);
		n22.addEdge("N4", "N7", 3.0);

		System.out.println("\n\nGrafo N - V22:");
		System.out.println(n22.toString());
		
		n3.addNode("A");
		n3.addNode("B");
		n3.addNode("C");
		
		n3.addEdge("A", "B", 7.0);
		n3.addEdge("B", "A", 7.0);
		n3.addEdge("A", "C", 10.0);
		n3.addEdge("C", "A", 10.0);
		n3.addEdge("B", "C", 1.0);
		n3.addEdge("C", "B", 1.0);
		
		System.out.println("\n\nGrafo N - V3:");
		System.out.println(n3.toString());
		
		System.out.println("\n Profundide - Cidades \n");
		System.out.println(mapa.traversalDepth("POA"));
		System.out.println(mapa.traversalDepth("Bagé"));
		System.out.println(mapa.traversalDepth("Cidreira"));
		
		System.out.println("\n Profundidade - do N \n");
		System.out.println(n.traversalDepth("N1"));
		System.out.println(n.traversalDepth("N2"));
		System.out.println(n.traversalDepth("N3"));
		System.out.println(n.traversalDepth("N4"));
		System.out.println(n.traversalDepth("N5"));
		System.out.println(n.traversalDepth("N6"));
		System.out.println(n.traversalDepth("N7"));
		
		System.out.println("\n Amplitude - Cidades \n");
		System.out.println(mapa.traversalWidth("POA"));
		System.out.println(mapa.traversalWidth("Bagé"));
		System.out.println(mapa.traversalWidth("Cidreira"));
		
		System.out.println("\n Amplitude - do N \n");
		System.out.println(n.traversalWidth("N1"));
		System.out.println(n.traversalWidth("N2"));
		System.out.println(n.traversalWidth("N3"));
		System.out.println(n.traversalWidth("N4"));
		System.out.println(n.traversalWidth("N5"));
		System.out.println(n.traversalWidth("N6"));
		System.out.println(n.traversalWidth("N7"));
		
		System.out.println("\n Dijkstra - do mapa - Mat Adj- origem POA\n");
		System.out.println(mapa.dijkstraMinimumPath_v1("POA"));
		
		System.out.println("\n Dijkstra - do mapa 1 - Lst Adj- origem POA\n");
		System.out.println(mapa1.dijkstraMinimumPath_v1("POA"));
		
		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N1 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N1"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N2 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N2"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N3 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N3"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N4 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N4"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N5 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N5"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N6 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N6"));

		System.out.println("\n Dijkstra - do n2 - Mat Adj - origem N7 \n");
		System.out.println(n2.dijkstraMinimumPath_v1("N7"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N1 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N1"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N2 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N2"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N3 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N3"));

		
		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N4 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N4"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N5 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N5"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N6 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N6"));

		System.out.println("\n Dijkstra - do n22 - Lst Adj - origem N7 \n");
		System.out.println(n22.dijkstraMinimumPath_v1("N7"));

		
		System.out.println("\n Floyd - do n2 \n");
		double[][] path = n2.floydWarshall();
		for (int i = 0; i < path.length; i++){
			System.out.print("Linha " + i + ":");
			for (int j = 0; j < path.length; j++)
				System.out.print(path[i][j] + " ");
			System.out.println("");
		}
		

		System.out.println("\n Floyd - do n3 \n");
		path = n3.floydWarshall();
		for (int i = 0; i < path.length; i++){
			System.out.print("Linha " + i + ":");
			for (int j = 0; j < path.length; j++)
				System.out.print(path[i][j] + " ");
			System.out.println("");
		}

		
		System.out.print("\n Reachable - do n2 - origem N7: ");
		System.out.println(n2.countReachable("N7"));

		System.out.print("\n Reachable - do n2 - origem N4: ");
		System.out.println(n2.countReachable("N4"));

		System.out.print("\n Reachable - do Mapa - origem POA: ");
		System.out.println(mapa.countReachable("POA"));

		System.out.print("\n Reachable - do Mapa - origem BAGE: ");
		System.out.println(mapa.countReachable("Bagé"));

	
	}
}
