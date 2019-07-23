package com.example.skilltree.service;

import com.example.skilltree.dto.FeatureValueDto;
import com.example.skilltree.enums.ItemType;

import java.util.List;

public interface FeatureService {
    List<FeatureValueDto> findByItemLevel(ItemType itemType, String name, int level);
}
