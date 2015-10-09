package TAD.testes;
import java.util.Iterator;
import java.util.List;

import TAD.trees.BinarySearchTreeRecursive;

public class TesteBinarySearchTreeRecursive {
	public static void main(String[] args) {
		BinarySearchTreeRecursive<String> t = new BinarySearchTreeRecursive<String>("K");
		t.add("D");
		t.add("M");
		t.add("B");
		t.add("F");
		t.add("C");
		
		System.out.println("Numero de nos: " + t.size());

        List<String> lista = t.traversalPre();
        System.out.println("Percurso pre-ordem: "+lista);

        lista = t.traversalPos();
        System.out.println("Percurso pos-ordem: "+lista);
        
        lista = t.traversalBreadth();
        System.out.println("Percurso em largura: "+lista);

        System.out.println("Contem F: " + t.contains("F"));
        System.out.println("Contem X: " + t.contains("X"));
        
        System.out.println("Remover X: " + t.remove("X"));
        //System.out.println("Remover C: " + t.remove("C"));
        //System.out.println("Remover B: " + t.remove("B"));
        //System.out.println("Remover D: " + t.remove("D"));
        System.out.println("Remover K: " + t.remove("K"));
        lista = t.traversalBreadth();
        System.out.println("Percurso em largura: "+lista);
	}
}
