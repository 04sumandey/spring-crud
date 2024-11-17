package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.respository;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findById(Long id);
}
