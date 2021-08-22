package com.kdt.lecture;

import com.kdt.lecture.repository.CustomerMapper;
import com.kdt.lecture.repository.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
public class MybatisTest {

    static final String DROP_TABLE_SQL = "DROP TABLE customers IF EXISTS";
    static final String CREATE_TABLE_SQL = "CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CustomerMapper mapper;


    @Test
    void save_test() {
        // Given
        jdbcTemplate.execute(DROP_TABLE_SQL);
        jdbcTemplate.execute(CREATE_TABLE_SQL);

        Customer customer = new Customer(1L, "honggu", "kang");

        // When
        mapper.save(customer);

        // Then
        Customer selectedCustomer = mapper.findById(1L);
        log.info(selectedCustomer.getFirstName());
    }

}
