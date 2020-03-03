package Repository;

import java.util.*;

public interface IGeneralRepository<E> {
    List<E> findAll();
    E findByName(String name);
    void add(E e);
    void update(int id, E e);
    void delete(int id);
    int checkId(int id);
}
