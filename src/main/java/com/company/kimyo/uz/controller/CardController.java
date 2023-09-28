package com.company.kimyo.uz.controller;

import com.company.kimyo.uz.dto.CardDto;
import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.service.CardService;
import com.company.kimyo.uz.repository.SimpleRequestCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static com.company.kimyo.uz.config.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "card")
public class CardController implements SimpleRequestCrud<Integer, CardDto> {
    private final CardService cardService;


    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<CardDto>> createEntity(@RequestBody CardDto entity) {
      return convertStatusCodeByData(this.cardService.createEntity(entity));
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto<CardDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.getEntity(entityId));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDto<CardDto>> updateEntity(@RequestParam(value = "id") Integer entityId,
                                             @RequestBody CardDto entity) {
        return convertStatusCodeByData(this.cardService.updateEntity(entityId,entity));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDto<CardDto>> deleteEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.cardService.deleteEntity(entityId));
    }

    @GetMapping(value = "get-all")
    public ResponseDto<Set<CardDto>> getAll(){
        return this.cardService.getAllByDeletedIsNull();
    }
}
