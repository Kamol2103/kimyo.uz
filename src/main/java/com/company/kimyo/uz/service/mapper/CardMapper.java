package com.company.kimyo.uz.service.mapper;

import com.company.kimyo.uz.model.Card;
import com.company.kimyo.uz.dto.CardDto;
import org.mapstruct.*;
@Mapper(componentModel = "spring")
public  abstract class CardMapper {
    @Mapping(target = "cardId",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @Mapping(target = "cardCode",expression = "java(dto.getCardCode())")
    public abstract Card toEntity(CardDto dto);



    @Mapping(target = "users",ignore = true)
    public abstract CardDto toDto(Card card);



    @Mapping(target = "cardId",ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target = "deletedAt",ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Card.class)
    public abstract Card updateCard(CardDto dto,@MappingTarget Card card );

    public abstract CardDto toDtoWithUser(Card card);


}
