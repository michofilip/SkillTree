package com.example.skilltree.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemLevelDto {
    private ItemDto item;
    private Integer level;
}
