package com.example.skilltree.service.impl;

import com.example.skilltree.dto.ItemDto;
import com.example.skilltree.dto.ItemLevelDto;
import com.example.skilltree.enums.ItemType;
import com.example.skilltree.mapper.ItemLevelMapper;
import com.example.skilltree.mapper.ItemMapper;
import com.example.skilltree.model.Item;
import com.example.skilltree.model.ItemLevel;
import com.example.skilltree.repository.ItemLevelRepository;
import com.example.skilltree.repository.ItemRepository;
import com.example.skilltree.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemLevelRepository itemLevelRepository;
    private final ItemMapper itemMapper;
    private final ItemLevelMapper itemLevelMapper;

    @Override
    public List<ItemDto> findAllItems(ItemType itemType) {
        return itemRepository.findAllByType(itemType)
                .stream()
                .map(itemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto findItemByName(ItemType itemType, String name) {
        return itemRepository.findByTypeAndName(itemType, name)
                .map(itemMapper::toItemDto)
                .orElseThrow();
    }

    @Override
    public List<ItemLevelDto> findAllItemLevels(ItemType itemType, String name) {
        List<ItemLevel> itemLevels = itemRepository.findByTypeAndName(itemType, name)
                .map(Item::getItemLevels)
                .orElseThrow();

        return itemLevels.stream()
                .map(itemLevelMapper::toItemLevelDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemLevelDto findItemLevel(String name, int level) {
        return itemLevelRepository.findByNameAndLevel(name, level)
                .map(itemLevelMapper::toItemLevelDto)
                .orElseThrow();
    }

    @Override
    public List<ItemLevelDto> findAllItemLevelRequirements(String name, int level) {
        List<ItemLevel> itemLevelRequirements = itemLevelRepository.findByNameAndLevel(name, level)
                .map(ItemLevel::getRequiredItemLevels)
                .orElseThrow();

        return itemLevelRequirements.stream()
                .map(itemLevelMapper::toItemLevelDto)
                .collect(Collectors.toList());
    }
}
