package com.codegym.service;

import java.util.List;

public interface IGeneralService<E> {
    List<E> findAllHaveBusiness();

    void addHaveBusiness(E e);
}
