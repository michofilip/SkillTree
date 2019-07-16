package com.example.skilltree.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(
        name = "item_levels",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"item_id", "level"})}
)
@Data
public class ItemLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Item item;

    @NotNull
    @Min(1)
    private Integer level;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_level_requirements",
            joinColumns = {@JoinColumn(name = "item_level_id")},
            inverseJoinColumns = {@JoinColumn(name = "required_item_level_id")}
    )
    private List<ItemLevel> requiredItemLevels;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "itemLevel")
    private List<FeatureValue> featureValues;
}
