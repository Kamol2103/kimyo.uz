package com.company.kimyo.uz.repository;

import com.company.kimyo.uz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User>findAllByDeletedAtIsNull();
    Optional<User> findByUserIdAndDeletedAtIsNull(Integer userId);
}
