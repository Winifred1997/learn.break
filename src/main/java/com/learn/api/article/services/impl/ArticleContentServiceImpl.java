package com.learn.api.article.services.impl;


import com.learn.api.article.entities.ArticleContent;
import com.learn.api.article.repos.ArticleContentRepo;
import com.learn.api.article.services.ArticleContentService;
import com.learn.api.common.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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
        return articleContentRepo.findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (sample.getId() != null) {
                predicates.add(cb.equal(root.<Long>get("id"), sample.getId()));
            }
            if (sample.getTeacherAccountId()!= null) {
                predicates.add(cb.equal(root.<Long>get("teacherAccountId"), sample.getTeacherAccountId()));
            }
            if (sample.getType()!= null) {
                predicates.add(cb.equal(root.<Long>get("type"), sample.getType()));
            }
            List<Predicate> p = new ArrayList<>();
            if (StringUtils.hasLength(sample.getTeacherName())) {
                p.add(cb.like(root.get("teacherName"), Utils.getLikePattern(sample.getTeacherName())));
            }
            if (StringUtils.hasLength(sample.getTitle())) {
                p.add(cb.like(root.get("title"), Utils.getLikePattern(sample.getTitle())));
            }
            if (StringUtils.hasLength(sample.getContent())) {
                p.add(cb.like(root.get("content"), Utils.getLikePattern(sample.getContent())));
            }
            if (!p.isEmpty()) {
                Predicate or = cb.or(p.toArray(new Predicate[predicates.size()]));
                predicates.add(or);
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        }, pageRequest);
    }

    @Override
    public Page<ArticleContent> findBySamples(PageRequest pageRequest) {
        return articleContentRepo.findAll(pageRequest);
    }
}
