//package com.example.skilltree.repository;
//
//import com.example.skilltree.model.ItemLevel;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Collection;
//import java.util.Optional;
//
//public interface ItemLevelRepository extends JpaRepository<ItemLevel, Long> {
//
//    @Query("SELECT il FROM ItemLevel il WHERE il.item.name = :name")
//    Collection<ItemLevel> findAllByName(@Param("name") String name);
//
//    @Query("SELECT il FROM ItemLevel il WHERE il.item.name = :name AND il.level = :level")
//    Optional<ItemLevel> findByNameAndLevel(@Param("name") String name,
//                                           @Param("level") int level);
//
//    @Query("SELECT ilr.requiredItemLevel \n" +
//            "FROM ItemLevelRequirement ilr  \n" +
//            "WHERE ilr.itemLevel.item.name = :name \n" +
//            "AND ilr.itemLevel.level = :level ")
//    Collection<ItemLevel> findAllRequiredByNameAndLevel(@Param("name") String name,
//                                                        @Param("level") int level);
//}
