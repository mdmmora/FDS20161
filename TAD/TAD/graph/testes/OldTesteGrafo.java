package TAD.graph.testes;

import TAD.*;
import TAD.graph.GrafoDirLstAdj;
import TAD.graph.TADGraphNRot;

import java.util.*;

public class OldTesteGrafo {
	public static void main(String [] argc)
	{
		TADGraphNRot<String, String> grf0 = new GrafoDirLstAdj<String, String>();
		TADGraphNRot<String, String> grf1 = new GrafoDirLstAdj<String, String>();
		List<String> listStr = new ArrayList<String>();
		
		grf0.addNode(new String("A"));
		grf0.addNode(new String("B"));
		grf0.addNode(new String("C"));
		grf0.addNode(new String("D"));
		grf0.addNode(new String("E"));
		grf0.addNode(new String("F"));
		grf0.addNode(new String("G"));
		grf0.addNode(new String("H"));
		
		grf1.addNode(new String("A"));
		grf1.addNode(new String("B"));
		grf1.addNode(new String("C"));
		grf1.addNode(new String("D"));
		grf1.addNode(new String("E"));
		grf1.addNode(new String("F"));
		grf1.addNode(new String("G"));
		grf1.addNode(new String("H"));
		
		grf0.addEdge(new String("A"), new String("B"), "10");
		grf0.addEdge(new String("A"), new String("C"), "20");
		grf0.addEdge(new String("B"), new String("D"), "15");
		grf0.addEdge(new String("C"), new String("E"), "25");
		grf0.addEdge(new String("D"), new String("E"), "5");
		grf0.addEdge(new String("D"), new String("F"), "7");
		grf0.addEdge(new String("E"), new String("F"), "110");
		grf0.addEdge(new String("F"), new String("G"), "90");
		grf0.addEdge(new String("F"), new String("H"), "80");
		
		grf1.addEdge(new String("A"), new String("B"), "10");
		grf1.addEdge(new String("A"), new String("C"), "20");
		grf1.addEdge(new String("B"), new String("D"), "15");
		grf1.addEdge(new String("C"), new String("E"), "25");
		grf1.addEdge(new String("D"), new String("E"), "5");
		grf1.addEdge(new String("D"), new String("F"), "7");
		grf1.addEdge(new String("E"), new String("F"), "110");
		grf1.addEdge(new String("F"), new String("G"), "90");
		grf1.addEdge(new String("F"), new String("H"), "80");
		
		
		System.out.println(grf0.toString());
		System.out.println(grf1.toString());
		
		listStr = grf0.depthFirstTraversal("A");
		System.out.println(listStr);
		listStr = grf1.depthFirstTraversal("A");
		System.out.println(listStr);
		
	}

}
