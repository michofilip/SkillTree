package com.example.skilltree.dto;

import com.example.skilltree.enums.ItemType;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemLevelDto {
    private Long id;
    private ItemType type;
    private String name;
    private Integer level;
}
