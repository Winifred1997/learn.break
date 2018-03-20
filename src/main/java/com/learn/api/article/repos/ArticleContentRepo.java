package com.learn.api.article.repos;


import com.learn.api.article.entities.ArticleContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ArticleContentRepo extends JpaRepository<ArticleContent, Long>, JpaSpecificationExecutor<ArticleContent> {

    List<ArticleContent> findByType(Integer type);

}
