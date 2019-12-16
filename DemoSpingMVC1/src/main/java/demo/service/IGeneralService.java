package demo.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAllHaveBusiness();
    E findById(long id);
}
