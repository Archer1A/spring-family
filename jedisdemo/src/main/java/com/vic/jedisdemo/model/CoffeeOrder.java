package com.vic.jedisdemo.model;

import lombok.*;
import org.aspectj.lang.annotation.DeclareAnnotation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * CoffeeOrder
 *
 * @author Vic
 * @date 2019/4/24
 */
@Entity
@Table(name = "T_ORDER")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {

    private String customer;

    @ManyToMany
    @JoinTable(name = "T_ORDER_COFFEE")
    @OrderBy("id")
    private List<Coffee> items;

    @Enumerated
    @Column(nullable = false)
    private OrderState state;

}
