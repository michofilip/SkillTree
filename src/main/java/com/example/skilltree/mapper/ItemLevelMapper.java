package com.example.skilltree.mapper;

import com.example.skilltree.dto.ItemLevelDto;
import com.example.skilltree.model.ItemLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ItemMapper.class})
public interface ItemLevelMapper {

    @Mapping(target = "item", source = "id.item")
    @Mapping(target = "level", source = "id.level")
    ItemLevelDto toDto(ItemLevel itemLevel);

    @Mapping(target = "id.item", source = "item")
    @Mapping(target = "id.level", source = "level")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "requiredItemLevels", ignore = true)
    @Mapping(target = "featureValues", ignore = true)
    ItemLevel toEntity(ItemLevelDto itemLevelDto);
}
