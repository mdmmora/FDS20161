package TAD.list;
import java.io.Serializable;
import java.util.Iterator;

import TAD.list.ListSimpleLinked.Node;

//
// Falta implementar um atributo refTail
//
public class ListDoubleLinked <D extends Comparable<D>> implements ListTAD<D>, Serializable {

	private class Node<E>  implements Serializable {

	    private Node<E> next;
	    private Node<E> prev;
	    private E item;

	    public void setNext(Node<E> no) 
	    	{ next = no; }
	 
	    public Node<E> getPrev() 
	    	{ return prev; }
	    
	    public void setPrev(Node<E> no) 
	    	{ prev = no; }
	    
	    public Node<E> getNext() 
	    	{ return next; }
	    
	    public void setItem(E o) 
	    	{ item = o; }
	    
	    public E getItem() 
	    	{ return item; }
	}
	
    private Node<D> refHead;
    private Node<D> refTail;
    private Node<D> current;
    private int qtdElem = 0;

    public int size() 
    	{ return qtdElem; }    
   
    public void add(int index, D element)
    {
    	Node<D> aux, novo, prox;
    	int i;
    	
    	if ((index >= 0) && (index <= qtdElem)) //**Posição é válida?
    	{
    		novo = new Node<D>();		//**Instancia novo nodo
    		novo.setItem(element);
    		
    		if (index == 0)				//** Deve ser o primeiro da Lista?
    		{
    			if (refHead != null)    //** Lista está vazia?
    				refHead.setPrev(novo);   //** Atual primeiro referencia novo primeiro como anterior
    			else
    				refTail = novo;     	 //** Senão será o primeiro e o último
    			
    			novo.setNext(refHead);  //** Novo primeiro referencia atual primeiro como próximo
    			novo.setPrev(null);
    			refHead = novo;         //** Atualiza referência de primeiro da lista
    		}
    		else 
    		{		
    			if (index != qtdElem)   //** Novo nodo não será último?
    			{
    				aux = refHead;		
        			for (i = 1; i < index; i++)		//**  Procura o elemento da posição desejada
        				aux = aux.getNext();
        									//** Aux referencia o nodo que será o anterior ao novo
    				prox = aux.getNext();   //** Prox referencia o nodo seguinte ao novo
    				prox.setPrev(novo);		//** Faz o nodo seguinte ao novo referenciar o novo como anterior
    			}
    			else     //**  Nodo será o último
    			{
    				aux = refTail;  //**  Aux referencia o último nodo
    				prox = null;    //**  O novo nodo não terá um nodo seguinta (será o último)
    				refTail = novo; //**  O novo nodo passa a ser o último
    			}
    								//** Ajusta os encadeamentos
    			aux.setNext(novo);		//**o anterior referencia o novo como next
    			novo.setPrev(aux);		//**o novo referencia o anterior como prev
    			novo.setNext(prox);		//**o novo referencia o seguinte como prev
    		}
    		
    		qtdElem++;			//** atualiza quantidade de elementos
    		current = novo;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    }
        
    public void add(D d) 
    {
    	Node<D> novo = new Node<>();
    	
    	novo.setItem(d);
    	if (refHead == null)
    		refHead = refTail = novo;
    	else {
    		refTail.setNext(novo);
    		novo.setPrev(refTail);
    		refTail = novo;
    	}
    	
    	qtdElem++;
    }

    public void set(int index, D element){
    	Node<D> aux;
    	int i;
    	
        if ((index >= 0) && (index < qtdElem))
    	   if(refHead != null) 
    	      {
               aux = refHead;
               for(i = 1 ; i <= index; i++)
                  aux = aux.getNext();
            
               aux.setItem(element);
               
               current = aux;
              }
    	   else;
        else 
        	throw new IndexOutOfBoundsException();
    }    
    
    public D get(int pos){
    	D res = null;
    	Node<D> aux;
    	int i;
    	
        if ((pos >= 0) && (pos < qtdElem))
    	   if(refHead != null) 
    	      {
               aux = refHead;
               for(i = 1 ; i <= pos; i++)
                  aux = aux.getNext();
            
               res = aux.getItem();
               
               current = aux;
              }
    	   else;
        else
        	throw new IndexOutOfBoundsException();
        
        return res;
    }
 
    public D getNext() {
    	D res = null;
    	
        if(current != null) 
          {
        	current = current.getNext();
        	if (current != null)
                res = current.getItem();
          }
        
        return res;
    }
        
    public D getPrev() {
    	D res = null;
    	
        if(current != null) 
          {
        	current = current.getPrev();
        	if (current != null)
                res = current.getItem();
          }
        
        return res;
    }
        
    public boolean isEmpty() {
    	boolean res;
    	
        if(refHead == null) 
        	res = true;
        else 
        	res = false;
        
        return res;
    }        
   
    public D remove(int index) {
    	Node<D> aux, ant, prox;
    	D auxD = null;
    	int i;
    	
    	if ((index >=0) && (index < qtdElem))
    	{
    		if (index == 0)
    		{
    			auxD = refHead.getItem();
    			refHead = refHead.getNext();
    			if (refHead != null)
    			    refHead.setPrev(null);
    			else
    				refTail = null;
    		}
    		else
    		{
    			if (index != (size() - 1))
    				{
    				aux = refHead;
        			
    				for (i = 1; i <= index; i++)
        				aux = aux.getNext();
    				}
    			else 
    				{
    				aux = refTail;
    				refTail = aux.getPrev();
    				}
    			
    			auxD = aux.getItem();
    			ant = aux.getPrev();
    			prox = aux.getNext();
    			
    			ant.setNext(prox);
    			
    			if (prox != null)
    				prox.setPrev(ant);
    		}
    		
    		qtdElem --;
    		current = null;
    	}
    	else
    		throw new IndexOutOfBoundsException();
    return auxD;
    }
    @Override
    public D remove(D element) {
    	D res = null;
		Node<D> aux, ant; 
		
		ant = aux = refHead;
		while(aux != null && !aux.getItem().equals(element)) {
			ant = aux;
			aux = aux.getNext();
		}
		
		if (aux != null) {
			res = aux.getItem();
			qtdElem--;
			
			if (qtdElem == 0)
				refHead = refTail = null;
			else {
				  if (aux == refHead) 
					  refHead = refHead.getNext();
				  else
					  ant.setNext(aux.getNext());
				
				  if (aux == refTail)
					  refTail = ant;
			}
		}
		
		//return res;
		// para forçar o erro. Devo atualizar Prev
		// e expandir o Test para garantir links para 
		// trás (via iteradores, em todas as implementações.
		// Revisar os testesCase para garantir que cada
		// alteração preserva integridade, inclusive das
		// estruturas internas.
		return null;
    }
        
    public D search(D ob)
    {
    	Node<D> aux;
    	D res = null;
    	
    	aux = refHead;
    	while ((aux != null) && (aux.getItem().equals(ob) != true))
    		aux = aux.getNext();
    	
    	if (aux != null)
    		res = aux.getItem();
  		current = aux;
    	
    	return res;
    }
    
    public D searchNext()
    {
    	D dadoCorrente = null, res = null;
    	Node<D> aux;
    	
    	if (current != null)
    	   {
    		dadoCorrente = current.getItem();
    		
    		aux = current;
        	while ((aux != null) && (aux.getItem().equals(dadoCorrente) != true))
        		aux = aux.getNext();
        	
        	if (aux != null)
        		res = aux.getItem();
      		current = aux;
    	   }
    	   
    	return res;
    }
    
    public void removeDup(D dado)
    {
    	Node<D> aux = null;
    	Node<D> prox = null;
    	
    	aux = refHead;
    	
    	while ((aux != null) && !dado.equals(aux.getItem()))
    		aux = aux.getNext();
    	
    	if (aux != null)
    	{
    		aux = aux.getNext();
    		while(aux != null)
    		{
    			if (dado.equals(aux.getItem()))
    			{
    				prox = aux.getNext();
    				
    				aux.getPrev().setNext(aux.getNext());
    				if (prox != null)
    					aux.getNext().setPrev(aux.getPrev());
    				
    				aux = prox;
    			}
    			else
    				aux = aux.getNext();
    		}
    	}
    }
    
    public void removeAll()
    {
    	refHead = refTail = current = null;
    	qtdElem = 0;
    }

	public void addFirst(D d) {
		this.add(0, d);
	}

	public void addLast(D d) {
		this.add(d);
	}

	public void clean() {
		refHead = refTail = null;
		qtdElem = 0;
	}

	public int count(D dado) {
		{
			int cont = 0;
			Node<D> aux = refHead;

			while(aux != null)
			{
				if (dado.equals(aux.getItem()))
					cont++;
				aux = aux.getNext();
			}

			return cont;
		}
	}

	@Override
	public D getFirst() {
		D res = null;
		
		if (refHead != null)
			res = refHead.getItem();
		
		return res;
	}

	@Override
	public D getLast() {
		D res = null;
		
		if (refTail != null)
			res = refTail.getItem();
		
		return res;
	}

	@Override
	public Iterator<D> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public D removeFirst() {
		D auxD = null;
		
	    if(refHead != null)
	       {
	    	auxD = refHead.getItem();
	    	
	        refHead = refHead.getNext();
	        if (refHead == null)
	        	refTail = null;
	        else
	        	refHead.setPrev(null);
	
	        qtdElem--;
	       }
	    
	    return auxD;
	}

	public D removeLast() {
		D auxD = null;
		Node<D> aux;
		
		if(refHead != null) 
		   {
			if(refHead.getNext() == null)
			  {
				auxD = refHead.getItem();
		        refHead = null;    
		        refTail = null;
			  }
		
		    else 
		      {
		       aux = refHead;
		       while(aux.getNext().getNext() != null) 
		    	   aux = aux.getNext();
		       
		       auxD = aux.getNext().getItem();
		       
		       aux.getNext().setNext(null);
		       aux.setNext(null);
		       refTail = aux;
		      }
		    qtdElem--;
		   }
		return auxD;
	}
	
	public String toString() {
		Node<D> aux = refHead;
		String res = "";
		int tot = size();
		
		for (int i = 0; i < tot; i++) {
			res = res + aux.getItem().toString();
			aux = aux.getNext();
		}
		
		return res;
	}
}