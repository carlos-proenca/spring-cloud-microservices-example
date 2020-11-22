package br.com.carlos.product.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import br.com.carlos.product.model.Product;
import br.com.carlos.product.repository.ProductRepository;
import br.com.carlos.product.stream.ProductConsumer;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
@EnableBinding(ProductConsumer.class)
public class ProductService {

	private ProductRepository repository;

	public Product create(Product product) {
		return repository.save(product);
	}
	
	@StreamListener("products")
	public void productIntegration(Product product) {
		this.create(product);
	}
}
