package com.learn.api.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by wjl on 17/06/2017.
 * IBaseService
 */
public interface BaseService<T> {
    T save(T entity);

    void delete(Long id);

    void delete(T entity);

    T findById(Long id);

    T findBySample(T sample);

    List<T> findAll();

    List<T> findAll(Sort sort);

    List<T> findBySamples(T sample);

    List<T> findBySamples(T sample, Sort sort);

    Page<T> findBySamples(T sample, PageRequest pageRequest);

    Page<T> findBySamples(PageRequest pageRequest);
}
