package br.com.carlos.product.service.product.model;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
	
	SPORTS("esportes e lazer"),
	DRINKS("Bebidas"),
	FOOD("Fast Food"),
	ELETRONICS("Eletrônicos");
	
	@JsonValue
	private String name;
}
