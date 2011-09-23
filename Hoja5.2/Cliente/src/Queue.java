
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */

public interface Queue <E> {
    //Agrega un elemento a la cola
    public boolean offer (E e);
    //Quita un elemento de la cola
    public E poll();
    //Examina un elemento de la cola
    public E peek();
    //Verifica el tamano de la Cola
    public int size();
    //Determina si la cola esta vacia o no
    public boolean isEmpty();
    
}
