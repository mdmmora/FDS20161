package TAD.list;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListArray <D extends Comparable<D>> implements ListTAD<D>, Serializable {
	private D [] vet;
	private int qtdElem = 0;
	private int corrente = -1;
	
	private class Iterador implements Iterator<D>{
        private int position = 0;

        public boolean hasNext() { return (position != qtdElem); }
        
        public D next() {
            if(position == qtdElem)
                throw new NoSuchElementException();
            D item = vet[position];
            position++;
            return item;
        }

        public void remove() { throw new UnsupportedOperationException();  }
    }

	public Iterator<D> iterator() {
		return new Iterador();
	}
	private void increaseVet()
	{
		D[] newVet = (D[]) new Comparable[(int)(vet.length * 1.5)];
		
		System.arraycopy(vet, 0, newVet, 0, vet.length);
		
		vet = newVet;
	}
	
	public ListArray(int n)
	{
		int tam = n;
		if (n <= 0)
			tam = 100;
		
		vet = (D[]) new Comparable[tam];
	}
	
	public void set(int index, D elem)
	{
		if ((index >= 0) && (index < this.size()))
			{
				vet[index] = elem;
				corrente = index;
			}
		else
			throw new IndexOutOfBoundsException();
	}
	
	public D get(int index)
	{
		D res = null; 
		
		if ((index >= 0) && (index < this.size()))
			{
				res = vet[index];
				corrente = index;
			}
		else
			throw new IndexOutOfBoundsException();
		
		return res;
	}
	
	public void add(int index, D elem)
	{
		int i;
		
		if (this.size() == vet.length)
			increaseVet();
		
		if ((index >= 0) && (index <= this.size()))
		{
			for (i = this.size(); i > index; i--)
				vet[i] = vet[i-1];
			
			vet[index] = elem;
			corrente = index;
			qtdElem++;
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	public void add(D elem)
	{
		this.add(this.size(), elem);
	}
	
	public D remove(int index)
	{
		int i;
		D res;
		
		if ((index >= 0) && (index < this.size()))
		{
			res = vet[index];
			
			for (i = index; i < this.size()-1; i++)
				vet[i] = vet[i+1];
			
			corrente = -1;
			qtdElem--;
		}
		else
			throw new IndexOutOfBoundsException();
	
		return res;
	}
	
	public boolean isEmpty()
	{
		boolean res = false;
		
		if (this.size() == 0)
			res = true;
		
		return res;
	}
	
	public D getNext()
	{
		D res = null;  
		
		if ((corrente >= 0) && (corrente < this.size()-1))
			{
				corrente = corrente + 1;
				res = vet[corrente];
			}

		return res;
	}
	
	public int size()
	{
		return qtdElem;
	}

	public D remove(D element) {
		// TODO Auto-generated method stub
		return null;
	}

	public D search(D ob) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addFirst(D d) {
		this.add(0, d);
	}
	
	public void addLast(D d) {
		this.add(d);
	}
	
	public void clean() {
		qtdElem = 0;
	}
	
	public int count(D element) {
		int res = 0;
		
		for (int i = 0; i < this.size(); i++)
			if (element.equals(vet[i]))
				res++;
		return res;
	}
	
	public D getFirst() {
		D res = null;
		
		if (this.size() > 0)
			res = vet[0];
		
		return res;
	}
	
	public D getLast() {
		D res = null;
		
		if (this.size() > 0)
			res = vet[this.size()-1];
		
		return res;
	}
	
	public D removeFirst() {
		D res = null;
		
		if (this.size() > 0) {
			res = vet[0];
			
			for (int i = 0; i < this.size()-1; i++)
				vet[i] = vet[i+1];
			
			qtdElem--;
		}
			
		return res;
	}
	
	public D removeLast() {
		D res = null;
		
		if (this.size() > 0) {
			res = vet[this.size() - 1];
			qtdElem--;
		}
		
		return res;
	}
	
	public String toString() {
		String res = "";
		
		for(int i = 0; i < this.size(); i++)
			res = res + vet[i].toString();
		
		return res;
	}
}
