package TAD.list.incrementos.v1;
import java.io.Serializable;
import java.util.Iterator;

import TAD.list.ListSimpleLinked.Node;

//
// Falta implementar um atributo refTail
//
public class ListDoubleLinked <D> implements ListTAD<D> {

	private class Node {

	    private Node next;
	    private Node prev;
	    private D item;

	    public Node() {
	    	
	    }
	    public Node(D elem, Node next) {
	    	item = elem;
	    	this.next = next;
	    }
	    public void setNext(Node no) 
	    	{ next = no; }
	 
	    public Node getPrev() 
	    	{ return prev; }
	    
	    public void setPrev(Node no) 
	    	{ prev = no; }
	    
	    public Node getNext() 
	    	{ return next; }
	    
	    public void setItem(D o) 
	    	{ item = o; }
	    
	    public D getItem() 
	    	{ return item; }
	}
	
    private Node refHead;
    private Node refTail;
    private int qtdElem = 0;

    public int size() 
    	{ return qtdElem; }    
   
    public void add(int index, D element)
    {
    	Node aux, novo, prox;
    	int i;
    	
    	if ((index >= 0) && (index <= qtdElem)) //**Posi��o � v�lida?
    	{
    		novo = new Node();		//**Instancia novo nodo
    		novo.setItem(element);
    		
    		if (index == 0)				//** Deve ser o primeiro da Lista?
    		{
    			if (refHead != null)    //** Lista est� vazia?
    				refHead.setPrev(novo);   //** Atual primeiro referencia novo primeiro como anterior
    			else
    				refTail = novo;     	 //** Sen�o ser� o primeiro e o �ltimo
    			
    			novo.setNext(refHead);  //** Novo primeiro referencia atual primeiro como pr�ximo
    			novo.setPrev(null);
    			refHead = novo;         //** Atualiza refer�ncia de primeiro da lista
    		}
    		else 
    		{		
    			if (index != qtdElem)   //** Novo nodo n�o ser� �ltimo?
    			{
    				aux = refHead;		
        			for (i = 1; i < index; i++)		//**  Procura o elemento da posi��o desejada
        				aux = aux.getNext();
        									//** Aux referencia o nodo que ser� o anterior ao novo
    				prox = aux.getNext();   //** Prox referencia o nodo seguinte ao novo
    				prox.setPrev(novo);		//** Faz o nodo seguinte ao novo referenciar o novo como anterior
    			}
    			else     //**  Nodo ser� o �ltimo
    			{
    				aux = refTail;  //**  Aux referencia o �ltimo nodo
    				prox = null;    //**  O novo nodo n�o ter� um nodo seguinta (ser� o �ltimo)
    				refTail = novo; //**  O novo nodo passa a ser o �ltimo
    			}
    								//** Ajusta os encadeamentos
    			aux.setNext(novo);		//**o anterior referencia o novo como next
    			novo.setPrev(aux);		//**o novo referencia o anterior como prev
    			novo.setNext(prox);		//**o novo referencia o seguinte como prev
    		}
    		
    		qtdElem++;			//** atualiza quantidade de elementos
    	}
    	else
    		throw new IndexOutOfBoundsException();
    }
        
    public void add(D d) 
    {
    	Node novo = new Node();
    	
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
    	Node aux;
    	int i;
    	
        if ((index >= 0) && (index < qtdElem))
    	   if(refHead != null) 
    	      {
               aux = refHead;
               for(i = 1 ; i <= index; i++)
                  aux = aux.getNext();
            
               aux.setItem(element);
              }
    	   else;
        else 
        	throw new IndexOutOfBoundsException();
    }    
    
    public D get(int pos){
    	D res = null;
    	Node aux;
    	int i;
    	
        if ((pos >= 0) && (pos < qtdElem))
    	   if(refHead != null) 
    	      {
               aux = refHead;
               for(i = 1 ; i <= pos; i++)
                  aux = aux.getNext();
            
               res = aux.getItem();
              }
    	   else;
        else
        	throw new IndexOutOfBoundsException();
        
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
    	Node aux, ant, prox;
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
    	}
    	else
    		throw new IndexOutOfBoundsException();
    return auxD;
    }
    @Override
    public D remove(D element) {
    	D res = null;
		Node aux, ant; 
		
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
		// para for�ar o erro. Devo atualizar Prev
		// e expandir o Test para garantir links para 
		// tr�s (via iteradores, em todas as implementa��es.
		// Revisar os testesCase para garantir que cada
		// altera��o preserva integridade, inclusive das
		// estruturas internas.
		return null;
    }
        
    public D search(D ob)
    {
    	Node aux;
    	D res = null;
    	
    	aux = refHead;
    	while ((aux != null) && (aux.getItem().equals(ob) != true))
    		aux = aux.getNext();
    	
    	if (aux != null)
    		res = aux.getItem();
    	
    	return res;
    }
    
    public void removeDup(D dado)
    {
    	Node aux = null;
    	Node prox = null;
    	
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
    	refHead = refTail = null;
    	qtdElem = 0;
    }

	public void addFirst(D d) {
		Node novo = new Node(d, refHead);
		
		if (refHead == null)
			refTail = novo;
		else
			refHead.setPrev(novo);
		
		refHead = novo;
		
		qtdElem++;
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
			Node aux = refHead;

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
		Node aux;
		
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
		Node aux = refHead;
		String res = "";
		int tot = size();
		
		for (int i = 0; i < tot; i++) {
			res = res + aux.getItem().toString();
			aux = aux.getNext();
		}
		
		return res;
	}
}