package com.learn.api.tag.repos;


import com.learn.api.tag.entities.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleTagRepo extends JpaRepository<ArticleTag, Long>, JpaSpecificationExecutor<ArticleTag> {

}
