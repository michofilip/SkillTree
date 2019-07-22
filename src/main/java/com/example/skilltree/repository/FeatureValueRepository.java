//package com.example.skilltree.repository;
//
//import com.example.skilltree.model.FeatureValue;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Collection;
//
//public interface FeatureValueRepository extends JpaRepository<FeatureValue, Long> {
//
//    @Query("SELECT fv FROM FeatureValue fv \n" +
//            "WHERE fv.itemLevel.item.name = :name AND fv.itemLevel.level = :level")
//    Collection<FeatureValue> findByNameAndLevel(@Param("name") String name,
//                                                @Param("level") int level);
//}
