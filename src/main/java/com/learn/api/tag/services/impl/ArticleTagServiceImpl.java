package com.learn.api.tag.services.impl;

import com.learn.api.tag.entities.ArticleTag;
import com.learn.api.tag.repos.ArticleTagRepo;
import com.learn.api.tag.services.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    @Autowired
    ArticleTagRepo articleTagRepo;

    @Override
    public ArticleTag save(ArticleTag entity) {
        return articleTagRepo.save(entity);
    }

    @Override
    public void delete(Long id) {
        articleTagRepo.delete(id);
    }

    @Override
    public void delete(ArticleTag entity) {
        articleTagRepo.delete(entity);
    }

    @Override
    public ArticleTag findById(Long id) {
        return articleTagRepo.findOne(id);
    }

    @Override
    public ArticleTag findBySample(ArticleTag sample) {
        return articleTagRepo.findOne(Example.of(sample));
    }

    @Override
    public List<ArticleTag> findAll() {
        return articleTagRepo.findAll();
    }

    @Override
    public List<ArticleTag> findAll(Sort sort) {
        return articleTagRepo.findAll(sort);
    }

    @Override
    public List<ArticleTag> findBySamples(ArticleTag sample) {
        return articleTagRepo.findAll(Example.of(sample));
    }

    @Override
    public List<ArticleTag> findBySamples(ArticleTag sample, Sort sort) {
        return articleTagRepo.findAll(Example.of(sample), sort);
    }

    @Override
    public Page<ArticleTag> findBySamples(ArticleTag sample, PageRequest pageRequest) {
        return articleTagRepo.findAll(Example.of(sample), pageRequest);
    }

    @Override
    public Page<ArticleTag> findBySamples(PageRequest pageRequest) {
        return articleTagRepo.findAll(pageRequest);
    }

}
