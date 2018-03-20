package com.learn.api.article.services.impl;


import com.learn.api.article.entities.ArticleReadLog;
import com.learn.api.article.repos.ArticleReadLogRepo;
import com.learn.api.article.services.ArticleReadLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleReadLogServiceImpl implements ArticleReadLogService {

    @Autowired
    ArticleReadLogRepo articleReadLogRepo;

    @Override
    public ArticleReadLog save(ArticleReadLog entity) {
        return articleReadLogRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        articleReadLogRepo.delete(id);
    }

    @Override
    public void delete(ArticleReadLog entity) {
        articleReadLogRepo.delete(entity);
    }

    @Override
    public ArticleReadLog findById(Long id) {
        return articleReadLogRepo.findOne(id);
    }

    @Override
    public ArticleReadLog findBySample(ArticleReadLog sample) {
        return articleReadLogRepo.findOne(Example.of(sample));
    }

    @Override
    public List<ArticleReadLog> findAll() {
        return articleReadLogRepo.findAll();
    }

    @Override
    public List<ArticleReadLog> findAll(Sort sort) {
        return articleReadLogRepo.findAll(sort);
    }

    @Override
    public List<ArticleReadLog> findBySamples(ArticleReadLog sample) {
        return articleReadLogRepo.findAll(Example.of(sample));
    }

    @Override
    public List<ArticleReadLog> findBySamples(ArticleReadLog sample, Sort sort) {
        return articleReadLogRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<ArticleReadLog> findBySamples(ArticleReadLog sample, PageRequest pageRequest) {
        return articleReadLogRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<ArticleReadLog> findBySamples(PageRequest pageRequest) {
        return articleReadLogRepo.findAll(pageRequest);
    }
}
