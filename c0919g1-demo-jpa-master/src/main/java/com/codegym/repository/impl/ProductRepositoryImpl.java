package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {

        List<Product> products = em.createNamedQuery("findAllProduct").getResultList();
        //TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        //return query.getResultList();

        return products;
    }

    @Override
    public void add(Product product) {
        em.persist(product);
    }

    @Override
    public Product findById(Long id) {
        Product product = (Product) em.createNamedQuery("findProductById")
                .setParameter("proId",id).getSingleResult();
        return product;
    }
}
