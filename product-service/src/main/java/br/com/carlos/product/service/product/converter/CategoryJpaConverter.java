package br.com.carlos.product.service.product.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.carlos.product.service.product.model.Category;

@Converter(autoApply = true)
public class CategoryJpaConverter implements AttributeConverter<Category, String> {

	@Override
	public String convertToDatabaseColumn(Category category) {
		return category.getName();
	}

	@Override
	public Category convertToEntityAttribute(String targetCategory) {
		for (Category category : Category.values()) {
			if(category.getName().equalsIgnoreCase(targetCategory)) {
				return category;
			}
		}
		throw new IllegalArgumentException("Target Category not Found!");
	}
}
