package TAD.testes;

public class Inner {
	private class Dentro {
		private int atrib;
	}
	
	public void meuMet(){
		Dentro d = new Dentro();
		d.atrib = 666;
	}

}
