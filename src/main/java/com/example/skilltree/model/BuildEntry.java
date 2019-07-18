//package com.example.skilltree.model;
//
//import lombok.Data;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Table(name = "build_entities")
//@Data
//public class BuildEntry {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @NotNull
//    private Build build;
//
//    @ManyToOne
//    @NotNull
//    private ItemLevel itemLevel;
//
//    @NotNull
//    @Min(1)
//    private Integer orderNumber;
//}
