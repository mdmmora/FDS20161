package TAD.testes;
import java.util.Iterator;

import TAD.*;
import TAD.list.ListSimpleLinked;

public class TestaIteradores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ListArray<String> l = new ListArray<String>(10);
		ListSimpleLinked<String> l = new ListSimpleLinked<String>();
		
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");
		l.add("F");
		l.add("G");
		l.add("H");
		l.add("I");
		l.add("J");
		
		Iterator<String> it = l.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		for(String s:l)
			System.out.println(s);
	}

}
