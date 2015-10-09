package TAD.testes;

import java.util.*;

public class TestePriorityQueue {
	
	private class mM implements Comparator<Node> {
		public int compare(Node n1, Node n2) {
			int res;
			
			//res = n1.getKey() - n2.getKey();
			if (n1.getKey() < n2.getKey())
				res = -1;
			else if (n1.getKey() > n2.getKey())
					res = 1;
			else res = 0;
			
			return res;
		}
	}
	
	private class Node {
		private String dado;
		private int key;

		public Node(String d, int k) {
			dado = d;
			key = k;
		}
		public String getDado() {
			return dado;
		}
		public void setDado(String dado) {
			this.dado = dado;
		}
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
	}

	/**
	 * @param args
	 */
	public void executa() {
		// TODO Auto-generated method stub
		PriorityQueue <Node> fila = new PriorityQueue<Node>(10, new mM());
		
		Node n1 = new Node("A", 10);
		fila.offer(n1);
		
		Node n2 = new Node("B", 9);
		fila.offer(n2);
		
		Node n3 = new Node("C", 8);
		fila.offer(n3);
			
		for (Node m:fila)
			System.out.println(m.getDado() + " " + m.getKey());
		
		n3.setKey(5);
		
		for (Node m:fila)
			System.out.println(m.getDado() + " " + m.getKey());
	}

	public static void main(String[] a) {
		new TestePriorityQueue().executa();
	}
}
