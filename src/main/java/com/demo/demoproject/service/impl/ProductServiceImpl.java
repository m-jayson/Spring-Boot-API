package com.demo.demoproject.service.impl;

import com.demo.demoproject.exceptions.ProductException;
import com.demo.demoproject.model.Product;
import com.demo.demoproject.repository.ProductDAO;
import com.demo.demoproject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl<ID extends Long,T extends Product> implements ProductService<ID,T> {

    @Autowired
    ProductDAO<ID,T> productDAO;

    @Override
    public ID add(T product) {
        log.info("Saving :: {}",product);
        product.setId(null);
        var entity = this.productDAO.save(product);
        return (ID) entity.getId();
    }

    @Override
    public void modify(ID id, T product) {
        log.info("Modify :: {} :: {}",id,product);
        var entity = find(id);

        entity.setName(product.getName());

        this.productDAO.save(product);
    }

    @Override
    public void delete(ID id) {
        log.info("Delete :: {}");
        var entity = this.find(id);
        this.productDAO.delete(entity);
    }

    @Override
    public List<T> all() {
        log.info("Fetch All");
        return this.productDAO.findAll();
    }

    @Override
    public T find(ID id) {
        log.info("Find :: {}",id);
        var product = this.productDAO.findById(id).orElseThrow(() -> new ProductException("Product Not found!"));
        return product;
    }
}
