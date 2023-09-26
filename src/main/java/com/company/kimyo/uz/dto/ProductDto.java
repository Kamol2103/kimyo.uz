package com.company.kimyo.uz.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDto {
        private Integer prodId;
        private String prodName;
        private String prodType;
        private String prodColor;
        private Integer prodAmount;
        private Double prodPrice;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
