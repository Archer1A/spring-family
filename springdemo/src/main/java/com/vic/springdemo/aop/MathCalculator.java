package com.vic.springdemo.aop;

import org.springframework.stereotype.Component;

/**
 * MathCalculator
 *
 * @author Vic
 * @date 2019/7/15
 */
@Component
public class MathCalculator {

    public double divide(double a, double b) throws Exception {
        if (b == 0) {
            throw new Exception("哈哈哈");
        }

        return a / b;
    }
}
