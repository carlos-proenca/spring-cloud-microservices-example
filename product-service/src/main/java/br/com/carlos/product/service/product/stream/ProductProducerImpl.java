package br.com.carlos.product.service.product.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(ProductProducer.class)
public class ProductProducerImpl { }
