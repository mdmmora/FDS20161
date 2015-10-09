package TAD.recursao;

public class RecMethods {
	public static int fibo(int n) {
		int res = 0;
		
		if (n < 0)
			res = -1;
		else if (n == 0 || n == 1)
				res = 1;
		else res = RecMethods.fibo(n-1) + RecMethods.fibo(n-2);
		
		return res;
	}
	
	public static int contaDivisivel(int n, int d) {
		int res = 0;
		
		if (d <= 0)
			res = -1;
		else if (n > 0)
				if(n % d == 0)
					res = 1 + contaDivisivel(n - 1, d);
				else
					res = contaDivisivel(n-1, d);
		
		return res;
	}
	
	private static boolean eVogal(char c) {
		boolean res = false;
		
		if (Character.toUpperCase(c) == 'A' || Character.toUpperCase(c) == 'E' ||
			Character.toUpperCase(c) == 'I' || Character.toUpperCase(c) == 'O' ||	
			Character.toUpperCase(c) == 'U')
			res = true;
		
		return res;
	}
	
	public static int contaVogais(String s) {
		int res = 0;
		
		if (s.length() > 0)
			if (eVogal(s.charAt(0)))
				res = 1 + contaVogais(s.substring(1));
			else
				res = contaVogais(s.substring(1));
			
		return res;
	}

}
