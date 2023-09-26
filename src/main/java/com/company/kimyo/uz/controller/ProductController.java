package com.company.kimyo.uz.controller;

import com.company.kimyo.uz.dto.ProductDto;
import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.service.ProductService;
import com.company.kimyo.uz.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "product")

public class ProductController implements SimpleCrud<Integer, ProductDto> {

    private final ProductService productService;

    @Override
    @PostMapping(value = "/")
    public ResponseDto<ProductDto> createEntity(@RequestBody ProductDto product) {
        return this.productService.createEntity(product);
    }

    @Override
    @GetMapping(value = "/")
    public ResponseDto<ProductDto> getEntity(@RequestParam(value = "id")Integer prodId) {
        return this.productService.getEntity(prodId);
    }

    @Override
    @PutMapping(value = "/")
    public ResponseDto<ProductDto> updateEntity(@RequestParam (value = "id")Integer prodId,
                                            @RequestBody ProductDto product) {
        return this.productService.updateEntity(prodId,product);
    }

    @Override
    @DeleteMapping(value = "/")
    public ResponseDto<ProductDto> deleteEntity(@RequestParam(value = "id")Integer prodId) {
        return this.productService.deleteEntity(prodId);
    }

}
