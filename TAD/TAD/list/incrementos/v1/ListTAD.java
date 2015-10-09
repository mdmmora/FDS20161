package TAD.list.incrementos.v1;
import java.util.*;

/*********
 * Interface para o T.A.D. Lista.
 * @author Michael da Costa M�ra
 * @param <E> Tipo dos dados armazenados na lista.
 */
public interface ListTAD <E> {
	/**********
	 * M�todos pr�prios do TAD Lista 
	 *********/
	
	/**********
	 * Adiciona um elemento na �ltima posi��o da lista.
	 * @param element Elemento a ser adicionado. 
	 */
	public void add(E element);
	
	/**********
	 * Adiciona o elemento fornecido em uma dada posi��o da lista.
	 * @param index Posi��o da lista.
	 * @param element Elemento a ser adicionado. 
	 */
	public void add(int index, E element);
	
	/**********
	 * Remove o elemento armazenado na posi��o fornecida da lista.
	 * @param pos Posi��o da lista. 
	 */
	public E remove(int pos);

	/**********
	 * Remove a primeira ocorr�ncia de um dado elemento da lista.
	 * @param element Elemento a ser adicionado. 
	 */
	public E remove(E element);
	
	/**********
	 * Recupera o elemento armazenado em uma dada posi��o da lista.
	 * @param pos Posi��o do elemento na lista.
	 * @return Elemento armazenado na lista. 
	 */	
	public E get(int pos);
	
	/**********
	 * Atualiza a posi��o fornecida da lista, com o elemento fornecido.
	 * @param index Posi��o da lista.
	 * @param element Elemento a ser armazenado na lista. 
	 */	
	public void set(int index, E element);
	
	/**********
	 * Procura um elemento na lista, e retorna sua ocorr�ncia.
	 * @param element Elemento a ser procurado.
	 * @return refer�ncia para o elemento armazenado na lista. 
	 */	
	public E search(E element);
	
	/**********
	 * Verifica se a lista est� vazia.
	 * @return true se a lista est� vazia, false caso contr�rio. 
	 */		
	public boolean isEmpty();
	
	/**********
	 * Recupera a quantidade de elementos armazenados na lista.
	 * @return Quantidade de elementos. 
	 */			
	public int size(); 
	
	/********
	 * Conta quantas ocorr�ncias de um dado elemento est�o armazenadas na lista.
	 * @return A quantidade de ocorr�ncias do elemento fornecido.
	 */	
	public int count(E element);
	
	/**********
	 * Remove todos os elementos da lista.
	 */				
	public void clean();
	
	
	/**********
	 * M�todos adicionais, para fins did�ticos. 
	 *********/
	/********
	 * Adiciona um elemento na primeira posi��o da lista.
	 * @param element Elemento a ser adicionado.
	 */
	public void addFirst(E element);

	/**********
	 * Adiciona um elemento na �ltima posi��o da lista.
	 * @param element Elemento a ser adicionado. 
	 */
	public void addLast(E element);
	
	/********
	 * Remove o elemento armazenado na primeira posi��o da lista.
	 * @return Elemento removido da lista.
	 */
	public E removeFirst();

	/********
	 * Remove o elemento armazenado na �ltima posi��o da lista.
	 * @return Elemento removido da lista.
	 */
	public E removeLast();

	/********
	 * Recupera o elemento armazenado na primeira posi��o da lista.
	 * @return Elemento armazenado na lista.
	 */
	public E getFirst();

	/********
	 * Recupera o elemento armazenado na �ltima posi��o da lista.
	 * @return Elemento armazenado na lista.
	 */
	public E getLast();	
}
