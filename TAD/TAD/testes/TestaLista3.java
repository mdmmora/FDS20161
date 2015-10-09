package TAD.testes;

import TAD.*;
import TAD.list.ListDoubleLinked;
import TAD.list.ListTAD;


public class TestaLista3 {

public static void mostraLista(ListTAD <String> l)
	{
		String s;
		
		s = l.get(0);
		while (s != null)
		{
			System.out.print(s + " ");
			s = l.getNext();
		}
		
		System.out.println("");
	}
	public static void main(String[] args) {
		ListDoubleLinked <String> l = new ListDoubleLinked<String>();		

		String s1 = new String("a");
		String s2 = new String("b");
		String s3 = new String("c");
		String s4 = new String("c");
		String s5 = new String("a");
		String s6 = new String("d");
		
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		l.add(s5);
		l.add(s6);
		mostraLista(l);
		
		l.removeDup(new String("c"));
		mostraLista(l);
		
		l.removeDup(new String("d"));
		mostraLista(l);
		
		l.removeDup(new String("a"));
		mostraLista(l);

	}

}
