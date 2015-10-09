package OldTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.io.Serializable;

import TAD.list.ListSimpleLinked;
import TAD.list.ListTAD;


public class TreeLinked<D extends Comparable<D>> implements TreeTAD<D>, Serializable {
	
	class Nodo<E extends Comparable<E>> implements Comparable<Nodo<E>>, Serializable {
		private Nodo<E> pai = null;
		private E valor = null;
		private ListTAD<Nodo<E>> filhos = new ListSimpleLinked<Nodo<E>>();
		
		public Nodo<E> getPai() {
			return pai;
		}
		public void setPai(Nodo<E> pai) {
			this.pai = pai;
		}
		public E getValor() {
			return valor;
		}
		public void setValor(E valor) {
			this.valor = valor;
		}		
		
		public void addChild(Nodo<E> d)
		{
			filhos.add(d);
		}
		
		public int getQtdeChildren()
		{
			return filhos.size();
		}
		
		public Nodo<E> getChild(int pos)
		{
			Nodo res = null;
			
			if ((pos >= 0) && (pos < getQtdeChildren()))
				res = filhos.get(pos);
			
			return res;
		}
		@Override
		public int compareTo(Nodo<E> arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	private int qtde = 0;
	private Nodo<D> refRaiz = null;
	private Nodo<D> corrente = null;
	private List <Nodo<D>> lCor;
	
	public void add(D d, D pos) {
		Nodo novo, nAux;
		
			novo = new Nodo<D>();
			novo.setValor(d);
			qtde++;
			corrente = novo;
			
			if (pos == null)
			{
				novo.setPai(null);
	
				if (refRaiz != null)
				{
					novo.addChild(refRaiz);
					refRaiz.setPai(novo);
				}
				
				refRaiz = novo;
			}
			else
			{
				nAux = searchNodoRef(pos, refRaiz);
				
				if (nAux != null)
				{
					novo.setPai(nAux);

					nAux.addChild(novo);
				}
			}
	}

	public void addCurrent(D d) {
		// TODO Auto-generated method stub
		
	}

	private Nodo<D> searchNodoRef(D d, Nodo<D> n)
	{
		int i;
		Nodo<D> res = null;
		
		if (n != null)
			if (d == n.getValor())
				res = n;
			else
				for (i = 0; (i < n.getQtdeChildren() &&
				            (res = searchNodoRef(d, n.getChild(i))) == null); i++);

		corrente = res;
		return res;		
	}
	
	public int count()
	{
		return countAux(refRaiz);
	}

	private int countAux(Nodo<D> n)
	{
		int res = 0;
		int i;
		
		if (n != null)
		{
			res = 1;
			
			for (i = 0; i < n.getQtdeChildren(); i++)
				res += countAux(n.filhos.get(i));
		}
		
		return res;
	}
	
	public int countLeaves()
	{
		return countLeavesAux(refRaiz);
	}

	private int countLeavesAux(Nodo<D> n)
	{
		int res = 0;
		int i;
		
		if (n != null)
		{
			if (n.getQtdeChildren() > 0)
				for (i = 0; i < n.getQtdeChildren(); i++)
					res += countAux(n.filhos.get(i));
			else
				res = 1;
		}
		
		return res;
	}

	public D getCurrent() {
		D res= null;
		
		if (corrente != null)
			res = corrente.getValor();
		
		return res;
	}

	public D getChild(int index) {

		D res = null;
		
		if (corrente != null)
			if ((index >= 0) && (index < corrente.getQtdeChildren()))
			{
				corrente = corrente.filhos.get(index);
				res = corrente.getValor();
			}
		
		return res;
	}

	public void initGetNext() {
		// TODO Auto-generated method stub
		
	}
	
	public D getNextPre() {
		// TODO Auto-generated method stub
		return null;
	}

	public D getPai() {
		D res = null;
		
		if (corrente != null)
		{
			corrente = corrente.getPai();
			if (corrente != null)
				res = corrente.getValor();
		}
		
		return res;
	}

	public D getRoot() {
		D res = null;
		
		corrente = refRaiz;
		
		if (corrente != null)
			res = corrente.getValor();
		
		return res;
	}

	public boolean isEmpty() {
		boolean res;
		
		if (refRaiz == null)
			res = true;
		else
			res = false;
		
		return res;
	}

	public void removeBranch(D pos) {
		Nodo<D> nAux = null, pai = null;
		int i, qtdAux;
		
		if (refRaiz != null)
			if (refRaiz.getValor() == pos)
			{
				refRaiz = null;
				qtde = 0;
				corrente = null;
			}
			else 
			{
				nAux = searchNodoRef(pos, refRaiz);
				
				if (nAux != null)
				{
					qtdAux = countAux(nAux);
					pai = nAux.getPai();
					
					for (i = 0; ((i < pai.getQtdeChildren()) &&
								 (pai.filhos.get(i) != nAux)); i++);
					pai.filhos.remove(i);				
					
					corrente = pai;
					qtde = qtdAux;
				}
			}
	}

	public D removeOcurrence(D d) {
		// TODO Auto-generated method stub
		return null;
	}

	public D search(D d)
	{
		Nodo<D> nAux;
		D res = null;
		
		nAux = searchNodoValue(d, refRaiz);
		
		if (nAux != null)
			res = nAux.getValor();
		
		return res;
	}

	private Nodo<D> searchNodoValue(D d, Nodo<D> n)
	{
		Nodo<D> res = null;
		int i;
		
		if (n != null)
		   if (d.compareTo(n.getValor()) == 0)
			     res = n;
		     else 
		          for (i = 0; ((i < n.getQtdeChildren()) &&
		        		  	   ( (res = searchNodoValue(d, n.filhos.get(i))) == null) ); i++);
		        	  
		corrente = res;
		return res;
	}

	public D searchIterFirst(D d) {
		// TODO Auto-generated method stub
		return null;
	}

	public D searchIterNext() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Vector<D> traversalPos()
	{
		Vector<D> res = new Vector<D>(this.size());
		
		traversalPosAux(refRaiz, res);
		corrente = refRaiz;
		
		return res;
	}
	
	private void traversalPosAux(Nodo<D> n, Vector<D> res)
	{
		int i;
		if (n != null)
		{
			for (i = 0; i < n.getQtdeChildren(); i++)
				traversalPosAux(n.getChild(i), res);

			res.add(n.getValor());
		} 
	}

	public Vector<D> traversalPre() {
		Vector<D> res = new Vector<D>(this.size());
		
		traversalPreAux(refRaiz, res);
		corrente = refRaiz;
		
		return res;
	}
	
	private void traversalPreAux(Nodo<D> n, Vector<D> res)
	{
		int i;
		if (n != null)
		{
			res.add(n.getValor());
			
			for (i = 0; i < n.getQtdeChildren(); i++)
				traversalPreAux(n.getChild(i), res);
		} 
	}

	public Vector<D> traversalWidth()
	{
		LinkedList <Nodo<D>> fila = new LinkedList<Nodo<D>>();
		Nodo<D> atual = null;
		Vector <D> res = new Vector<D>(this.size());

		if (refRaiz != null)
		{
			int i; 
			
			fila.add(refRaiz);
			
			while (! fila.isEmpty())
			{
				atual = fila.remove(0);
				
				for (i = 0; i < atual.getQtdeChildren(); i++)
					fila.add(atual.getChild(i));				

				res.add(atual.getValor());				
			}
		}
		
		corrente = refRaiz;
		return res;
	}
	
	public String strTraversalPre()
	{
		return strTraversalPre(refRaiz);
	}
	
	private String strTraversalPre(Nodo<D> n)
	{
		String res = "";
		int i;
		
		if (n != null)
		{
			res = n.getValor().toString() + "\n";
			for (i = 0; i < n.getQtdeChildren(); i++)
				res = res + strTraversalPre(n.getChild(i));
		}
		
		return res;
	}
}
