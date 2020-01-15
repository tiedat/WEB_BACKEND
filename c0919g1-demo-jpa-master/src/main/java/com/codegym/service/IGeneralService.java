package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAll();
    void add(E e);
    E findById(Long id);
}
