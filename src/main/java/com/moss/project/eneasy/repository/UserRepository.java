package com.moss.project.eneasy.repository;

import com.moss.project.eneasy.entity.User;

public interface UserRepository extends BaseJpaRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);
}
