package TAD.graph;

import java.util.*;

public final class DijkstraResult<D> {
	private D origin;
	private Map<D, D> previousNodes;
	private Map<D, Double> costs;
	
	public DijkstraResult(D origin) {
		this.origin = origin;
		previousNodes = new HashMap<>();
		costs = new HashMap<>();
	}

	public D getOrigin() {
		return origin;
	}
	
	public List<D> getPath(D dest) {
		List<D> res = null;
		D aux;
		
		if (previousNodes.containsKey(dest)) {
			res = new LinkedList<D>();
			res.add(0,dest);
	
			aux = previousNodes.get(dest);
			while (aux !=null) {
				res.add(0, aux);
				aux = previousNodes.get(aux);
			}
		}
		return res;
	}

	public Double getCost(D dest) {
		Double res = -1.0;
		
		if (costs.containsKey(dest))
			res = costs.get(dest);
		
		return res;
	}
	
	public boolean addNode(D it, D previous, Double cost) {
		boolean res = false;
		
		if (!previousNodes.containsKey(it) && it != null &&
			 cost >= 0) {
			previousNodes.put(it, previous);
			costs.put(it, cost);
			res = true;
		}
		
		return res;
	}
	
	public boolean setNode(D it, D previous, Double cost) {
		boolean res = false;
		
		if (previousNodes.containsKey(it) && it != null &&
				cost >= 0) {
			previousNodes.replace(it, previous);
			costs.replace(it, cost);
			res = true;
		}
		
		return res;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		
		res.append("Origem: " + getOrigin() + "\n");
		for (Map.Entry<D, D> c:previousNodes.entrySet()){
			res.append("Nodo: ");
			res.append(c.getKey());
			res.append(" Anterior: ");
			res.append(c.getValue());
			res.append(" Cost: ");
			res.append(costs.get(c.getKey()));
			res.append("\n");
		}
			
		return res.toString();
	}
	
}