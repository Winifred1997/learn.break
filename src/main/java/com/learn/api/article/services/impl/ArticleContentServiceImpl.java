package com.learn.api.article.services.impl;


import com.learn.api.article.entities.ArticleContent;
import com.learn.api.article.repos.ArticleContentRepo;
import com.learn.api.article.services.ArticleContentService;
import com.learn.api.user.entities.TeacherAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleContentServiceImpl implements ArticleContentService {

    @Autowired
    ArticleContentRepo articleContentRepo;

    @Override
    public List<ArticleContent> findByType(Integer type) {
        return articleContentRepo.findByType(type);
    }

    @Override
    public ArticleContent save(ArticleContent entity) {
        return articleContentRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        articleContentRepo.delete(id);
    }

    @Override
    public void delete(ArticleContent entity) {
        articleContentRepo.delete(entity);
    }

    @Override
    public ArticleContent findById(Long id) {
        return articleContentRepo.findOne(id);
    }

    @Override
    public ArticleContent findBySample(ArticleContent sample) {
        return articleContentRepo.findOne(Example.of(sample));
    }

    @Override
    public List<ArticleContent> findAll() {
        return articleContentRepo.findAll();
    }

    @Override
    public List<ArticleContent> findAll(Sort sort) {
        return articleContentRepo.findAll(sort);
    }

    @Override
    public List<ArticleContent> findBySamples(ArticleContent sample) {
        return articleContentRepo.findAll(Example.of(sample));
    }

    @Override
    public List<ArticleContent> findBySamples(ArticleContent sample, Sort sort) {
        return articleContentRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<ArticleContent> findBySamples(ArticleContent sample, PageRequest pageRequest) {
        return articleContentRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<ArticleContent> findBySamples(PageRequest pageRequest) {
        return articleContentRepo.findAll(pageRequest);
    }
}
