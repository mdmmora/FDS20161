package TAD.queue;

import TAD.list.ListSimpleLinked;
import TAD.list.ListTAD;

public class PriorityQueue<T extends Comparable<T>> {
	private class Node<D extends Comparable<D>> implements Comparable<Node<D>>{
		private D elem;
		private Integer key;
		public D getElem() {
			return elem;
		}
		public void setElem(D elem) {
			this.elem = elem;
		}
		public Integer getKey() {
			return key;
		}
		public void setKey(Integer key) {
			this.key = key;
		}
		
		public int compareTo(Node<D> n) {
			return elem.compareTo(n.getElem()) &
				   key.compareTo(n.getKey());
		}
		
	}
	
	private ListTAD<Node<T>> pQueue = new ListSimpleLinked<Node<T>>();
	
	public int size() {
		return pQueue.size();
	}
	
	public void enqueue(Integer k, T el) {
		int i;
		Node<T> novo = new Node<T>();
		
		novo.setElem(el);
		novo.setKey(k);
		
		for (i = 0; (i < pQueue.size()) && (pQueue.get(i).getKey() <= k); i++);
		
		pQueue.add(i, novo);
	}
	
	

}
