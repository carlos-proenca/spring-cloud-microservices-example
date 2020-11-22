package br.com.carlos.product.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ProductConsumer {

	@Input("products")
	SubscribableChannel receiveProducts();
}
