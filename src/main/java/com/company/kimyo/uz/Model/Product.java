package com.company.kimyo.uz.Model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    private Integer prodId;
    private String prodName;
    private String prodType;
    private String prodColor;
    private Integer prodAmount;
    private Double prodPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
