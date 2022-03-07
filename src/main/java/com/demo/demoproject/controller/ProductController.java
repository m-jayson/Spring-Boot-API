package com.demo.demoproject.controller;

import com.demo.demoproject.model.Product;
import com.demo.demoproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController<T extends Product,ID extends Long> {

    @Autowired
    ProductService<ID, T> productProductService;

    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        var all = this.productProductService.all();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<T> getProduct(@PathVariable("id") ID todoId) {
        var product = productProductService.find(todoId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<T> saveProduct(@Valid @RequestBody T productRequest) {
        var product = this.productProductService.add(productRequest);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("product_id", "/product/" + product);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<T> updateTodo(@PathVariable("id") ID id, @Valid @RequestBody T product) {
        this.productProductService.modify(id,product);
        return new ResponseEntity<>(productProductService.find(id), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<T> deleteProduct(@PathVariable("id") ID id) {
        this.productProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
