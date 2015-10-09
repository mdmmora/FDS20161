package TAD.testes;
		
import TAD.trees.*;
import java.io.*;
import java.util.*;


public class TesteArvBin2 {	
	public static void main(String[] args) {
		FileOutputStream saida = null;
		ObjectOutputStream oSaida = null;
		FileInputStream entrada = null;
		ObjectInputStream oEntrada = null;
		String [] vetStr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		BinaryTreeLinked <String> arv1 = new BinaryTreeLinked<String>();
		String res;
		List<String> resVet;
		
		String n1 = new String("'Raiz'");
		String n2 = new String("'N1 1'");
		String n3 = new String("'N1 2'");
		String n4 = new String("'N2 1'");
		String n5 = new String("'N2 2'");
		String n6 = new String("'N2 3'");
		String n7 = new String("'N2 4'");
		String n8 = new String("'N3 2'");
		String n9 = new String("'N3 7'");
		String n10 = new String("'N4 13'");
		String n11 = new String("'N4 14'");

		arv1.add(n1, null, NodePosition.LEFT);
		
		arv1.add(n2, n1, NodePosition.LEFT);
		arv1.add(n3, n1, NodePosition.RIGHT);
		
		arv1.add(n4, n2, NodePosition.LEFT);
		arv1.add(n5, n2, NodePosition.RIGHT);
		
		arv1.add(n6, n3, NodePosition.LEFT);
		arv1.add(n7, n3, NodePosition.RIGHT);
		
		arv1.add(n8, n4, NodePosition.RIGHT);
		arv1.add(n9, n7, NodePosition.LEFT);
		
		arv1.add(n10, n9, NodePosition.LEFT);
		arv1.add(n11, n9, NodePosition.RIGHT);

		System.out.println("Count");
		System.out.println(arv1.count());
		
		System.out.println("Count Leaves");
		System.out.println(arv1.countLeaves());
		
		System.out.println("Traversal Pre:");
		resVet = arv1.traversalPre();
		for (String aux:resVet)
			System.out.print(aux + " ");
		
		System.out.println("\nTraversal Pre - retorna STR \n" + arv1.strTraversalPre());

		System.out.println("\nTraversal Pos:");
		resVet = arv1.traversalPos();
		for (String aux:resVet)
			System.out.print(aux + " ");
		
		System.out.println("\nTraversal Pos - retorna STR \n" + arv1.strTraversalPos());

		System.out.println("\nTraversal Central:");
		resVet = arv1.traversalCentral();
		for (String aux:resVet)
			System.out.print(aux + " ");

		System.out.println("\nTraversal Central - retorna STR \n" + arv1.strTraversalCentral());
		
		System.out.println("\nTraversal Amplitude:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");

		System.out.println("\nTraversal Amplitude - retorna STR \n" + arv1.strTraversalWidth());
		
		System.out.println("\n\nTotal de nodos: " + arv1.count());
		System.out.println("Total de folhas: " + arv1.countLeaves());
		
		String novo = new String("'X'");
		arv1.add(novo, arv1.getRoot(), NodePosition.LEFT);
		
		System.out.println("\nTraversal Amplitude:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");		

		System.out.println("\n\nMostrando todos pelo iterador - Amplitude!!");
		Iterator it = arv1.iterator(IteratorTreeType.WIDTH);
		while (it.hasNext())
			System.out.print(" " + it.next());

		System.out.println("\n\nTraversal Pre:");
		resVet = arv1.traversalPre();
		for (String aux:resVet)
			System.out.print(aux + " ");		
		
		System.out.println("\n\nMostrando todos pelo iterador - Pre-Ordem!!");
		it = arv1.iterator(IteratorTreeType.PRE);
		while (it.hasNext())
			System.out.print(" " + it.next());

		System.out.println("\n\nTraversal Pos:");
		resVet = arv1.traversalPos();
		for (String aux:resVet)
			System.out.print(aux + " ");
		
		if (arv1.hasRepeat("'N1 1'"))
			System.out.println("\n'N1 1'" + " está repetido");
		else
			System.out.println("\n'N1 1'" + " não está repetido");
		
		arv1.add("'X'", "'N1 1'", NodePosition.LEFT);
		arv1.add("'X'", "'N1 1'", NodePosition.RIGHT);
		
		System.out.println("\nTraversal Amplitude - retorna STR \n" + arv1.strTraversalWidth());
		
		if (arv1.hasRepeat("'X'"))
			System.out.println("\n'X'" + " está repetido");
		else
			System.out.println("\n'X'" + " não está repetido");
		
		arv1.add("Y","'N3 7'", NodePosition.LEFT);
		arv1.add("Y","'N3 7'", NodePosition.RIGHT);
		System.out.print("Elementos repetidos: "+ arv1.allRepeat());
			
		try {
			saida = new FileOutputStream("teste_java_arv.dat");
			oSaida = new ObjectOutputStream(saida);
			
			oSaida.writeObject(arv1);
			oSaida.close();
			
			arv1 = null;
		}
		catch(Exception e) {
			System.out.println("\n\nErro 1: " + e.getMessage());
		}
		
		try {
			entrada = new FileInputStream("teste_java_arv.dat");
			oEntrada = new ObjectInputStream(entrada);
			
			arv1 = (BinaryTreeLinked<String>) oEntrada.readObject();
			oSaida.close();
			
			System.out.println("\nTraversal Amplitude - após ler do arquivo:");

			resVet = arv1.traversalWidth();
			for (String aux:resVet)
				System.out.print(aux + " ");		

			
		}
		catch(Exception e) {
			System.out.println("\n\nErro 2: " + e.getMessage());
		}
		
		String [] arr2 = {"A", "B", "C", "D", "E", "F", "G"};
		BinaryTreeLinked<String> arv3 = new BinaryTreeLinked<String>(arr2);
		
		System.out.println("\n\n" + arv3.strTraversalWidth());
		
		arv3.invLeftRight();
		
		System.out.println("\n\n" + arv3.strTraversalWidth());
		
	}
}
