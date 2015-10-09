package acessoBanco;

import TAD.queue.Queue;

public class ControleAcesso {
	private Queue<Cliente> acima65 = new Queue<Cliente>();
	private Queue<Cliente> abaixoIgual65 = new Queue<Cliente>();
	
	public void addCliente(Cliente c)
	{
		if (c.getIdade() > 65)
			acima65.enqueue(c);
		else
			abaixoIgual65.enqueue(c);
	}
	
	public Cliente getProxCliente()
	{
		Cliente res = null;
		
		if (!acima65.isEmpty())
			res = acima65.dequeue();
		else if (!abaixoIgual65.isEmpty())
				res = abaixoIgual65.dequeue();
		
		return res;
	}
}
