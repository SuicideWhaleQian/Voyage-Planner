package com.example.navigation.entity.ship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class ShipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("船型Id")
    private Integer shipTypeId;

    @Comment("船型名称")
    private String shipTypeName;

    @OneToMany(mappedBy = "shipType")
    private List<Ship> ships = new ArrayList<>();

    
}
