package com.example.skilltree.service;

import com.example.skilltree.dto.ItemDto;
import com.example.skilltree.dto.ItemLevelDto;
import com.example.skilltree.enums.ItemType;

import java.util.List;

public interface ItemService {

    List<ItemDto> findAllItems(ItemType itemType);

    ItemDto findItemByName(ItemType itemType, String name);

    List<ItemLevelDto> findAllItemLevels(ItemType itemType, String name);

    ItemLevelDto findItemLevel(ItemType itemType, String name, int level);

    List<ItemLevelDto> findAllItemLevelRequirements(ItemType itemType, String name, int level);
}
