package com.vic.springdemo;

import com.vic.springdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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


    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
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
}
