package config;

import com.mysql.cj.jdbc.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
@ComponentScan(basePackages ="DAOImpl")
public class SpringConfig {
    @Bean
    public DataSource getConnection(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/bank_db1");
        dataSource.setUsername("root");
        dataSource.setPassword("Nadesh@123");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }
    @Bean
    public JdbcTemplate getTemplate(DataSource dataSource){
        return new  JdbcTemplate(dataSource);
    }
}
