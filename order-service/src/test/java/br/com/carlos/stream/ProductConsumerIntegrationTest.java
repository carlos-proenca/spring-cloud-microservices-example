package br.com.carlos.stream;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;

import br.com.carlos.product.model.Product;
import br.com.carlos.product.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductConsumerIntegrationTest {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StreamBridge streamBridge;
	
	@Container
	@SuppressWarnings("rawtypes")
	private GenericContainer postgresqlContainer = new PostgreSQLContainer("postgres").withDatabaseName("orderdb")
			.withUsername("postgres").withPassword("123");
	
	@Container
	private RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3-management").withUser("rabbitmq", "rabbitmq").withExposedPorts(5673);

	@Test
	public void shouldCreateProductFromQueue() throws InterruptedException {
		Product productToBeCreated = Product.builder().name("Teclado").price(100d).build();
		streamBridge.send("products", productToBeCreated);
		assertThat(productRepository.count()).isEqualTo(1);
	}
}
