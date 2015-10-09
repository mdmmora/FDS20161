package TAD.testes;
import OldTrees.BinaryTreeLinked;
import TAD.list.ListSimpleLinked;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class TestaOldArvBin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream saida = null;
		ObjectOutputStream oSaida = null;
		FileInputStream entrada = null;
		ObjectInputStream oEntrada = null;

		String [] vetStr = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
		BinaryTreeLinked <String> arv = new BinaryTreeLinked<String>(vetStr);
		BinaryTreeLinked <String> arv1 = new BinaryTreeLinked<String>();
		String res;
		List<String> resVet;
		
		String n1 = new String("A");
		String n2 = new String("B");
		String n3 = new String("C");
		String n4 = new String("D");
		String n5 = new String("E");
		String n6 = new String("F");
		String n7 = new String("G");
		String n8 = new String("H");
		String n9 = new String("A");
		String n10 = new String("B");
		String n11 = new String("C");

		
		arv1.add(n1, null, "E");
		
		arv1.add(n2, n1, "E");
		arv1.add(n3, n1, "D");
		
		arv1.add(n4, n2, "E");
		arv1.add(n5, n2, "D");
		
		arv1.add(n6, n3, "E");
		arv1.add(n7, n3, "D");
		
		arv1.add(n8, n4, "D");
		arv1.add(n9, n7, "E");
		
		arv1.add(n10, n9, "E");
		arv1.add(n11, n9, "D");

/*		System.out.println("Mostrando todos pelo Mostra!!");
		arv.mostraWidth();
		System.out.println("");
		arv.mostraPre();
		System.out.println("");
		arv.mostraPos();
		System.out.println("");
		arv.mostraCentral();
		System.out.println("");*/

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

		System.out.println("\nTraversal Amplitude:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");

		System.out.println("\n\nTotal de nodos: " + arv1.count());
		System.out.println("Total de folhas: " + arv1.countLeaves());
		
		String novo = new String("1");
		arv.add(novo, arv1.getRoot(), "E");
		System.out.println("\nTraversal Amplitude:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");		

		System.out.println("\n\nMostrando todos pelo iterador - search(\"A\")!!");
		res = arv1.searchIterFirst("A");
		while (res != null)
		{
			System.out.print(" " + res);
			res = arv1.searchIterNext();
		}
		
		System.out.println("\n\nMostrando TODOS pelo iterador!!");
		arv1.initGetNext();
		
		res = arv1.getNextPre();
		while (res != null)
		{
			System.out.print(" " + res);
			res = arv1.getNextPre();
		}
		

		System.out.println("\nTraversal Amplitude - antes do addCurrent:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");		
		
		res = arv1.search("B");
		arv1.addCurrent(new String("X"), "E");
		
		System.out.println("\nTraversal Amplitude - após addCurrent:");
		resVet = arv1.traversalWidth();
		for (String aux:resVet)
			System.out.print(aux + " ");	
				
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
		
		
		
	}
}
