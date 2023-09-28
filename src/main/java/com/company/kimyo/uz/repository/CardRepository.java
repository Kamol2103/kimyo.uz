package com.company.kimyo.uz.repository;

import com.company.kimyo.uz.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

    Optional<Card> findByCardIdAndDeletedAtIsNull(Integer cardId);

    Set<Card> findAllByDeletedAtIsNotNull();
}
