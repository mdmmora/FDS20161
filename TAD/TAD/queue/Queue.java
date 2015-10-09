package TAD.queue;
import java.io.Serializable;

import TAD.list.ListSimpleLinked;
import TAD.list.ListTAD;

public class Queue<T extends Comparable<T>> implements QueueTAD<T>, Serializable {
	// private ListTAD<T> lst = new ListDoubleLinked<T>();
	private ListTAD<T> lst = new ListSimpleLinked<T>();
	
	public void enqueue(T dado)
	{
		if (dado != null)
			lst.add(dado);
		else
			throw new IllegalArgumentException();
	}
	
	public T dequeue()
	{
		T res = null;
		
		res = lst.remove(0);
		if (res == null)
			throw new EmptyQueueException();
		else 
			return res;
	}
	
	public T first()
	{
		T res = null;
		
		res = lst.get(0);
		if (res == null)
			throw new EmptyQueueException();
		else 
			return res;
	}
	
	public boolean isEmpty()
	{
		return lst.isEmpty();
	}
	
	public int size()
	{
		return lst.size();
	}
}
