package OldTrees;
import java.util.*;
import java.io.Serializable;

/**
 * Implementação do TAD Árvore Binária, descrito na interface TADArvBin. Veja a descrição
 * dos métodos públicos na inteface.
 * @author Michael Mora
 * @param <D> Classe dos dados que serão armazenados nos nodos da árvore.
 */
public class BinaryTreeLinked <D extends Comparable<D>> implements BinaryTreeTAD<D>, BinaryTreeABPTAD<D>, Serializable  {
	class Nodo  implements Serializable {
		private Nodo father = null;
		private Nodo left = null;
		private Nodo right = null;
		private D elem = null;
		
		public Nodo getRight() {
			return right;
		}
		public void setRight(Nodo dir) {
			this.right = dir;
		}
		public Nodo getLeft() {
			return left;
		}
		public void setLeft(Nodo esq) {
			this.left = esq;
		}
		public Nodo getFather() {
			return father;
		}
		public void setFather(Nodo fth) {
			this.father = fth;
		}
		public D getElem() {
			return elem;
		}
		public void setElem(D valor) {
			this.elem = valor;
		}		
	}

	private int qtd = 0;
	private Nodo refRoot = null;
	private Nodo refCurrent = null;
	private List <Nodo> lCor;
	
	public BinaryTreeLinked() {}
	
	public BinaryTreeLinked(D [] vet)
	{
		List <Nodo> fila = new LinkedList<Nodo>();
		int i;
		Nodo novo = null, primeiro = null;
		String pos = null;
		
		qtd = vet.length;
		if (vet.length > 0)
		{
			novo = new Nodo();
			novo.setElem(vet[0]);
			refRoot = novo;
					
			fila.add(0, novo);
			pos = "esq";
			
			for(i = 1; i < vet.length; i++)
			{
				novo = new Nodo();
				novo.setElem(vet[i]);
				fila.add(novo);
				
				primeiro = fila.get(0);
				novo.setFather(primeiro);
				
				if (pos.equals("esq"))
				{
					primeiro.setLeft(novo);
					pos = "dir";
				}
				else
				{
					primeiro.setRight(novo);
					fila.remove(0);
					pos = "esq";
				}		
			}
		}
	}

	public BinaryTreeLinked(String ABP, D [] vet)
	{
		if(ABP.equals("ABP"))
			for (D aux:vet)
				addABP(aux);
	}
	
	public boolean isEmpty()
	{
		if (refRoot == null)
			return true;
		else
			return false;
	}

	public int size()
	{
		return qtd;
	}

	public void add(D d, D pos, String lado)
	{
		Nodo novo, nAux;
		if ((lado.equalsIgnoreCase("e")) || (lado.equalsIgnoreCase("d")))
		{
			novo = new Nodo();
			novo.setElem(d);
			qtd++;
			if (pos == null)
			{   if (lado.equalsIgnoreCase("e"))
					novo.setLeft(refRoot);
				else 
					novo.setRight(refRoot);
				if (refRoot != null)
					refRoot.setFather(novo);
				refRoot = novo;	}
			else
			{	nAux = searchNodoRef(pos, refRoot);
				if (nAux != null)
				{	novo.setFather(nAux);
					if (lado.equalsIgnoreCase("e"))
					{	novo.setLeft(nAux.getLeft());
						if (nAux.getLeft() != null)
							nAux.getLeft().setFather(novo);
						nAux.setLeft(novo);	}
					else 
					{	novo.setRight(nAux.getRight());
						if (nAux.getRight() != null)
							nAux.getRight().setFather(novo);
						nAux.setRight(novo);
					}
				}
			}
		}
	}

	public void addCurrent(D d, String lado)
	{
		Nodo novo;
		if ((lado.equalsIgnoreCase("e")) || (lado.equalsIgnoreCase("d")))
		{
			novo = new Nodo();
			novo.setElem(d);
			qtd++;

			if (refCurrent != null)
			{
				novo.setFather(refCurrent);
				if (lado.equalsIgnoreCase("e"))
				{
					novo.setLeft(refCurrent.getLeft());
					if (refCurrent.getLeft() != null)
						refCurrent.getLeft().setFather(novo);
					refCurrent.setLeft(novo);
				}
				else 
				{
					novo.setRight(refCurrent.getRight());
					if (refCurrent.getRight() != null)
						refCurrent.getRight().setFather(novo);
					refCurrent.setRight(novo);
				}
				
				refCurrent = novo;
			}
		}
	}

	public D removeOcurrence(D d)
	{
		D res = null;
		
		return res;
	}
	
	public void removeBranch(D pos)
	{
		Nodo nAux = null, pai = null;
		int qtdAux;
		
		if (refRoot != null)
			if (refRoot.getElem() == pos)
			{
				refRoot = null;
				qtd = 0;
				refCurrent = null;
			}
			else 
			{
				nAux = searchNodoRef(pos, refRoot);
				
				if (nAux != null)
				{
					qtdAux = count(nAux);
					pai = nAux.getFather();
					refCurrent = pai;
					
					if (pai.getLeft() == nAux)
						pai.setLeft(null);
					else if (pai.getRight() == nAux)
						pai.setRight(null);
					
					qtd -= qtdAux;
				}
			}
	}
	
	public D get()
	{
		D res = null;
		
		if (refCurrent != null)
			res = refCurrent.getElem();
		
		return res;
	}

	public D getLeft()
	{
		D res = null;
		
		if (refCurrent != null)
			if (refCurrent.getLeft() != null)
			{
				refCurrent = refCurrent.getLeft();
				res = refCurrent.getElem();
			}
		
		return res;
	}

	public D getRight()
	{
		D res = null;
		
		if (refCurrent != null)
			if (refCurrent.getRight() != null)
			{
				refCurrent = refCurrent.getRight();
				res = refCurrent.getElem();
			}
		
		return res;
	}
	
	public D getFather()
	{
		D res = null;
		
		if (refCurrent != null)
			if (refCurrent.getFather() != null)
			{
				refCurrent = refCurrent.getFather();
				res = refCurrent.getElem();
			}
		
		return res;
	}
	
	public D getRoot()
	{
		D res = null;
		
		if (refRoot != null)
		{
			refCurrent = refRoot;
			res = refCurrent.getElem();
		}
		
		return res;
	}
	
	public void initGetNext()
	{
		lCor = new LinkedList<Nodo>();
		
		if (refRoot != null)
		{
			lCor.add(0,refRoot);
			refCurrent = refRoot;
		}
		else
			refCurrent = null;
	}

	public D getNextPre()
	{
		D res = null;
		Nodo nAux = null;
		
		if (! lCor.isEmpty())
		{
			nAux = lCor.remove(0);
			refCurrent = nAux;
			res = refCurrent.getElem();
			
			if (nAux.getRight() != null)
				lCor.add(0, nAux.getRight());
			if (nAux.getLeft() != null)
				lCor.add(0, nAux.getLeft());
		}
		else
			refCurrent = null;
	
		return res;
	}

	public D search(D d)
	{
		Nodo nAux;
		D res = null;
		
		nAux = searchNodoValue(d, refRoot);
		
		if (nAux != null)
			res = nAux.getElem();
		
		return res;
	}

	private Nodo searchNodoValue(D d, Nodo n)
	{
		Nodo res = null;
		
		if (n != null)
		   if (d.compareTo(n.getElem()) == 0)
			     res = n;
		     else 
		          {
			       res = searchNodoValue(d, n.getLeft());
			       if (res == null)
			    	   res = searchNodoValue(d, n.getRight());
		          }
		refCurrent = res;
		return res;
	}

	public D searchIterFirst(D d)
	{
		D res = null;
		
		lCor = new LinkedList<Nodo>();
		lCor.add(refRoot);
	
		res = searchIterAux(d);
		return res;
	}

	public D searchIterNext()
	{
		D res = null, d;
		
		if (refCurrent != null)
		{
			d = refCurrent.getElem();
			res = searchIterAux(d);
		}
		
		return res;
	}

	private D searchIterAux(D d)
	{
		D res = null;
		Nodo nAux = null;
		
		while((! lCor.isEmpty()) &&
			  (d.compareTo(lCor.get(0).getElem())) != 0)
		{
			nAux = lCor.remove(0);
			
			if (nAux.getLeft() != null)
				lCor.add(0, nAux.getLeft());
			if (nAux.getRight() != null)
				lCor.add(0, nAux.getRight());
		}
		
		if (! lCor.isEmpty())
		{
			refCurrent = lCor.remove(0);
			res = refCurrent.getElem();
			
			if (refCurrent.getLeft() != null)
				lCor.add(0, refCurrent.getLeft());
			if (refCurrent.getRight() != null)
				lCor.add(0, refCurrent.getRight());
		}
		else
			refCurrent = null;
	
		return res;
	}

	private Nodo searchNodoRef(D d, Nodo n)
	{
		Nodo res = null;
		
		if (n != null)
		   if (d == n.getElem())
			     res = n;
		     else 
		          {
			       res = searchNodoRef(d, n.getLeft());
			       if (res == null)
			    	   res = searchNodoRef(d, n.getRight());
		          }
		refCurrent = res;
		return res;		
	}

	public int count()
	{		return count(refRoot);	}

	private int count(Nodo n)
	{
		int res = 0;
		
		if (n != null)
			res = 1 + count(n.getLeft()) +
					  count(n.getRight());
		
		return res;
	}

	public int countLeaves()
	{	return countLeaves(refRoot);	}

	private int countLeaves(Nodo n)
	{
		int res = 0;
		
		if (n != null)
		{
			if ((n.getLeft() == null) &&
			   (n.getRight() == null))
				res = 1;
			else 
				res = countLeaves(n.getLeft()) +
					  countLeaves(n.getRight());
		}
		
		return res;
	}
		
	public ArrayList<D> traversalPre()
	{
		ArrayList<D> res = new ArrayList<D>(this.size());
		
		traversalPreAux(refRoot, res);
		refCurrent = refRoot;
		
		return res;
	}
	
	private void traversalPreAux(Nodo n, ArrayList<D> res)
	{
		if (n != null)
		{
			res.add(n.getElem());
			
			traversalPreAux(n.getLeft(), res);
			traversalPreAux(n.getRight(), res);
		} 

	}

	public ArrayList<D> traversalPos()
	{
		ArrayList<D> res = new ArrayList<D>(this.size());
		
		traversalPosAux(refRoot, res);
		refCurrent = refRoot;
		
		return res;
	}
	
	private void traversalPosAux(Nodo n, ArrayList<D> res)
	{
		if (n != null)
		{
			traversalPosAux(n.getLeft(), res);
			traversalPosAux(n.getRight(), res);
			res.add(n.getElem());
		} 

	}
	
	public ArrayList<D> traversalCentral()
	{
		ArrayList<D> res = new ArrayList<D>(this.size());
		
		traversalCentralAux(refRoot, res);
		refCurrent = refRoot;
		
		return res;
	}
	
	private void traversalCentralAux(Nodo n, ArrayList<D> res)
	{
		if (n != null)
		{
			traversalCentralAux(n.getLeft(), res);
			res.add(n.getElem());
			traversalCentralAux(n.getRight(), res);
		} 

	}
	
	public ArrayList<D> traversalWidth()
	{
		LinkedList <Nodo> fila = new LinkedList<Nodo>();
		Nodo atual = null;
		ArrayList <D> res = new ArrayList<D>(this.size());

		if (refRoot != null)
		{
			fila.add(refRoot);
			while (! fila.isEmpty())
			{
				atual = fila.remove(0);
				
				if (atual.getLeft() != null)
					fila.add(atual.getLeft());				
				if (atual.getRight() != null)
					fila.add(atual.getRight());

				res.add(atual.getElem());				
			}
		}
		
		refCurrent = refRoot;
		return res;
	}

	public void addABP(D d)
	{
		Nodo novo; 
		
		if (refRoot == null)
		{
			novo = new Nodo();
			novo.setElem(d);
			novo.setFather(null);
			novo.setLeft(null);
			novo.setRight(null);
			
			refRoot = novo;
			refCurrent = novo;
		}
		else 
			addABPAux(d, refRoot);
	}
	
	private void addABPAux(D d, Nodo n)
	{
		Nodo novo;
		
		if (n != null)
		{
			if (d.compareTo(n.getElem()) < 0)
				if (n.getLeft() != null)
					addABPAux(d, n.getLeft());
				else
				{
					novo = new Nodo();
					novo.setElem(d);
					novo.setFather(n);
					novo.setLeft(null);
					novo.setRight(null);
					
					n.setLeft(novo);
					refCurrent = novo;
				}
			else 
			{
				if (n.getRight() != null)
						addABPAux(d, n.getRight());
				else
				{
					novo = new Nodo();
					novo.setElem(d);
					novo.setFather(n);
					novo.setLeft(null);
					novo.setRight(null);
					
					n.setRight(novo);
					refCurrent = novo;
				}
			}
		}

	}

	public D searchABP(D d)
	{
		Nodo nAux;
		D res = null;
		
		nAux = searchNodoValueABP(d, refRoot);
		
		if (nAux != null)
			res = nAux.getElem();
		
		return res;
	}

	private Nodo searchNodoValueABP(D d, Nodo n)
	{
		Nodo res = null;
		
		if (n != null)
		   if (d.compareTo(n.getElem()) == 0)
			   res = n;
		   else if (d.compareTo(n.getElem()) < 0)
			   		res = searchNodoValueABP(d, n.getLeft());
		   else res = searchNodoValueABP(d, n.getRight());
		
		refCurrent = res;
		return res;
	}
	
	public String strTraversalPre()
	{
		return strTraversalPre(refRoot);
	}

	private String strTraversalPre(Nodo n)
	{
		String res = "";
		if (n != null)
		{
			res = n.getElem().toString() + "\n" +
				  strTraversalPre(n.getLeft()) +
				  strTraversalPre(n.getRight());
		}
		
		return res;
	}
	
	public String strTraversalPos()
	{
		return strTraversalPos(refRoot);
	}

	private String strTraversalPos(Nodo n)
	{
		String res = "";
		if (n != null)
		{
			res = strTraversalPos(n.getLeft()) +
				  strTraversalPos(n.getRight()) +
				  n.getElem().toString() + "\n";
		}
		
		return res;
	}
	
	public String strTraversalCentral()
	{
		return strTraversalCentral(refRoot);
	}

	private String strTraversalCentral(Nodo n)
	{
		String res = "";
		if (n != null)
		{
			res = strTraversalCentral(n.getLeft()) +
			      n.getElem().toString() + "\n" +
				  strTraversalCentral(n.getRight());

		}
		
		return res;
	}
}
