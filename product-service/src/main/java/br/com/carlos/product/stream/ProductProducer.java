package br.com.carlos.product.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductProducer {

	@Output("products")
	MessageChannel sendProduct();
}
