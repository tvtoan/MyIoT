package com.app.repository;

import com.app.entity.Farm;
import com.app.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {

    @Modifying
    @Query("SELECT f FROM Farm as f WHERE f.user = ?1")
    Iterable<Farm> getFarmOfUser(User user);

    Optional<Farm> findByFarmIdAndUserUserId(Long farmId, Long userId);

    boolean existsByFarmIdAndUserUserId(Long farmId, Long userId);
}
