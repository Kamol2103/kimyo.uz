package com.company.kimyo.uz.service;

import com.company.kimyo.uz.model.Product;
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

    private ProductRepository productRepository;



    @Override
    public ResponseDto<ProductDto> createEntity(ProductDto dto) {
       return null;
    }

    @Override
    public ResponseDto<ProductDto> getEntity(Integer prodId) {

        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", prodId))
                .build();
    }

    @Override
    public ResponseDto<ProductDto> updateEntity(Integer entityId, ProductDto dto) {
        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", entityId))
                .build();
    }

    @Override
    public ResponseDto<ProductDto> deleteEntity(Integer prodId) {
        return ResponseDto.<ProductDto>builder()
                .code(-1)
                .message(String.format("Product with %d:id is not found", prodId))
                .build();
    }


}
