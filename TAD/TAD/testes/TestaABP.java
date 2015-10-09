package TAD.testes;
import TAD.list.ListSimpleLinked;
import TAD.trees.BinarySearchTreeLinked;

public class TestaABP
{
	public static void exibeOrdenado(ListSimpleLinked<String> lista) {
		BinarySearchTreeLinked<String> abp = new BinarySearchTreeLinked<String>();
		for(int i=0; i<lista.size();i++)
			abp.addRec(lista.get(i));
		System.out.println(abp.strTraversalCentral());
	}
	
    public static void main(String args[])
    {
    	BinarySearchTreeLinked<String> abp = new BinarySearchTreeLinked<String>();
        String n1 = new String("M");
        String n2 = new String("O");
        String n3 = new String("P");
        String n4 = new String("C");
        String n5 = new String("D");
        String n6 = new String("A");
        String n7 = new String("N");
        String n8 = new String("L");        
        abp.addRec(n1);
        abp.addRec(n2);
        abp.addRec(n3);
        abp.addRec(n4);
        abp.addRec(n5);
        abp.addRec(n6);
        abp.addRec(n7);
        abp.addRec(n8);
        System.out.println("Altura inicial = "+ abp.height());        
        System.out.println("Raiz =" + abp.getRoot());
        System.out.println(abp.strTraversalCentral());
        
        abp.set("P", "R");
        System.out.println("Após trocar P por R: ");
        System.out.println(abp.strTraversalCentral());
        
        abp.remove(n4);
        System.out.println("Após exclusão: ");
        System.out.println(abp.strTraversalCentral());
        System.out.println("Altura final = "+ abp.height());
        
        ListSimpleLinked<String> lista = new ListSimpleLinked<String>();
        lista.add("uva");
        lista.add("maça");
        lista.add("ave");
        lista.add("casa");
        lista.add("pato");
        lista.add("rato");
        lista.add("jaca");
        System.out.println("\nLista ordenada pela árvore"); 
        exibeOrdenado(lista);
    }    
}
