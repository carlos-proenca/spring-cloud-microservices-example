package br.com.carlos.product.service.product.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductProducer {

	@Output("products")
	MessageChannel sendProduct();
}
