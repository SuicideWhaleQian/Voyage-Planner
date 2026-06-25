package com.example.navigation.entity.ship;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_ships")
@Comment("船只表")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("船只id")
    private Integer shipId;

    @Comment("船只名称")
    private String shipName;

    @Comment("船只类型")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_type_id")
    private ShipType shipType;

    protected Ship() {
    }

    public Ship(String shipName, ShipType shipType) {
        this.shipName = shipName;
        this.shipType = shipType;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

}
