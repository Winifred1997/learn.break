package com.learn.api.article.services;

public interface ArticleBusinessService{

    /**
     * 浏览文章
     * @param userId
     * @param articleId
     * @return
     */
    Long lookArticle(Long userId, Long articleId);

    /**
     * 查看文章浏览数量
     * @param articleId
     * @return
     */
    Long getLookNumber(Long articleId);

    /**
     * 点赞文章
     * @param userId
     * @param articleId
     * @return
     */
    Long likeArticle(Long userId, Long articleId);

    /**
     * 查看文章点赞数量
     * @param articleId
     * @return
     */
    Long getLikeNumber(Long articleId);

    /**
     * 评论文章
     * @param userId
     * @param articleId
     * @return
     */
    Long commentArticle(Long userId, Long articleId);

    /**
     * 查看文章评论数
     * @param id
     * @return
     */
    Long getCommentNumber(Long id);
}
