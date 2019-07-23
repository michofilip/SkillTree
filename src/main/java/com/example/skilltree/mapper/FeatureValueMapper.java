package com.example.skilltree.mapper;

import com.example.skilltree.dto.FeatureValueDto;
import com.example.skilltree.model.FeatureValue;
import org.mapstruct.Mapper;

@Mapper(uses = {FeatureMapper.class, ItemLevelMapper.class})
public interface FeatureValueMapper {

    FeatureValueDto toDto(FeatureValue featureValue);

    FeatureValue toEntity(FeatureValueDto featureValueDto);
}
