package com.company.kimyo.uz.service;

import com.company.kimyo.uz.model.Card;
import com.company.kimyo.uz.dto.CardDto;
import com.company.kimyo.uz.dto.ResponseDto;
import com.company.kimyo.uz.service.mapper.CardMapper;
import com.company.kimyo.uz.repository.CardRepository;
import com.company.kimyo.uz.util.SimpleCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CardService implements SimpleCrud<Integer, CardDto> {

    private final CardMapper cardMapper;
    // private final UserService userService;
    private final CardRepository cardRepository;

    @Override
    public ResponseDto<CardDto> createEntity(CardDto dto) {
        try {
            Card entity = cardMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<CardDto>builder()
                    .succes(true)
                    .message("Ok")
                    .data(this.cardMapper.toDto(this.cardRepository.save(entity)))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<CardDto>builder()
                    .code(-2)
                    .message(String.format("Card while saving error message::%s", e.getMessage()))
                    .build();
        }
    }

    @Override
    public ResponseDto<CardDto> getEntity(Integer entityId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d:id is not found", entityId))
                    .build();
        }
        return ResponseDto.<CardDto>builder()
                .succes(true)
                .message("Ok")
                .data(this.cardMapper.toDto(optional.get()))
                .build();

    }

    @Override
    public ResponseDto<CardDto> updateEntity(Integer entityId, CardDto dto) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d:id is not found", entityId))
                    .build();
        }
        Card card = this.cardMapper.updateCard(dto, optional.get());
        this.cardRepository.save(this.cardMapper.updateCard(dto, optional.get()));
        return ResponseDto.<CardDto>builder()
                .succes(true)
                .message("Ok")
                .data(this.cardMapper.toDto(this.cardRepository.save(this.cardMapper.updateCard(dto, optional.get()))))
                .build();
    }

    @Override
    public ResponseDto<CardDto> deleteEntity(Integer entityId) {
        Optional<Card> optional = this.cardRepository.findByCardIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<CardDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d:id is not found", entityId))
                    .build();
        }
        Card card = optional.get();
        card.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<CardDto>builder()
                .succes(true)
                .message("Ok")
                .data(this.cardMapper.toDto(this.cardRepository.save(card)))
                .build();
    }

    public ResponseDto<Set<CardDto>> getAllByDeletedIsNull() {
        Set<Card> cardList = this.cardRepository.findAllByDeletedAtIsNotNull();
        if (cardList.isEmpty()) {
            return ResponseDto.<Set<CardDto>>builder()
                    .code(-1)
                    .message("Card are not found")
                    .build();
        }
        return ResponseDto.<Set<CardDto>>builder()
                .succes(true)
                .message("Ok")
                //.data(this.cardMapper.toEntityFromDto(cardList))
                .build();
    }
}
