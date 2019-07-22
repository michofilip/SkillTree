//package com.example.skilltree.mapper;
//
//import com.example.skilltree.dto.ItemLevelDto;
//import com.example.skilltree.model.ItemLevel;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//@Mapper
//public interface ItemLevelMapper {
//
//    @Mapping(target = "name", source = "item.name")
//    @Mapping(target = "type", source = "item.type")
//    ItemLevelDto toItemLevelDto(ItemLevel itemLevel);
//
//    @Mapping(target = "id", source = "itemLevelDto.id")
//    @Mapping(target = "level", source = "itemLevelDto.level")
//    @Mapping(target = "requiredItemLevels", ignore = true)
//    @Mapping(target = "featureValues", ignore = true)
//    @Mapping(target = "item", ignore = true)
//    ItemLevel toItemLevel(ItemLevelDto itemLevelDto);
//}
