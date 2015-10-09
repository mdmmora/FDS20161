package TAD.testes;

//import OldTrees.TreeLinked;
//import OldTrees.TreeTAD;
import TAD.*;
import TAD.trees.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;


public class TestaArv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream saida = null;
		ObjectOutputStream oSaida = null;
		FileInputStream entrada = null;
		ObjectInputStream oEntrada = null;


		GeneralTreeLinked <String> arv1 = new GeneralTreeLinked<String>();
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
		String n9 = new String("I");
		String n10 = new String("J");
		String n11 = new String("K");
		
/**********************
           A
    B 		       C
  D  E 		   F      G
H		           I  J  K
***********************/

		arv1.add(n1, null);

		arv1.add(n2, n1);
		arv1.add(n3, n1);

		arv1.add(n4, n2);
		arv1.add(n5, n2);

		arv1.add(n6, n3);
		arv1.add(n7, n3);

		arv1.add(n8, n4);
		arv1.add(n9, n7);

		arv1.add(n10, n7);
		arv1.add(n11, n7);



		System.out.println("Traversal Pre:");
		System.out.println(arv1.traversalPre().toString());
		
		System.out.println("Traversal Pos:");
		System.out.println(arv1.traversalPos().toString());
		
		System.out.println("Count:");
		System.out.println(arv1.count());
		
		
		System.out.println("\nElementos Internos:");
		resVet = arv1.getInternalElelments();
		for (String aux:resVet)
			System.out.print(aux + " ");

		System.out.println("\nPath Size:");
		System.out.println("A -> " + arv1.getPathSize("A"));
		System.out.println("B -> " + arv1.getPathSize("B"));
		System.out.println("C -> " + arv1.getPathSize("C"));
		System.out.println("D -> " + arv1.getPathSize("D"));
		System.out.println("E -> " + arv1.getPathSize("E"));
		System.out.println("F -> " + arv1.getPathSize("F"));
		System.out.println("G -> " + arv1.getPathSize("G"));
		System.out.println("H -> " + arv1.getPathSize("H"));
		System.out.println("I -> " + arv1.getPathSize("I"));
		System.out.println("J -> " + arv1.getPathSize("J"));
		System.out.println("K -> " + arv1.getPathSize("K"));

	}
}
