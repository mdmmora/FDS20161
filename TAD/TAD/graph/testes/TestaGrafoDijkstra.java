package TAD.graph.testes;

import TAD.graph.DijkstraResult;
import TAD.graph.GrafoDirRotMatAdj;
import TAD.graph.GrafoDirRotLisAdj;
public class TestaGrafoDijkstra {

	public static void main(String[] args) {
		GrafoDirRotMatAdj<String, Double> grfMat = new GrafoDirRotMatAdj<>(20);
		GrafoDirRotLisAdj<String, Double> grfLis = new GrafoDirRotLisAdj<>();
		DijkstraResult<String> resMat, resLis;
		
		grfMat.addNode("N1");
		grfMat.addNode("N2");
		grfMat.addNode("N3");
		grfMat.addNode("N4");
		grfMat.addNode("N5");
		grfMat.addNode("N6");
		grfMat.addNode("N7");
		grfMat.addNode("N8");
		
		grfMat.addEdge("N1", "N2", 2000.0);
		grfMat.addEdge("N1", "N3", 5.0);
		grfMat.addEdge("N2", "N4", 10.0);
		grfMat.addEdge("N3", "N1", 7.0);
		grfMat.addEdge("N3", "N6", 6.0);
		grfMat.addEdge("N4", "N5", 8.0);
		grfMat.addEdge("N4", "N7", 2.0);
		grfMat.addEdge("N5", "N2", 6.0);
		grfMat.addEdge("N6", "N3", 5.0);
		grfMat.addEdge("N6", "N5", 11.0);
		grfMat.addEdge("N6", "N8", 10.0);
		grfMat.addEdge("N7", "N5", 4.0);
		grfMat.addEdge("N8", "N5", 8.0);

		System.out.println("Grafo Matriz: ");
		System.out.println(grfMat + "\n\n");

		grfLis.addNode("N1");
		grfLis.addNode("N2");
		grfLis.addNode("N3");
		grfLis.addNode("N4");
		grfLis.addNode("N5");
		grfLis.addNode("N6");
		grfLis.addNode("N7");
		grfLis.addNode("N8");
		
		grfLis.addEdge("N1", "N2", 2.0);
		grfLis.addEdge("N1", "N3", 5.0);
		grfLis.addEdge("N2", "N4", 10.0);
		grfLis.addEdge("N3", "N1", 7.0);
		grfLis.addEdge("N3", "N6", 6.0);
		grfLis.addEdge("N4", "N5", 8.0);
		grfLis.addEdge("N4", "N7", 2.0);
		grfLis.addEdge("N5", "N2", 6.0);
		grfLis.addEdge("N6", "N3", 5.0);
		grfLis.addEdge("N6", "N5", 11.0);
		grfLis.addEdge("N6", "N8", 10.0);
		grfLis.addEdge("N7", "N5", 4.0);
		grfLis.addEdge("N8", "N5", 8.0);

		System.out.println("Grafo Lista: ");
		System.out.println(grfLis + "\n\n");

		
		resMat = grfMat.dijkstraMinimumPath_v1("N1");
		resLis = grfLis.dijkstraMinimumPath_v1("N1");
		
		System.out.println("Resultado do Dijkstra Matriz(Bruto)");
		System.out.println(resMat + "\n\n");
		System.out.println("Resultado do Dijkstra Lista(Bruto)");
		System.out.println(resLis + "\n\n");

		
		System.out.println("Para N2: " + resMat.getPath("N2"));
		System.out.println("    Custo: " + resMat.getCost("N2"));
		System.out.println("Para N2: " + resLis.getPath("N2"));
		System.out.println("    Custo: " + resLis.getCost("N2") + "\n");
		
		System.out.println("Para N3: " + resMat.getPath("N3"));
		System.out.println("    Custo: " + resMat.getCost("N3"));
		System.out.println("Para N3: " + resLis.getPath("N3"));
		System.out.println("    Custo: " + resLis.getCost("N3") + "\n");
		
		System.out.println("Para N4: " + resMat.getPath("N4"));
		System.out.println("    Custo: " + resMat.getCost("N4"));
		System.out.println("Para N4: " + resLis.getPath("N4"));
		System.out.println("    Custo: " + resLis.getCost("N4") + "\n");

		System.out.println("Para N5: " + resMat.getPath("N5"));
		System.out.println("    Custo: " + resMat.getCost("N5"));
		System.out.println("Para N5: " + resLis.getPath("N5"));
		System.out.println("    Custo: " + resLis.getCost("N5") + "\n");
		
		System.out.println("Para N6: " + resMat.getPath("N6"));
		System.out.println("    Custo: " + resMat.getCost("N6"));
		System.out.println("Para N6: " + resLis.getPath("N6"));
		System.out.println("    Custo: " + resLis.getCost("N6") + "\n");
		
		System.out.println("Para N7: " + resMat.getPath("N7"));
		System.out.println("    Custo: " + resMat.getCost("N7"));
		System.out.println("Para N7: " + resLis.getPath("N7"));
		System.out.println("    Custo: " + resLis.getCost("N7") + "\n");
		
		System.out.println("Para N8: " + resMat.getPath("N8"));
		System.out.println("    Custo: " + resMat.getCost("N8"));
		System.out.println("Para N8: " + resLis.getPath("N8"));
		System.out.println("    Custo: " + resLis.getCost("N8"));
	}

}
