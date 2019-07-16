package com.example.skilltree.repository;

import com.example.skilltree.model.ItemLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemLevelRepository extends JpaRepository<ItemLevel, Long> {

    @Query("SELECT il FROM ItemLevel il WHERE il.item.name = :name AND il.level = :level")
    Optional<ItemLevel> findByNameAndLevel(@Param("name") String name,
                                           @Param("level") int level);
}
