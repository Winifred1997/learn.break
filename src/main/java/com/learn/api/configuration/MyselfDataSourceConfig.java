//package com.learn.api.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//    entityManagerFactoryRef = "myselfEntityManagerFactory",
//    transactionManagerRef = "myselfTransactionManager",
//    basePackages = {"com.learn.api.user.repos", "com.learn.api.article.repos", "com.learn.api.integral.repos"})
////设置Repository所在位置
//
//public class MyselfDataSourceConfig {
//
//    @Autowired
//    @Qualifier("myselfDataSource")
//    private DataSource myselfDataSource;
//
//    @Bean(name = "myselfEntityManager")
//    @Primary
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return myselfEntityManagerFactory(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "myselfEntityManagerFactory")
//    @Primary
//    public LocalContainerEntityManagerFactoryBean myselfEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder
//            .dataSource(myselfDataSource)
//            .properties(getVendorProperties(myselfDataSource))
//            .packages("com.learn.api.user.entities", "com.learn.api.article.entities", "com.learn.api.integral.entities")
//            .persistenceUnit("myselfPersistenceUnit")
//            .build();
//    }
//
//    @Autowired
//    private JpaProperties jpaProperties;
//
//    private Map<String, String> getVendorProperties(DataSource dataSource) {
//        return jpaProperties.getHibernateProperties(dataSource);
//    }
//
//    @Bean(name = "myselfTransactionManager")
//    @Primary
//    public PlatformTransactionManager myselfTransactionManager(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(myselfEntityManagerFactory(builder).getObject());
//    }
//
//}
