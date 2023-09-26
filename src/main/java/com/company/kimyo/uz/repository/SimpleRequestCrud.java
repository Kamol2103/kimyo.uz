package com.company.kimyo.uz.repository;

import com.company.kimyo.uz.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface SimpleRequestCrud <K,V>  {

        ResponseEntity<ResponseDto<V>> createEntity(V entity);
        ResponseEntity<ResponseDto<V>> getEntity(K entityId);
        ResponseEntity<ResponseDto<V>> updateEntity(K entityId, V entity);
        ResponseEntity<ResponseDto<V>> deleteEntity(K entityId);

}

