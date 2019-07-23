package com.example.skilltree.service.impl;

import com.example.skilltree.dto.FeatureValueDto;
import com.example.skilltree.enums.ItemType;
import com.example.skilltree.mapper.FeatureValueMapper;
import com.example.skilltree.repository.FeatureValueRepository;
import com.example.skilltree.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureValueRepository featureValueRepository;
    private final FeatureValueMapper featureValueMapper;

    @Override
    public List<FeatureValueDto> findByItemLevel(ItemType itemType, String name, int level) {
        return featureValueRepository.findByTypeNameLevel(itemType, name, level)
                .stream()
                .map(featureValueMapper::toDto)
                .collect(Collectors.toList());
    }
}
