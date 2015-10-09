package TAD.graph.v3;

import java.util.*;

public class DijkstraResult<N> {
	private List<N> path;
	private Double weight;
	
	public DijkstraResult() {
		path = new ArrayList<N>();
	}

	public List<N> getPath() {
		return path;
	}

	public void setPath(List<N> path) {
		this.path = path;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
