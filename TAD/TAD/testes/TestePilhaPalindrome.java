package TAD.testes;

import TAD.stack.Stack;
import TAD.stack.StackTAD;

public class TestePilhaPalindrome {

	public static boolean ehPalindrome(String s){
		boolean res = false;
		StackTAD<Character> pilha = new Stack<Character>();
		int i, ini, tam;
		char c;

		if ((s != null) && (!s.isEmpty())){
			tam = s.length();

			for(i = 0; i < tam/2; i++)
				pilha.push(s.charAt(i));

			ini = (tam % 2 == 0)?i:i+1;

			for (int j = ini; j < tam; j++) {
				c = pilha.pop();
				
				if (c != s.charAt(j))
					break;
			}
			
			res = pilha.isEmpty();
		}
		return res;
	}
	
		public static void main(String [] argc) {
			String str1 = "arara";
			String str2 = "urubu"; 
			String str3 = "papagaio";
			String str4 = "papaapap";
			String str5 = "";
			String str6 = null;
			
			System.out.println(str1 + " é palindrome? " + ehPalindrome(str1));
			System.out.println(str2 + " é palindrome? " + ehPalindrome(str2));
			System.out.println(str3 + " é palindrome? " + ehPalindrome(str3));
			System.out.println(str4 + " é palindrome? " + ehPalindrome(str4));
			System.out.println(str5 + " é palindrome? " + ehPalindrome(str5));
			System.out.println(str6 + " é palindrome? " + ehPalindrome(str6));
			
		}
}
