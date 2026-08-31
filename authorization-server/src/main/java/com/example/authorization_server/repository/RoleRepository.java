package com.example.authorization_server.repository;

import com.example.authorization_server.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Collection<RoleEntity> findByIdIn(List<String> ids);
}
