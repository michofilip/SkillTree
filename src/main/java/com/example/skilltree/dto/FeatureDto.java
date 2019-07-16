package com.example.skilltree.dto;

import com.example.skilltree.enums.FeatureType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FeatureDto {
    private Long id;
    private String name;
    private String title;
    private FeatureType type;
}
