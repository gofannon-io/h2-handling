package com.bookstore.boot.persistence;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableJpaRepositories(basePackages = {"com.bookstore.boot.persistence"})
//@PropertySource("application-test.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.bookstore.boot.persistence"})
@ImportResource("classpath:h2-context.xml")
public class H2Configuration {

//    @Named
//    public Driver databaseDriver() {
//        return new org.h2.Driver();
//    }
//
//    @Named
//    @Inject
//    public DataSource dataSource(Driver driver) {
//        return new SimpleDriverDataSource(
//                driver,
//                "jdbc:h2:mem:testdv;DB_CLOSE_DELAY=-1",
//                "sa",
//                ""
//        );
//    }
//
//    public EntityManagerFactory


}
