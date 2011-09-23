/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */
//Clase abstracta que contiene los metodos mas generales de todas las clases creadas
public abstract class Abstract <E> implements Queue <E> {
    private int tam;
    
    @Override
    public abstract boolean offer(E e);
    
    @Override
    public abstract E poll();
    
    public abstract E peek();
    //Se define el tamano de la Cola porque es una caracteristica general de las clases que se van a heredar.
    @Override
    public int size(){
        return tam;
    }
    //Se define si esta vacia o no porque es una caracteristica general
    @Override
    public boolean isEmpty(){
        if(tam==0){
            return true;
        }
        else
            return false;     
    }
}