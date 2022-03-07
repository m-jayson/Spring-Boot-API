package com.demo.demoproject.repository;

import com.demo.demoproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO<ID extends Long,T extends Product> extends JpaRepository<T,ID> {
}
