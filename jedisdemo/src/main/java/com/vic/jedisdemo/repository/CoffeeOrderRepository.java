package com.vic.jedisdemo.repository;

import com.vic.jedisdemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CoffeeOrderRepository
 *
 * @author Vic
 * @date 2019/4/24
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder,Long> {
}
