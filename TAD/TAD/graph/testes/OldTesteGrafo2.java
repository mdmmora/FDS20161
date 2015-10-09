package TAD.graph.testes;

import java.util.ArrayList;
import java.util.List;

import TAD.graph.*;

public class OldTesteGrafo2 {
	public static void main(String [] argc) {
		GrafoDirRotLisAdj<String, Integer> mapa0 = new GrafoDirRotLisAdj<String, Integer>();
		GrafoDirRotLisAdj<String, String> n0 = new GrafoDirRotLisAdj<String, String>();
		GrafoDirRotMatAdj<String, Integer> mapa1 = new GrafoDirRotMatAdj<String, Integer>(20);
		GrafoDirRotMatAdj<String, String> n1 = new GrafoDirRotMatAdj<String, String>(20);
		List<String> caminho = new ArrayList<String>();
	
		
		mapa0.addNode("POA");
		mapa0.addNode("Viamao");
		mapa0.addNode("Cidreira");
		mapa0.addNode("Canoas");
		mapa0.addNode("Bage");
		
		mapa1.addNode("POA");
		mapa1.addNode("Viamao");
		mapa1.addNode("Cidreira");
		mapa1.addNode("Canoas");
		mapa1.addNode("Bage");
		
		mapa0.addEdge("POA", "Viamao", 30);
		mapa0.addEdge("Viamao", "POA", 30);
		
		mapa0.addEdge("POA", "Canoas", 20);
		mapa0.addEdge("Canoas", "POA", 20);
		
		mapa0.addEdge("POA", "Bage", 800);
		mapa0.addEdge("Bage", "POA", 800);
		
		mapa0.addEdge("Viamao", "Cidreira", 75);
		mapa0.addEdge("Cidreira", "Viamao", 75);
		
		mapa0.addEdge("Canoas", "Cidreira", 87);
		mapa0.addEdge("Cidreira", "Canoas", 87);
		
		mapa1.addEdge("POA", "Viamao", 30);
		mapa1.addEdge("Viamao", "POA", 30);
		
		mapa1.addEdge("POA", "Canoas", 20);
		mapa1.addEdge("Canoas", "POA", 20);
		
		mapa1.addEdge("POA", "Bage", 800);
		mapa1.addEdge("Bage", "POA", 800);
		
		mapa1.addEdge("Viamao", "Cidreira", 75);
		mapa1.addEdge("Cidreira", "Viamao", 75);
		
		mapa1.addEdge("Canoas", "Cidreira", 87);
		mapa1.addEdge("Cidreira", "Canoas", 87);
		
		caminho = mapa0.pathFromTo("POA", "Bage");
		System.out.println(caminho);
		caminho = mapa0.pathFromTo("POA", "Cidreira");
		System.out.println(caminho);
		caminho = mapa0.pathFromTo("Bage", "Cidreira");
		System.out.println(caminho);

		caminho = mapa1.pathFromTo("POA", "Bage");
		System.out.println(caminho);
		caminho = mapa1.pathFromTo("POA", "Cidreira");
		System.out.println(caminho);
		caminho = mapa1.pathFromTo("Bage", "Cidreira");
		System.out.println(caminho);

		
		n0.addNode("N1");
		n0.addNode("N2");
		n0.addNode("N3");
		n0.addNode("N4");
		n0.addNode("N5");
		n0.addNode("N6");
		n0.addNode("N7");
		
		n1.addNode("N1");
		n1.addNode("N2");
		n1.addNode("N3");
		n1.addNode("N4");
		n1.addNode("N5");
		n1.addNode("N6");
		n1.addNode("N7");
		
		n0.addEdge("N1", "N2", "r2");
		n0.addEdge("N2", "N1", "r1");
		n0.addEdge("N1", "N4", "r6");
		
		n0.addEdge("N2", "N3", "r3");
		
		n0.addEdge("N3", "N4", "r4");
		n0.addEdge("N4", "N3", "r5");		
		
		n0.addEdge("N5", "N4", "r7");
		n0.addEdge("N5", "N6", "r9");
		n0.addEdge("N6", "N5", "r10");
		
		n0.addEdge("N6", "N7", "r11");
		n0.addEdge("N7", "N4", "r8");

		n1.addEdge("N1", "N2", "r2");
		n1.addEdge("N2", "N1", "r1");
		n1.addEdge("N1", "N4", "r6");
		
		n1.addEdge("N2", "N3", "r3");
		
		n1.addEdge("N3", "N4", "r4");
		n1.addEdge("N4", "N3", "r5");		
		
		n1.addEdge("N5", "N4", "r7");
		n1.addEdge("N5", "N6", "r9");
		n1.addEdge("N6", "N5", "r10");
		
		n1.addEdge("N6", "N7", "r11");
		n1.addEdge("N7", "N4", "r8");

		
		System.out.println("\n Grafo dos N \n");
		caminho = n0.pathFromTo("N1", "N7");
		System.out.println(caminho);
		caminho = n0.pathFromTo("N6", "N1");
		System.out.println(caminho);
		caminho = n0.pathFromTo("N5", "N4");
		System.out.println(caminho);
		caminho = n0.pathFromTo("N5", "N7");
		System.out.println(caminho);

		System.out.println("\n Grafo dos N \n");
		caminho = n1.pathFromTo("N1", "N7");
		System.out.println(caminho);
		caminho = n1.pathFromTo("N6", "N1");
		System.out.println(caminho);
		caminho = n1.pathFromTo("N5", "N4");
		System.out.println(caminho);
		caminho = n1.pathFromTo("N5", "N7");
		System.out.println(caminho);
		
		
		System.out.println("\n Profundide - Cidades \n");
		System.out.println(mapa0.traversalDepth("POA"));
		System.out.println(mapa0.traversalDepth("Bage"));
		System.out.println(mapa0.traversalDepth("Cidreira"));

		System.out.println("\n Profundide - Cidades \n");
		System.out.println(mapa1.traversalDepth("POA"));
		System.out.println(mapa1.traversalDepth("Bage"));
		System.out.println(mapa1.traversalDepth("Cidreira"));

		
		System.out.println("\n Profundidade - do N \n");
		System.out.println(n0.traversalDepth("N1"));
		System.out.println(n0.traversalDepth("N2"));
		System.out.println(n0.traversalDepth("N3"));
		System.out.println(n0.traversalDepth("N4"));
		System.out.println(n0.traversalDepth("N5"));
		System.out.println(n0.traversalDepth("N6"));
		System.out.println(n0.traversalDepth("N7"));

		System.out.println("\n Profundidade - do N \n");
		System.out.println(n1.traversalDepth("N1"));
		System.out.println(n1.traversalDepth("N2"));
		System.out.println(n1.traversalDepth("N3"));
		System.out.println(n1.traversalDepth("N4"));
		System.out.println(n1.traversalDepth("N5"));
		System.out.println(n1.traversalDepth("N6"));
		System.out.println(n1.traversalDepth("N7"));

		
		System.out.println("\n Amplitude - Cidades \n");
		System.out.println(mapa0.traversalWidth("POA"));
		System.out.println(mapa0.traversalWidth("Bage"));
		System.out.println(mapa0.traversalWidth("Cidreira"));

		System.out.println("\n Amplitude - Cidades \n");
		System.out.println(mapa1.traversalWidth("POA"));
		System.out.println(mapa1.traversalWidth("Bage"));
		System.out.println(mapa1.traversalWidth("Cidreira"));

		
		System.out.println("\n Amplitude - do N \n");
		System.out.println(n0.traversalWidth("N1"));
		System.out.println(n0.traversalWidth("N2"));
		System.out.println(n0.traversalWidth("N3"));
		System.out.println(n0.traversalWidth("N4"));
		System.out.println(n0.traversalWidth("N5"));
		System.out.println(n0.traversalWidth("N6"));
		System.out.println(n0.traversalWidth("N7"));
		
		System.out.println("\n Amplitude - do N \n");
		System.out.println(n1.traversalWidth("N1"));
		System.out.println(n1.traversalWidth("N2"));
		System.out.println(n1.traversalWidth("N3"));
		System.out.println(n1.traversalWidth("N4"));
		System.out.println(n1.traversalWidth("N5"));
		System.out.println(n1.traversalWidth("N6"));
		System.out.println(n1.traversalWidth("N7"));

		System.out.println("\n Two levels ahear - do N \n");
		System.out.println("N1 --> " + n1.getTwoLevelsAhead("N1"));
		
		GrafoDirRotLisAdj<String, String> n3 = new GrafoDirRotLisAdj<String, String>();
//		GraphDirListAdj<String> n31 = new GraphDirListAdj<String>();
		GrafoDirRotMatAdj<String, String> n4 = new GrafoDirRotMatAdj<String, String>(20);
//		GraphDirMatAdj<String> n41 = new GraphDirMatAdj<String>(20);
		
		n3.addNode("P1");
		n3.addNode("P2");
		n3.addNode("P3");
		n3.addNode("P4");
		n3.addNode("P5");
		n3.addNode("P6");
		n3.addNode("P7");
		
		n4.addNode("P1");
		n4.addNode("P2");
		n4.addNode("P3");
		n4.addNode("P4");
		n4.addNode("P5");
		n4.addNode("P6");
		n4.addNode("P7");
		
//		n31.addNode("P1");
//		n31.addNode("P2");
//		n31.addNode("P3");
//		n31.addNode("P4");
//		n31.addNode("P5");
//		n31.addNode("P6");
//		n31.addNode("P7");
//		
//		n41.addNode("P1");
//		n41.addNode("P2");
//		n41.addNode("P3");
//		n41.addNode("P4");
//		n41.addNode("P5");
//		n41.addNode("P6");
//		n41.addNode("P7");
		
		n3.addEdge("P1", "P2", "s12");
		n3.addEdge("P1", "P3", "s13");
		n3.addEdge("P1", "P4", "s14");
		n3.addEdge("P2", "P5", "s25");
		n3.addEdge("P5", "P6", "s56");
		n3.addEdge("P7", "P1", "s71");
		
		n4.addEdge("P1", "P2", "s12");
		n4.addEdge("P1", "P3", "s13");
		n4.addEdge("P1", "P4", "s14");
		n4.addEdge("P2", "P5", "s25");
		n4.addEdge("P5", "P6", "s56");
		n4.addEdge("P7", "P1", "s71");
		
//		n31.addEdge("P1", "P2");
//		n31.addEdge("P1", "P3");
//		n31.addEdge("P1", "P4");
//		n31.addEdge("P2", "P5");
//		n31.addEdge("P5", "P6");
//		n31.addEdge("P7", "P1");
//		
//		n41.addEdge("P1", "P2");
//		n41.addEdge("P1", "P3");
//		n41.addEdge("P1", "P4");
//		n41.addEdge("P2", "P5");
//		n41.addEdge("P5", "P6");
//		n41.addEdge("P7", "P1");
		
		System.out.println("\n Profundidade - do P - n3\n");
		System.out.println(n3.traversalDepth("P1"));
		System.out.println(n3.traversalDepth("P2"));
		System.out.println(n3.traversalDepth("P3"));
		System.out.println(n3.traversalDepth("P4"));
		System.out.println(n3.traversalDepth("P5"));
		System.out.println(n3.traversalDepth("P6"));
		System.out.println(n3.traversalDepth("P7"));

		System.out.println("\n Profundidade - do P - n4 \n");
		System.out.println(n4.traversalDepth("P1"));
		System.out.println(n4.traversalDepth("P2"));
		System.out.println(n4.traversalDepth("P3"));
		System.out.println(n4.traversalDepth("P4"));
		System.out.println(n4.traversalDepth("P5"));
		System.out.println(n4.traversalDepth("P6"));
		System.out.println(n4.traversalDepth("P7"));

		
//		System.out.println("\n Profundidade - do P - n31\n");
//		System.out.println(n31.traversalDepth("P1"));
//		System.out.println(n31.traversalDepth("P2"));
//		System.out.println(n31.traversalDepth("P3"));
//		System.out.println(n31.traversalDepth("P4"));
//		System.out.println(n31.traversalDepth("P5"));
//		System.out.println(n31.traversalDepth("P6"));
//		System.out.println(n31.traversalDepth("P7"));
//
//		System.out.println("\n Profundidade - do P - n41 \n");
//		System.out.println(n41.traversalDepth("P1"));
//		System.out.println(n41.traversalDepth("P2"));
//		System.out.println(n41.traversalDepth("P3"));
//		System.out.println(n41.traversalDepth("P4"));
//		System.out.println(n41.traversalDepth("P5"));
//		System.out.println(n41.traversalDepth("P6"));
//		System.out.println(n41.traversalDepth("P7"));

		
	}
}
