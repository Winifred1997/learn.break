package com.learn.api.article.repos;


import com.learn.api.article.entities.ArticleReadLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleReadLogRepo extends JpaRepository<ArticleReadLog, Long>, JpaSpecificationExecutor<ArticleReadLog> {

}
