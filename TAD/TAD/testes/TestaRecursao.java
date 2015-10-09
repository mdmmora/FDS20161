package TAD.testes;

import TAD.recursao.RecMethods;

public class TestaRecursao {
	public static void main(String [] argc) {
		System.out.println( "Fibo de n = " + 5 + " --> " + RecMethods.fibo(5) );
		System.out.println( "Fibo de n = " + 7 + " --> " + RecMethods.fibo(7) );
		System.out.println( "Fibo de n = " + 9 + " --> " + RecMethods.fibo(9) );
		
		System.out.println("\n n = " + 100 + " e d = " + 3 + " --> " + RecMethods.contaDivisivel(100,3));
		
		System.out.println("\n vogais de " + "casario" + " --> " + RecMethods.contaVogais("casario"));
	}
}
