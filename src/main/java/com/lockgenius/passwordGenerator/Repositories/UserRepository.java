package com.lockgenius.passwordGenerator.Repositories;

import com.lockgenius.passwordGenerator.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}