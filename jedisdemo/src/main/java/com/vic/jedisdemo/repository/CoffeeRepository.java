package com.vic.jedisdemo.repository;

import com.vic.jedisdemo.model.Coffee;
import com.vic.jedisdemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CoffeeRepository
 *
 * @author Vic
 * @date 2019/4/24
 */
public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
}
