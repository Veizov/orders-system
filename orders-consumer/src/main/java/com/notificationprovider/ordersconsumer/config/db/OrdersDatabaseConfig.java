package com.notificationprovider.ordersconsumer.config.db;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(
        basePackages = {"com.notificationprovider.ordersconsumer.repository"},
        entityManagerFactoryRef = "ordersEntityManager",
        transactionManagerRef = "ordersTransactionManager"
)
public class OrdersDatabaseConfig {

    private final Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean ordersEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(ordersDataSource());
        em.setPackagesToScan("com.notificationprovider.ordersconsumer.domain.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", env.getProperty("orders.jpa.database-platform"));
        properties.put("hibernate.show_sql", env.getProperty("orders.hibernate.show_sql"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "orders.datasource")
    public DataSource ordersDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager ordersTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(ordersEntityManager().getObject());
        return transactionManager;
    }

}