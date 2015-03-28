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
 *
 * @authors Andrew Krause, Mitchell Babej, and John Merkel
 * @param <T> The type of ArrayList the queue will be;
 */
public class QueueClass<T> implements Queue{
    
    private ArrayList<T> list = new ArrayList<T>();
    
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
    
    public T remove(int index){
        if(list.size() > index)
            return list.remove(index);
        return null;
    }

    @Override
    public T poll() {
        if(list.size() > 0)
            return list.remove(0);
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
