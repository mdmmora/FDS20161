package TAD.list;

import java.util.Random;

public class Teste {
	public static void main(String [] argc) {
		Random rnd = new Random();

		int x ;

		for (int i = 0; i < 30; i++) {
			x = rnd.nextInt(10);
			System.out.println(x);
		}

	}

}
