/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElevatorProj_TestPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * A collection designed for holding elements prior to processing.
 * Besides basic Collection operations, queues provide additional insertion,
 * extraction, and inspection operations. Each of these methods exists
 * in two forms: one throws an exception if the operation fails, the other
 * returns a special value (either null or false, depending on the operation).
 * The latter form of the insert operation is designed specifically for use
 * with capacity-restricted Queue implementations; in most implementations,
 * insert operations cannot fail.
 * @author Andrew Krause, Mitchell Babej, and John Merkel
 * @param <T> The type of ArrayList the queue will be;
 */
public class QueueClass<T> implements Queue{
    
    private ArrayList<T> list = new ArrayList<>();
    
    @Override
    public boolean add(Object e) {
        if(list.add((T)e)) {
            return true;
        }
        throw new IllegalStateException("Failled to add object to the queue");
    }

    @Override
    public boolean offer(Object e) {
        return list.add((T)e);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }
    
    @Override
    public T poll() {
        if(list.size() > 0)
            return list.remove(0);
        return null;
    }

     /**
     * Retrieves and removes the object at the specified index
     * of this queue, or returns null if the request is null / out of bounds.
     * @param index Index location of the desired removal.
     * @return Object at location index, or null if out of bounds.
     */
    public T pollAhead(int index){
        if(list.size() > index)
            return list.remove(index);
        return null;
    }
    
    @Override
    public Object element() {
        return list.get(0);
    }

    @Override
    public T peek() {
        if(list.size() > 0)
            return list.get(0);
        return null;
    }
    
    /**
     * Retrieves, but does not remove, the object at the specified index
     * of this queue, or returns null if the request is null / out of bounds.
     * @param index Index location of the desired peek.
     * @return Object at location index, or null if out of bounds.
     */
    public T peekAhead(int index) {
        if(list.size() > index)
            return list.get(index);
        return null;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public boolean removeAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }
    
}
