package com.company.kimyo.uz.util;


import com.company.kimyo.uz.dto.ResponseDto;

public interface SimpleCrud <K, V>{
    ResponseDto<V> createEntity(V entity);
    ResponseDto<V> getEntity(K entityId);
    ResponseDto<V> updateEntity(K entityId, V entity);
    ResponseDto<V> deleteEntity(K entityId);

}
