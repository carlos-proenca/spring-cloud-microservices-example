package br.com.carlos.product.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("v1/products")
@AllArgsConstructor
public class ProductResource {


	@GetMapping
	public ResponseEntity<String> sendMessage() {
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
