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
                .map(itemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDto findItemByName(ItemType itemType, String name) {
        return itemRepository.findByTypeAndName(itemType, name)
                .map(itemMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<ItemLevelDto> findAllItemLevels(ItemType itemType, String name) {
        Item item = itemRepository.findByTypeAndName(itemType, name).orElseThrow();
        return item.getItemLevels()
                .stream()
                .map(itemLevelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ItemLevelDto findItemLevel(ItemType itemType, String name, int level) {
        return itemLevelRepository.findByTypeNameLevel(itemType, name, level)
                .map(itemLevelMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<ItemLevelDto> findAllItemLevelRequirements(ItemType itemType, String name, int level) {
        ItemLevel itemLevel = itemLevelRepository.findByTypeNameLevel(itemType, name, level).orElseThrow();
        return itemLevel.getRequiredItemLevels()
                .stream()
                .map(itemLevelMapper::toDto)
                .collect(Collectors.toList());
    }
}
