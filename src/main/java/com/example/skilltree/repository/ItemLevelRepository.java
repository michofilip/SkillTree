package com.example.skilltree.repository;

import com.example.skilltree.enums.ItemType;
import com.example.skilltree.model.ItemLevel;
import com.example.skilltree.model.ItemLevel.ItemLevelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemLevelRepository extends JpaRepository<ItemLevel, ItemLevelId> {

    @Query("SELECT il FROM ItemLevel il \n" +
            "WHERE il.id.item.type = :type\n" +
            " AND il.id.item.name = :name \n" +
            " AND il.id.level = :level")
    Optional<ItemLevel> findByTypeNameLevel(@Param("type") ItemType type,
                                            @Param("name") String name,
                                            @Param("level") int level);
}
