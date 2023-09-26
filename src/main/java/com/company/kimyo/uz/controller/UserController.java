package com.company.kimyo.uz.controller;


import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.dto.UserDto;
import com.company.kimyo.uz.service.UserService;
import com.company.kimyo.uz.repository.SimpleRequestCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.kimyo.uz.config.SimpleResponseDto.convertStatusCodeByData;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users")
public class UserController implements SimpleRequestCrud<Integer, UserDto> {
    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> createEntity(@RequestBody UserDto entity) {
        return convertStatusCodeByData(this.userService.createEntity(entity));
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDto<UserDto>> getEntity(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.userService.getEntity(entityId));
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDto<UserDto>> updateEntity(@RequestParam(value = "id")Integer entityId,
                                             @RequestBody UserDto entity) {
        return convertStatusCodeByData(this.userService.updateEntity(entityId,entity));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDto<UserDto>> deleteEntity(@RequestParam(value = "id")Integer entityId) {
        return convertStatusCodeByData(this.userService.deleteEntity(entityId));
    }
}
