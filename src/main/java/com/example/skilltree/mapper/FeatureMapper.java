package com.example.skilltree.mapper;

import com.example.skilltree.dto.FeatureDto;
import com.example.skilltree.model.Feature;
import org.mapstruct.Mapper;

@Mapper
public interface FeatureMapper {

    FeatureDto toDto(Feature feature);

    Feature toEntity(FeatureDto featureDto);
}
