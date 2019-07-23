package com.example.skilltree.repository;

import com.example.skilltree.enums.ItemType;
import com.example.skilltree.model.FeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface FeatureValueRepository extends JpaRepository<FeatureValue, Long> {

    @Query("SELECT fv FROM FeatureValue fv \n" +
            "WHERE fv.itemLevel.id.item.type = :type\n" +
            " AND fv.itemLevel.id.item.name = :name \n" +
            " AND fv.itemLevel.id.level = :level")
    Collection<FeatureValue> findByTypeNameLevel(@Param("type") ItemType type,
                                                 @Param("name") String name,
                                                 @Param("level") int level);
}
