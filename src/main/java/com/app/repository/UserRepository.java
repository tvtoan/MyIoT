package com.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.password = ?1 WHERE u.id = ?2")
    void changePassword(String password, Long id);
	
}
