package TAD.testes;
import TAD.*;
import TAD.list.ListSimpleLinked;
import TAD.list.ListTAD;


public class TestaLista2 {

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
		ListSimpleLinked <String> l = new ListSimpleLinked<String>();		

		String s1 = new String("a");
		String s2 = new String("b");
		String s3 = new String("c");
		String s4 = new String("d");
		String s5 = new String("e");
		String s6 = new String("b");
		
		l.add(s1);
		l.add(s2);
		l.add(s3);
		l.add(s4);
		l.add(s5);
		l.add(s6);
		mostraLista(l);
		
		System.out.println("nro de e = " + l.count("e"));
		System.out.println("nro de b = " + l.count("b"));
		
		l.reverse();
		mostraLista(l);
	}

}

