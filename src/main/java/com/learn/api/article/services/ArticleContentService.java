package com.learn.api.article.services;

import com.learn.api.article.entities.ArticleContent;
import com.learn.api.common.BaseService;

import java.util.List;

public interface ArticleContentService extends BaseService<ArticleContent> {

    List<ArticleContent> findByType(Integer type);

}
