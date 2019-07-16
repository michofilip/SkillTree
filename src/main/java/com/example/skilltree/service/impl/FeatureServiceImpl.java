package com.example.skilltree.service.impl;

import com.example.skilltree.dto.FeatureValueDto;
import com.example.skilltree.mapper.FeatureValueMapper;
import com.example.skilltree.model.FeatureValue;
import com.example.skilltree.model.ItemLevel;
import com.example.skilltree.repository.ItemLevelRepository;
import com.example.skilltree.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final ItemLevelRepository itemLevelRepository;
    private final FeatureValueMapper featureValueMapper;

    @Override
    public List<FeatureValueDto> findAllItemLevelFeatureValues(String name, int level) {
        List<FeatureValue> featureValues = itemLevelRepository.findByNameAndLevel(name, level)
                .map(ItemLevel::getFeatureValues)
                .orElseThrow();

        return featureValues.stream()
                .map(featureValueMapper::toFeatureValueDto)
                .collect(Collectors.toList());
    }
}
