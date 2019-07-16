package com.example.skilltree.service;

import com.example.skilltree.dto.FeatureValueDto;

import java.util.List;

public interface FeatureService {
    List<FeatureValueDto> findAllItemLevelFeatureValues(String name, int level);
}
