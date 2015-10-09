package TAD.graph.incrementos;

import java.util.*;

/******
 * Implementação didática e parcial de um Grafo Dirigido utilizando Matriz de Adjacências.
 * @param N - Genérico. Tipo do nodo do grafo
 * @author Michael da Costa Móra
 * @version 1.1
 */

public class GraphDirMatAdj<N> {
	private List<N> lNodes;
	private int max;
	private boolean [][] matAdj;	

	public GraphDirMatAdj(int n) {
		if (n > 0)
			max = n;
		else
			max = 1000;

		lNodes = new ArrayList<N>(max);
		matAdj = new boolean[max][max];
		for (int i = 0; i < max; i++)
			for (int j = 0; j < max; j++)
				matAdj[i][j] = false;
	}


	private int indexItem(N item) {
		int res = -1;
		int i;

		for (i =0; ((i < lNodes.size()) && !item.equals(lNodes.get(i))); i++);

		if (i < lNodes.size())
			res = i;

		return res;
	}

	public void addNode(N item) {				
		if (lNodes.size() < max)
			if (indexItem(item) == -1)
				lNodes.add(item);
			else
				throw new IllegalArgumentException();
		else
			throw new OutOfMemoryError("Max number of nodes reached");
	}

	public void addEdge(N orig, N dest) {
		int posOrig = indexItem(orig);
		int posDest = indexItem(dest);

		if (posOrig == -1 || posDest == -1)
			throw new IllegalArgumentException("Invalid Node");
		else {
			matAdj[posOrig][posDest] = true;
		}
	}

	private List<N> getAllAdjacents(N nodo){
		List<N> res = new ArrayList<N>();
		int index = indexItem(nodo);
		if (index < 0)
			throw new IllegalArgumentException("Invalid Node");
		else {
			for (int i = 0; i < lNodes.size(); i++)
				if (matAdj[index][i])
					res.add(lNodes.get(i));
		}

		return(res);	
	}	

	public boolean isReachable(N dado){
		boolean res = false;

		if (dado != null){
			int index = indexItem(dado);

			if (index >= 0)
				for (int l = 0; l < lNodes.size(); l++)
					if (matAdj[l][index]){
						res = true;
						break;
					}						
		}
		return res;
	}

	public List<N> getTwoLevelsAhead(N dado){
		List<N> res = null;
		List<Integer> lAuxAdj;
		Set<N> conjRes = null;
		int indexDado;

		if (dado != null) {
			indexDado = indexItem(dado);
			if (indexDado >= 0){
				conjRes = new HashSet<N>();
				lAuxAdj = new LinkedList<>();

				for(int col = 0; col < lNodes.size(); col++)
					if (matAdj[indexDado][col]){
						lAuxAdj.add(col);
						conjRes.add(lNodes.get(col));
					}

				int tam = lAuxAdj.size();

				for (int i = 0; i < tam; i++)
					for(int col = 0; col < lNodes.size(); col++)
						if (matAdj[i][col])
							conjRes.add(lNodes.get(col));
			}
		}

		if (conjRes != null && !conjRes.isEmpty())
			res = new LinkedList<>(conjRes);

			return res;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		N n;

		for (int l = 0; l < lNodes.size(); l++) {
			n = lNodes.get(l);

			res.append("\n");
			res.append(n.toString());
			res.append(": \t");

			for (int c = 0; c < lNodes.size(); c++)
				if (matAdj[l][c]) {
					res.append(lNodes.get(c).toString());
					res.append("\n\t");
				}
		}

		return res.toString();
	}
}
