package br.com.carlos.product.service.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carlos.product.service.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{ }
