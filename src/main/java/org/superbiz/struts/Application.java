package org.superbiz.struts;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {

    @Value("${spring.datasource.url}") String url;
    @Value("${spring.datasource.username}") String username;


    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name="superBizDataSource")
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);

        return dataSource;
    }
}
