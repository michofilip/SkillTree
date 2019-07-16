package com.example.skilltree.mapper;

import com.example.skilltree.dto.ItemDto;
import com.example.skilltree.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ItemMapper {

    ItemDto toItemDto(Item item);

    @Mapping(target = "itemLevels", ignore = true)
    Item toItem(ItemDto itemDto);
}
