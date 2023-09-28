package com.company.kimyo.uz.service.mapper;

import com.company.kimyo.uz.model.Product;
import com.company.kimyo.uz.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public abstract class ProductMapper {
    public ProductDto toDto(Product product){
        return ProductDto.builder()
                .prodId(product.getProdId())
                .prodName(product.getProdName())
                .prodColor(product.getProdColor())
                .prodType(product.getProdType())
                .prodPrice(product.getProdPrice())
                .prodAmount(product.getProdAmount())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
    public Product toEntity(ProductDto dto){
        return Product.builder()
                .prodName(dto.getProdName())
                .prodColor(dto.getProdColor())
                .prodType(dto.getProdType())
                .prodPrice(dto.getProdPrice())
                .prodAmount(dto.getProdAmount())
                .build();
    }
    public Product updateProduct(Product product, ProductDto dto) {
        if (product==null){
            return null;
        }
        if (dto.getProdName()!=null){
            product.setProdName(dto.getProdName());
        }
        if (dto.getProdColor()!=null){
            product.setProdColor(dto.getProdColor());
        }
        if (dto.getProdType()!=null){
            product.setProdType(dto.getProdType());
        }
        if (dto.getProdAmount()!=null){
            product.setProdAmount(dto.getProdAmount());
        }
        if (dto.getProdPrice()!=null){
            product.setProdPrice(dto.getProdPrice());
        }
        product.setUpdatedAt(LocalDateTime.now());
        return product;
    }
}
