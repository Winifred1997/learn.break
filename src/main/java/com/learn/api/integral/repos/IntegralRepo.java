package com.learn.api.integral.repos;


import com.learn.api.integral.entities.Integral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IntegralRepo extends JpaRepository<Integral, Long>, JpaSpecificationExecutor<Integral> {

    Integral findByAccountId(Long accountId);

}
