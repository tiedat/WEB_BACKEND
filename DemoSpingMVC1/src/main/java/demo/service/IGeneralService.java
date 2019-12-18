package demo.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAllHaveBusiness();
    E findById(long id);
    E findByName(String name);
    void save(E e);
}
