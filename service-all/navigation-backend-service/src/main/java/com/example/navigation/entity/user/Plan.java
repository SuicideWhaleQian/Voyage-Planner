package com.example.navigation.entity.user;

import org.hibernate.annotations.Comment;

import com.example.navigation.entity.position.PositionLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_plans")
@Comment("用户规划表")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("规划Id")
    private Integer planId;

    @Comment("规划隶属用户")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("目前岗位")
    @JoinColumn(name = "current_position_id", nullable = true)
    private PositionLevel currentPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @Comment("目标岗位")
    @JoinColumn(name = "target_position_id", nullable = true)
    private PositionLevel targetPosition;

    protected Plan() {

    }

    public Plan(Integer planId, User user, PositionLevel currentPosition, PositionLevel targetPosition) {
        this.planId = planId;
        this.user = user;
        this.currentPosition = currentPosition;
        this.targetPosition = targetPosition;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PositionLevel getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(PositionLevel currentPosition) {
        this.currentPosition = currentPosition;
    }

    public PositionLevel getTargetPosition() {
        return targetPosition;
    }

    public void setTargetPosition(PositionLevel targetPosition) {
        this.targetPosition = targetPosition;
    }

}
