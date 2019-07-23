package com.example.skilltree.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FeatureValueDto {
    private Long id;
    private FeatureDto feature;
    private ItemLevelDto itemLevel;
    private Double value;
}
