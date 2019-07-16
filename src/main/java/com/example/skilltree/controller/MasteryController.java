package com.example.skilltree.controller;

import com.example.skilltree.dto.FeatureValueDto;
import com.example.skilltree.dto.ItemDto;
import com.example.skilltree.dto.ItemLevelDto;
import com.example.skilltree.enums.ItemType;
import com.example.skilltree.service.FeatureService;
import com.example.skilltree.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/masteries")
@RequiredArgsConstructor
public class MasteryController {

    private final ItemService itemService;
    private final FeatureService featureService;

    @GetMapping
    public List<ItemDto> findAllMasteries() {
        return itemService.findAllItems(ItemType.MASTERY);
    }

    @GetMapping("/{name}")
    public ItemDto findMasteryByName(@PathVariable String name) {
        return itemService.findItemByName(ItemType.MASTERY, name);
    }

    @GetMapping("/{name}/levels")
    public List<ItemLevelDto> findAllMasteryLevels(@PathVariable String name) {
        return itemService.findAllItemLevels(ItemType.MASTERY, name);
    }

    @GetMapping("/{name}/levels/{level}")
    public ItemLevelDto findMasteryLevel(@PathVariable String name,
                                         @PathVariable int level) {
        return itemService.findItemLevel(name, level);
    }

    @GetMapping("/{name}/levels/{level}/requirements")
    public List<ItemLevelDto> findAllMasteryLevelRequirements(@PathVariable String name,
                                                              @PathVariable int level) {
        return itemService.findAllItemLevelRequirements(name, level);
    }

    @GetMapping("/{name}/levels/{level}/features")
    public List<FeatureValueDto> findAllMasteryLevelFeatureValues(@PathVariable String name,
                                                                  @PathVariable int level) {
        return featureService.findAllItemLevelFeatureValues(name, level);
    }
}
