package com.company.kimyo.uz.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ResponseDto<T> {
    private boolean succes;
    private int code;
    private String message;
    private T data;
}
