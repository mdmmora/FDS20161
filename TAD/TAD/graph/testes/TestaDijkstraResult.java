package TAD.graph.testes;

import TAD.graph.DijkstraResult;

public class TestaDijkstraResult {

	public static void main(String[] args) {
		String n1 = "a";
		String n2 = "b";
		String n3 = "c";
		String n4 = "d";
		String n5 = "e";
		String n6 = "f";
		String n7 = "g";
		String n8 = "h";
		DijkstraResult<String> dRes = new DijkstraResult<>(n1);
		
		dRes.addNode(n1, n2, 10.0);
		dRes.addNode(n2, n3, 15.0);
		dRes.addNode(n3, n4, 20.0);
		dRes.addNode(n4, null, 25.0);
		
		dRes.addNode(n8, n7, 1.0);
		dRes.addNode(n7, n6, 2.0);
		dRes.addNode(n6, n4, 3.0);
		
		dRes.addNode(n5, n2, 100.0);
		System.out.println("dRes: \n" + dRes);
		
		System.out.println("\nCaminhos:");
		System.out.println("Até n1: " + dRes.getPath(n1));
		System.out.println("\tCusto: " + dRes.getCost(n1));
		System.out.println("Até n2: " + dRes.getPath(n2));
		System.out.println("\tCusto: " + dRes.getCost(n2));
		System.out.println("Até n3: " + dRes.getPath(n3));
		System.out.println("\tCusto: " + dRes.getCost(n3));
		System.out.println("Até n4: " + dRes.getPath(n4));
		System.out.println("\tCusto: " + dRes.getCost(n4));
		System.out.println("Até n5: " + dRes.getPath(n5));
		System.out.println("\tCusto: " + dRes.getCost(n5));
		System.out.println("Até n6: " + dRes.getPath(n6));
		System.out.println("\tCusto: " + dRes.getCost(n6));
		System.out.println("Até n7: " + dRes.getPath(n7));
		System.out.println("\tCusto: " + dRes.getCost(n7));
		System.out.println("Até n8: " + dRes.getPath(n8));
		System.out.println("\tCusto: " + dRes.getCost(n8));

		
	}
}
