package com.example.skilltree.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "item_levels")
@Data
public class ItemLevel {

    @Embeddable
    @Data
    public static class ItemLevelId implements Serializable {
        @NotNull
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Item item;

        @NotNull
        @Min(1)
        private Integer level;
    }

    @EmbeddedId
    private ItemLevelId id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_level_requirements",
            joinColumns = {
                    @JoinColumn(name = "item_id"),
                    @JoinColumn(name = "level"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "required_item_id"),
                    @JoinColumn(name = "required_level"),
            }
    )
    private Collection<ItemLevel> requiredItemLevels;

}
