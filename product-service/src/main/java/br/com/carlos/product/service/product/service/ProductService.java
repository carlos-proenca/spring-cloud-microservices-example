package br.com.carlos.product.service.product.service;

import java.util.List;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import br.com.carlos.product.service.product.model.Product;
import br.com.carlos.product.service.product.repository.ProductRepository;
import br.com.carlos.product.service.product.stream.ProductProducer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {

	private ProductRepository repository;
	private ProductProducer producer;
	

	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product create(Product product) {
		Product productCreated =  repository.save(product);
		this.sendProductToOrderService(productCreated);
		return productCreated;
	}

	private void sendProductToOrderService(Product productCreated) {
		Message<Product> message = MessageBuilder.withPayload(productCreated).build();
		producer.sendProduct().send(message);
	}
}
