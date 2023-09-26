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

public class CardDto {
    private Integer cardId;
    private String cardName;
    private Integer userId;
    private String cardCode;
    private UserDto users;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
