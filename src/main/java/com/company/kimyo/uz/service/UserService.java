package com.company.kimyo.uz.service;

import com.company.kimyo.uz.model.User;
import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.dto.UserDto;
import com.company.kimyo.uz.service.mapper.UserMapper;
import com.company.kimyo.uz.repository.UserRepository;
import com.company.kimyo.uz.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements SimpleCrud<Integer, UserDto> {
    private final UserMapper userMapper;
    private final UserRepository userRepository;


    @Override
    public ResponseDto<UserDto> createEntity(UserDto dto) {
        try {
            User entity = this.userMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<UserDto>builder()
                    .succes(true)
                    .message("Ok")
                    .data(this.userMapper.toDto(
                            this.userRepository.save(entity)
                    ))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .code(-2)
                    .message(String.format("User while saving error message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<UserDto> getEntity(Integer entityId) {
        Optional<User> optionalUser = this.userRepository.findByUserIdAndDeletedAtIsNull(entityId);
        if (optionalUser.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("User with %d:id is not found", entityId))
                    .build();
        }
        return ResponseDto.<UserDto>builder()
                .succes(true)
                .message("Ok")
                .data(this.userMapper.toDtoWithCard(optionalUser.get()))
                .build();
    }

    @Override
    public ResponseDto<UserDto> updateEntity(Integer entityId, UserDto dto) {
        try {
            Optional<User> optionalUser = this.userRepository.findByUserIdAndDeletedAtIsNull(entityId);
            if (optionalUser.isEmpty()) {
                return ResponseDto.<UserDto>builder()
                        .code(-1)
                        .message(String.format("User with %d:id is not found", entityId))
                        .build();
            }
            return ResponseDto.<UserDto>builder()
                    .succes(true)
                    .message("Ok")
                    .data(this.userMapper.toDto(
                                    this.userRepository.save(
                                            this.userMapper.updateUser(dto, optionalUser.get())
                                    )
                            )
                    )
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserDto>builder()
                    .code(1)
                    .message(String.format("User with %d:id is not found", entityId))
                    .build();

        }
    }

    @Override
    public ResponseDto<UserDto> deleteEntity(Integer entityId) {
        Optional<User> optionalUser = this.userRepository.findByUserIdAndDeletedAtIsNull(entityId);
        if (optionalUser.isEmpty()) {
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("User with %d:id is not found", entityId))
                    .build();
        }
        User user = optionalUser.get();
        user.setDeletedAt(LocalDateTime.now());
        this.userRepository.save(user);
        return ResponseDto.<UserDto>builder()
                .succes(true)
                .message("Ok")
                .data(this.userMapper.toDto(user))
                .build();
    }

    public ResponseDto<List<UserDto>> getAll() {

        List<User> list = this.userRepository.findAllByDeletedAtIsNull();
        List<UserDto> list1 = list.stream()
                .filter(user -> {
                    if (user.getAge() > 18) {
                        return true;
                    } else {
                        return true;
                    }

                }).map(this.userMapper::toDto)
                .toList();

        return ResponseDto.<List<UserDto>>builder().build();
    }

}
