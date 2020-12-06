package br.com.carlos.product.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;

import br.com.carlos.product.service.product.model.Product;
import br.com.carlos.product.service.product.repository.ProductRepository;
import br.com.carlos.product.service.product.service.ProductService;

@SpringBootTest
public class ProductIntegrationTests {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductRepository repository;
	
	@Container
	@SuppressWarnings("rawtypes")
	private GenericContainer postgresqlContainer = new PostgreSQLContainer("postgres").withDatabaseName("productdb")
			.withUsername("postgres").withPassword("123");
	
	@Container
	private RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3-management").withUser("rabbitmq", "rabbitmq").withExposedPorts(5673);
	
	@Test
	public void shouldCreateProduct() {
		Long initialDatabaseQuantity = repository.count();
		var product = Product.builder().name("PS5").price(10000.00).build();
		service.create(product);
		Assertions.assertThat(initialDatabaseQuantity).isLessThan(repository.count());
	}

}
