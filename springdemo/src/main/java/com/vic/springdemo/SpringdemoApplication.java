package com.vic.springdemo;

import com.vic.springdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringdemoApplication  implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionTemplate transactionTemplate;


    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        showConnection();
//        showData();
        transactionDemo();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();

    }

    private void showData() {
        jdbcTemplate.queryForList("select name from t_user").forEach(row ->log.info(row.toString()));
        log.info(dataSource.toString());
        log.info("Count {}", jdbcTemplate.queryForObject("select count(*) from t_user",Long.class));
        List<User>  users = jdbcTemplate.query("select * from t_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return User.builder()
                        .id(resultSet.getLong(1))
                        .name(resultSet.getString(2))
                        .phone(resultSet.getString(3)).build();
            }
        });
        users.forEach(user -> log.info("user: {}",user));
    }

    private void transactionDemo() {
        log.info("COUNT BEFORE TRANSACTION :{}",getCount());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                jdbcTemplate.execute("insert into  t_user(id,phone,tname) values (3,15088777251,\"vic\")");
                log.info("COUNT IN TRANSACTION : {}",getCount());
                transactionStatus.setRollbackOnly();
            }
        });
        log.info("COUNT AFTER TRANSACTION : {}",getCount());
    }

    private long getCount() {

        return jdbcTemplate.queryForObject("select count(*) as cnt from t_user ",long.class);
    }
}
