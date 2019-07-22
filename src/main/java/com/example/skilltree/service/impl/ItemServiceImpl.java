//package com.example.skilltree.service.impl;
//
//import com.example.skilltree.dto.ItemDto;
//import com.example.skilltree.dto.ItemLevelDto;
//import com.example.skilltree.enums.ItemType;
//import com.example.skilltree.mapper.ItemLevelMapper;
//import com.example.skilltree.mapper.ItemMapper;
//import com.example.skilltree.repository.ItemLevelRepository;
//import com.example.skilltree.repository.ItemRepository;
//import com.example.skilltree.service.ItemService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ItemServiceImpl implements ItemService {
//
//    private final ItemRepository itemRepository;
//    private final ItemLevelRepository itemLevelRepository;
//    private final ItemMapper itemMapper;
//    private final ItemLevelMapper itemLevelMapper;
//
//    @Override
//    public List<ItemDto> findAllItems(ItemType itemType) {
//        return itemRepository.findAllByType(itemType)
//                .stream()
//                .map(itemMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ItemDto findItemByName(ItemType itemType, String name) {
//        return itemRepository.findByTypeAndName(itemType, name)
//                .map(itemMapper::toDto)
//                .orElseThrow();
//    }
//
//    @Override
//    public List<ItemLevelDto> findAllItemLevels(ItemType itemType, String name) {
//        return itemLevelRepository.findAllByName(name)
//                .stream()
//                .map(itemLevelMapper::toItemLevelDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public ItemLevelDto findItemLevel(String name, int level) {
//        return itemLevelRepository.findByNameAndLevel(name, level)
//                .map(itemLevelMapper::toItemLevelDto)
//                .orElseThrow();
//    }
//
//    @Override
//    public List<ItemLevelDto> findAllItemLevelRequirements(String name, int level) {
//        return itemLevelRepository.findAllRequiredByNameAndLevel(name, level)
//                .stream()
//                .map(itemLevelMapper::toItemLevelDto)
//                .collect(Collectors.toList());
//    }
//}
