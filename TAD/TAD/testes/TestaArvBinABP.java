package TAD.testes;

import java.util.*;

import OldTrees.BinaryTreeABPTAD;
import OldTrees.BinaryTreeLinked;
import TAD.*;

public class TestaArvBinABP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer [] vetStr = {3, 2, 1, 7, 5, 8, 4, 12, 9, 10, 13, 6};
		BinaryTreeABPTAD <Integer> arv = new BinaryTreeLinked<Integer>("ABP", vetStr);
//		ArvBinABP <String> arv = new ArvBinABP<String>(vetStr);
		ArrayList<Integer> resVet = new ArrayList<Integer>();
		Integer res;
		

		/****************************
		 * Mostrando o conteúdo
		 */
		System.out.println("\nTraversal Central:");
		resVet = arv.traversalCentral();
		for (Integer aux:resVet)
			System.out.print(aux + " ");
		
		/****************************
		 * Testando search
		 */
		System.out.println("\nProcurando o 5:");
		res = arv.searchABP(5);
		if (res != null)
			System.out.println("Achou! -> " + res);
		else
			System.out.println("Não achou!!");

		System.out.println("\nProcurando o 13:");
		res = arv.searchABP(13);
		if (res != null)
			System.out.println("Achou! -> " + res);
		else
			System.out.println("Não achou!!");

		System.out.println("\nProcurando o 20:");
		res = arv.searchABP(20);
		if (res != null)
			System.out.println("Achou! -> " + res);
		else
			System.out.println("Não achou!!");

	}

}
