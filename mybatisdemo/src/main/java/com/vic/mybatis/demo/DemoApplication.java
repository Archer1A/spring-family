package com.vic.mybatis.demo;

import com.github.pagehelper.PageInfo;
import com.vic.mybatis.demo.mapper.CoffeeMapper;
import com.vic.mybatis.demo.mapper.TUsersMapper;
import com.vic.mybatis.demo.model.Coffee;
import com.vic.mybatis.demo.model.TUsers;
import com.vic.mybatis.demo.model.TUsersExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
@MapperScan("com.vic.mybatis.demo.mapper")
public class DemoApplication implements ApplicationRunner {
    @Autowired
    CoffeeMapper coffeeMapper;
    @Autowired
    TUsersMapper usersMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        TUsersExample tUsersExample = new TUsersExample();
        tUsersExample.createCriteria().andUsernameEqualTo("admin");
        List<TUsers> tUsers = usersMapper.selectByExample(tUsersExample);
        /*Coffee c = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        int count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);

        c = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 25.0)).build();
        count = coffeeMapper.save(c);
        log.info("Save {} Coffee: {}", count, c);

        c = coffeeMapper.findById(Long.valueOf(count));
        log.info("Find Coffee: {}", c);*/
        coffeeMapper.findAllWithRouBounds(new RowBounds(1, 3))
            .forEach(c-> log.info("page(1) coffee {}" ,c));
        coffeeMapper.findAllWithRouBounds(new RowBounds(2,3)).forEach(c -> log.info("page(2) coffee{}",c));
        log.info("===========================");
        coffeeMapper.findAllWithRouBounds(new RowBounds(1, 0)).forEach(c -> log.info("page(3) coffee{}",c));
        log.info("===========================");
        coffeeMapper.findAllWithParam(1,3).forEach(c -> log.info("page(4) coffee{}",c));
        List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
        PageInfo page = new PageInfo(list);
        log.info("pageInfo {}" ,page);

    }
}
