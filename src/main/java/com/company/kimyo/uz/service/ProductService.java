package com.company.kimyo.uz.service;

import com.company.kimyo.uz.Model.Product;
import com.company.kimyo.uz.dto.ProductDto;
import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.service.mapper.ProductMapper;
import com.company.kimyo.uz.repository.ProductRepository;
import com.company.kimyo.uz.util.SimpleCrud;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService implements SimpleCrud<Integer, ProductDto> {
    private ProductMapper productMapper;
    private List<Product> products;
    private Integer prodIx;
    private ProductRepository productRepository;

    public ProductService(ProductMapper productMapper, ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.products = new ArrayList<>();
        this.prodIx = 0;
    }

    @Override
    public ResponseDto<ProductDto> createEntity(ProductDto dto) {
        Product entity = this.productMapper.toEntity(dto);
        entity.setProdId(++this.prodIx);
        entity.setCreatedAt(LocalDateTime.now());
        this.products.add(entity);
        return ResponseDto.<ProductDto>builder()
                .succes(true)
                .message("Product successful created")
                .data(this.productMapper.toDto(entity))
                .build();
    }

    @Override
    public ResponseDto<ProductDto> getEntity(Integer prodId) {
        for (Product product : products) {
            if (product.getProdId().equals(prodId)) {
                return ResponseDto.<ProductDto>builder()
                        .succes(true)
                        .message("Ok")
                        .data(this.productMapper.toDto(product))
                        .build();
            }
        }
        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", prodId))
                .build();
    }

    @Override
    public ResponseDto<ProductDto> updateEntity(Integer entityId, ProductDto dto) {
        for (Product product : this.products) {
            if (product.getProdId().equals(entityId)) {
                return ResponseDto.<ProductDto>builder()
                        .succes(true)
                        .message("Ok")
                        .data(this.productMapper.toDto(this.products.set(this.products.indexOf(product),
                                        this.productMapper.updateProduct(product, dto)
                                )
                        ))
                        .build();
            }
        }
        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", entityId))
                .build();
    }

    @Override
    public ResponseDto<ProductDto> deleteEntity(Integer prodId) {
        for (Product product : products) {
            if (product.getProdId().equals(prodId)) {
                this.products.remove(product);
                return ResponseDto.<ProductDto>builder()
                        .succes(true)
                        .message("Ok")
                        .data(this.productMapper.toDto(product))
                        .build();
            }
        }
        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", prodId))
                .build();
    }

    public void simpleMethod() {
        List<Product> list = this.productRepository.findAll();
        Map<String, List<Product>> collect = list.stream()
                .filter(product -> {
                            if (product.getProdPrice() >= 12000) {
                                product.setProdPrice(product.getProdPrice() - 1000);
                                return true;
                            } else {
                                return false;
                            }

                        }
                ).collect(Collectors.groupingBy(Product::getProdColor));
    }


}
