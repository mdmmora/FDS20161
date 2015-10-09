package TAD.testes;

public class Cliente {
	private String nome;
	private int cod;
	
	Cliente(){};
	Cliente(String n, int c)
	{
		nome = n;
		cod = c;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
