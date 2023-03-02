package org.example.reposity;

import java.util.List;
public interface Repository<T, E> {
    boolean add(T iem);
    T get(E id);
    List<T> readAll();
    boolean update(E id, T item);
    boolean remove(E p);

}
