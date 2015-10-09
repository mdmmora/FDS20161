package TAD.testes;
import TAD.trees.GeneralTreeLinked;
import TAD.trees.GeneralTreeTAD;


public class TesteGeneralTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GeneralTreeLinked<String> arvore = new GeneralTreeLinked<String>();
		arvore.add("A", null);
		arvore.add("B", "A");
		arvore.add("C", "A");
		arvore.add("D", "A");
		arvore.add("E", "B");
		arvore.add("F", "B");
		arvore.add("G", "D");
		arvore.add("H", "D");
		arvore.add("I", "E");		
		arvore.add("J", "E");
		arvore.add("K", "E");
		arvore.add("L", "E");
		arvore.add("M", "F");
		arvore.add("N", "G");
		arvore.add("O", "G");
		arvore.add("P", "H");
		arvore.add("Q", "H");
		arvore.add("R", "H");
		
		System.out.println("To String \n" + arvore.toString());
		System.out.println(arvore.count());
		System.out.println("Pre-ordem:" + arvore.traversalPre());
		System.out.println("Pos-ordem:" + arvore.traversalPos());
		System.out.println("Largura:" + arvore.traversalWidth());
		
		System.out.println("Amplitude com iterador: ");
		for (String s:arvore) 
			System.out.print(s + " ");
		System.out.println("");
		
		System.out.println(arvore.getFather("F"));
		System.out.println(arvore.getRoot());
		System.out.println(arvore.get("A", 2));
		arvore.setRoot("X");
		arvore.set("E", "Y");
		System.out.println("Pre-ordem:" + arvore.traversalPre());
		arvore.removeBranch("B");
		System.out.println("Pre-ordem:" + arvore.traversalPre());
		System.out.println(arvore.count());
		System.out.println(arvore.countBiggerThan("D"));
	}

}
