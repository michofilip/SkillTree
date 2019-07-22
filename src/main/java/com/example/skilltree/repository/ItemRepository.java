//package com.example.skilltree.repository;
//
//import com.example.skilltree.enums.ItemType;
//import com.example.skilltree.model.Item;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Collection;
//import java.util.Optional;
//
//public interface ItemRepository extends JpaRepository<Item, Long> {
//
//    Collection<Item> findAllByType(ItemType type);
//
//    Optional<Item> findByTypeAndName(ItemType type, String name);
//}
