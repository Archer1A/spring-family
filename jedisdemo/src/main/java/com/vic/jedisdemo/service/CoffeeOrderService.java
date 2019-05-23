package com.vic.jedisdemo.service;

import com.vic.jedisdemo.model.Coffee;
import com.vic.jedisdemo.model.CoffeeOrder;
import com.vic.jedisdemo.model.OrderState;
import com.vic.jedisdemo.repository.CoffeeOrderRepository;
import com.vic.jedisdemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * CoffeeService
 *
 * @author Vic
 * @date 2019/4/24
 */
@Service
@Slf4j
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository orderRepository;

    public CoffeeOrder createOrder(String customer, Coffee... coffees) {
        CoffeeOrder order = CoffeeOrder.builder().customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder saved = orderRepository.save(order);
        log.info("new order: {}", saved);
        return saved;
    }

    public boolean updateState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0){
            log.warn("Wrong State order: {}, {}",state,order.getState());
            return false;
        }
        order.setState(state);
        orderRepository.save(order);
        log.info("Update Order : {}", order);
        return true;

    }
}
