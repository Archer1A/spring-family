package com.vic.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * CoffeeOrder
 *
 * @author Vic
 * @date 2019/3/9
 */
@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder extends BaseEntity implements Serializable {

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    private List<Coffee> coffees;
    @Column(nullable = false)
    private OrderState state;



}
