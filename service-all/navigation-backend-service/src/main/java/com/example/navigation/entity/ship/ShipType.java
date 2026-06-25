package com.example.navigation.entity.ship;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.Recruitment.Recruitment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_ship_types")
@Comment("船只类型")
public class ShipType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("船只类型Id")
    private Integer shipTypeId;

    @Comment("船只类型名称")
    private String shipTypeName;

    @OneToMany(mappedBy = "shipType")
    private List<Ship> ships = new ArrayList<>();

    @OneToMany(mappedBy = "shipType")
    private List<Recruitment> recruitments = new ArrayList<>();

    protected ShipType() {
    }

    public ShipType(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }

    public Integer getShipTypeId() {
        return shipTypeId;
    }

    public void setShipTypeId(Integer shipTypeId) {
        this.shipTypeId = shipTypeId;
    }

    public String getShipTypeName() {
        return shipTypeName;
    }

    public void setShipTypeName(String shipTypeName) {
        this.shipTypeName = shipTypeName;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

}
