package week1;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollections<E> implements Collection<E> {

    public boolean isEmpty(){
        return !iterator().hasNext();
    }

    public int size(){
        int n = 0;
        for (E e:this){
            n++;
        }
        return n;
    }

    public boolean contains(Object o){
        for(E e:this){
            if(e == o || e.equals(o)){
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> c){
        for (Object x: c){
            if (!contains(x)){
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c){
        boolean modified = false;
        for (E e:c){
            if (add(e)){
                modified = true;
            }
        }
        return modified;
    }

    public void clear(){
        Iterator<E> it = iterator();
        while (it.hasNext()){
            it.next();
            it.remove();
        }
    }

    public boolean remove(Object o){
        Iterator<E> it = iterator();
        while (it.hasNext()){
            Object x = it.next();
            if(x == o || x.equals(o)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> c){
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()){
            if (c.contains(it.next())){
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public boolean retainAll(Collection<?> c){
        boolean modified = false;
        Iterator<?> it = iterator();
        while (it.hasNext()){
            if (!c.contains(it.next())){
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    public Object[] toArray(){
        Object[] result = new Object[size()];
        int i = 0;
        for (E e : this){
            result[i++] = e;
        }
        return result;
    }

    public <T>T[] toArray(T[] arg){
        if (arg.length < size()){
            arg = (T[]) Array.newInstance(arg.getClass().getComponentType(), size());
        }
        int i = 0;
        for(E e:this){
            arg[i++] = (T)e;
        }
        if (arg.length > size()){
            arg[i] = null;
        }
        return arg;
    }
}
