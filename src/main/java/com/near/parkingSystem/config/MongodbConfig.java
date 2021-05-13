package com.near.parkingSystem.config;

import java.util.HashMap;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "vehicleEntityManagerFactory", transactionManagerRef = "vehicleTransactionManager", basePackages = {
    "com.near.parkingSystem.mongodbDatabase.repository" })
public class MongodbConfig {

  @Bean(name = "mongoDataSource")
  @ConfigurationProperties(prefix = "spring.mongo.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "vehicleEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean vehicleEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                            @Qualifier("mongoDataSource") DataSource dataSource) {
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
    return builder.dataSource(dataSource).properties(properties)
        .packages("com.near.parkingSystem.mongodbDatabase.entity").persistenceUnit("Vehicle").build();
  }

  @Bean(name = "vehicleTransactionManager")
  public PlatformTransactionManager vehicleTransactionManager(
      @Qualifier("vehicleEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
    return new JpaTransactionManager(bookEntityManagerFactory);
  }
}