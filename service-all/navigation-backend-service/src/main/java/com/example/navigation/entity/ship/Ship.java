package com.example.navigation.entity.ship;

import org.hibernate.annotations.Comment;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("船支id")
    private Integer shipId;

    @Comment("船支名称")
    private String shipName;

    @Comment("船支类型")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_type_id")
    private ShipType type;
}
