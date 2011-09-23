
import java.util.ArrayList;
import java.util.List;




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */
public class ListaCircular<E> extends Abstract<E> {
    protected Node<E> tail;  
    protected int count;
    private List <E> ColaCircular = new ArrayList<E>();
    
    public ListaCircular()
    // pre: constructs a new circular list
    {
        tail = null;
        count = 0;
    }
    
    public void addFirst(E value)
    // pre: value non-null
    // post: adds element to head of list
    {
        Node<E> temp = new Node<E>(value);
        if (tail == null) { // first value added
        tail = temp;
        tail.setNext(tail);
        } else { // element exists in list
        temp.setNext(tail.next());
        tail.setNext(temp);
        }
        count++;
    }
    
    public void addLast(E value)
        // pre: value non-null
        // post: adds element to tail of list
   {
        // new entry:
        addFirst(value);
        tail = tail.next();
   }
    
   public E removeLast()
        // pre: !isEmpty()
        // post: returns and removes value from tail of list
   {
        //Assert.pre(!isEmpty(),"list is not empty.");
        Node<E> finger = tail;
        while (finger.next() != tail) {
        finger = finger.next();
        }
        // finger now points to second-to-last value
        Node<E> temp = tail;
        if (finger == tail)
        {
        tail = null;
        } else {
        finger.setNext(tail.next());
        tail = finger;
        }
        count--;
        return temp.value();
   }

    @Override
    public boolean offer(E e) {
        E item;         // Para comparar
        //int tam;
        boolean eq;     // Para verificar si son iguales
        ColaCircular.add(e);   // Se agrega un elemento a la cola
        item = ColaCircular.get(ColaCircular.size()-1); 
        eq = e.equals(item);
        return eq;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E poll() {
        E element;
        if(isEmpty())
            return null;
        else{
            element = ColaCircular.get(0); // Obtiene el ultimo elemento
            ColaCircular.remove(0);        // Remueve el ultimo elemento
            return element;
        } 
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E peek() {
        E elemento;
        elemento = ColaCircular.get(0); //Obtiene un elemento de
        return elemento;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
