package Service.impl;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    E findByName(String name);
    void add(E e);
    void update(int id, E e);
    void delete(int id);
    int checkId(int id);
}
