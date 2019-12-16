package demo.repository;

import java.util.List;

public interface IGeneralRepository<E> {
    List<E> findAll();
    E findById(Long id);
}
