package acessoBanco;


public class Cliente implements Comparable<Cliente>{
	private String nome;
	private int idade;
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int compareTo(Cliente c) {
		return nome.compareTo(c.getNome());
	}
	
	
}
