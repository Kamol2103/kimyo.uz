package com.company.kimyo.uz.service.mapper;

import com.company.kimyo.uz.Model.Card;
import com.company.kimyo.uz.dto.CardDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-26T17:42:24+0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class CardMapperImpl extends CardMapper {

    @Override
    public Card toEntity(CardDto dto) {
        if ( dto == null ) {
            return null;
        }

        Card.CardBuilder card = Card.builder();

        card.cardName( dto.getCardName() );
        card.userId( dto.getUserId() );

        card.cardCode( dto.getCardCode() );

        return card.build();
    }

    @Override
    public CardDto toDto(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto.CardDtoBuilder cardDto = CardDto.builder();

        cardDto.cardId( card.getCardId() );
        cardDto.cardName( card.getCardName() );
        cardDto.userId( card.getUserId() );
        cardDto.cardCode( card.getCardCode() );
        cardDto.createdAt( card.getCreatedAt() );
        cardDto.updatedAt( card.getUpdatedAt() );

        return cardDto.build();
    }

    @Override
    public Card updateCard(CardDto dto, Card card) {
        if ( dto == null ) {
            return card;
        }

        if ( dto.getCardName() != null ) {
            card.setCardName( dto.getCardName() );
        }
        if ( dto.getUserId() != null ) {
            card.setUserId( dto.getUserId() );
        }
        if ( dto.getCardCode() != null ) {
            card.setCardCode( dto.getCardCode() );
        }

        return card;
    }

    @Override
    public CardDto toDtoWithUser(Card card) {
        if ( card == null ) {
            return null;
        }

        CardDto.CardDtoBuilder cardDto = CardDto.builder();

        cardDto.cardId( card.getCardId() );
        cardDto.cardName( card.getCardName() );
        cardDto.userId( card.getUserId() );
        cardDto.cardCode( card.getCardCode() );
        cardDto.createdAt( card.getCreatedAt() );
        cardDto.updatedAt( card.getUpdatedAt() );

        return cardDto.build();
    }
}
