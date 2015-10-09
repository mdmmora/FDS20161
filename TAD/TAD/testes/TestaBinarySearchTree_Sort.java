package TAD.testes;

import java.util.Random;

import TAD.trees.BinarySearchTreeLinked;

public class TestaBinarySearchTree_Sort {
	public static void mostraVet(int [] vet){
		int quebra = 31;
		
		for (int i = 1; i < vet.length+1; i++) {
			if (i % quebra == 0)
				System.out.println("");
			
			System.out.print(vet[i-1] + " ");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] vet = new int[30];
		Random rnd = new Random();
		BinarySearchTreeLinked<Integer> tree = new BinarySearchTreeLinked<>();
		
		for (int i = 0; i < 30; i++)
			vet[i] = rnd.nextInt(100) + 1;
		
		for (int i = 0; i <30; i++)
			tree.add(vet[i]);
		
		System.out.println("O vetor:");
		mostraVet(vet);
		System.out.println("\n\nA árvore:");
		System.out.println(tree.strTraversalCentral());
	}
}
