package com.learn.api.article.controllers;


import com.alibaba.fastjson.JSON;
import com.learn.api.article.entities.ArticleContent;
import com.learn.api.article.entities.ArticleReadLog;
import com.learn.api.article.services.ArticleBusinessService;
import com.learn.api.article.services.ArticleContentService;
import com.learn.api.article.services.ArticleReadLogService;
import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.common.Utils.Utils;
import com.learn.api.user.entities.UserAccount;
import com.learn.api.user.services.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Api("文章内容API")
@RestController
@RequestMapping("/article")
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleContentService articleContentService;

    @Autowired
    ArticleReadLogService articleReadLogService;

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    ArticleBusinessService articleBusinessService;

    @ApiOperation(value = "根据文章属性查看文章")
    @PostMapping("/findBySamples")
    public RestResult<List<ArticleContent>> findByType(@RequestBody ArticleContent articleContent) {
        List<ArticleContent> articleContents = articleContentService.findBySamples(articleContent);
        List<UserAccount> userAccounts = userAccountService.findAll();
        HashMap<Long, String> collect = userAccounts.stream().collect(HashMap::new, (map, teacher) -> map.put(teacher.getId(), teacher.getNickName()), HashMap::putAll);
        if (null != articleContents && 0 < articleContents.size()) {
            for (ArticleContent content : articleContents) {
                content.setUserName(collect.get(content.getUserId()));
            }
        }
        return RestResultGenerator.genSuccessResult(articleContents);
    }

    @ApiOperation(value = "分页查询文章")
    @GetMapping("/findByPage")
    public RestResult<Page<ArticleContent>> findByType(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sort,
        @RequestParam(defaultValue = "asc") String direction,
        @ModelAttribute ArticleContent articleContent) {
        Page<ArticleContent> articleContents = articleContentService.findBySamples(articleContent, new PageRequest(page, size,
            new Sort(Sort.Direction.fromString(direction), sort)));
        //循环文章查询浏览数、点赞数、评论数
        if (null != articleContents.getContent() && 0 < articleContents.getContent().size()) {
            for (ArticleContent content : articleContents.getContent()) {
                content.setLookNumber(articleBusinessService.getLookNumber(content.getId()));
                content.setLikeNumber(articleBusinessService.getLikeNumber(content.getId()));
                content.setCommentNumber(articleBusinessService.getCommentNumber(content.getId()));
            }
        }
        return RestResultGenerator.genSuccessResult(articleContents);
    }

    @ApiOperation(value = "保存文章")
    @PostMapping("/save")
    public RestResult<ArticleContent> save(@RequestBody ArticleContent articleContent) {
        //校验是否信息完整
        if (null == articleContent.getType()) {
            return RestResultGenerator.genErrorResult(ErrorCode.ARTICLE_NOT_HAVE_TYPE);
        }
        if (null != articleContent.getId()) {
            ArticleContent article = articleContentService.findById(articleContent.getId());
            BeanUtils.copyProperties(articleContent, article, Utils.getNullPropertyNames(articleContent));
            article.setUpdateTime(Calendar.getInstance().getTime());
            return RestResultGenerator.genSuccessResult(articleContentService.save(article));
        }
        return RestResultGenerator.genSuccessResult(articleContentService.save(articleContent));
    }

    @ApiOperation(value = "删除文章")
    @PostMapping("/delete")
    public RestResult delete(@RequestBody ArticleContent articleContent) {
        if (null == articleContent.getId()) {
            return RestResultGenerator.genErrorResult(ErrorCode.PARAMETER_ERROR);
        }
        articleContentService.delete(articleContent.getId());
        return RestResultGenerator.genSuccessResult(ErrorCode.OK_ERROR);
    }

    @ApiOperation(value = "根据文章id查看文章")
    @GetMapping("/findById")
    public RestResult<ArticleContent> findById(@RequestParam("id") Long id) {
        if (null == id) {
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        ArticleContent content = articleContentService.findById(id);
        UserAccount userAccount = userAccountService.findById(content.getUserId());
        if (null != userAccount && null != content) {
            content.setUserName(userAccount.getNickName());
        }
        //累计浏览次数
        articleBusinessService.lookArticle(id);
        return RestResultGenerator.genSuccessResult(content);
    }

    @ApiOperation(value = "保存文章浏览历史")
    @PostMapping("/saveReadLog")
    public RestResult<ArticleReadLog> saveReadLog(@RequestBody ArticleReadLog articleReadLog) {
        if (null == articleReadLog.getAccountId() || null == articleReadLog.getTeacherAccountId()) {
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        return RestResultGenerator.genSuccessResult(articleReadLogService.save(articleReadLog));
    }

    @ApiOperation(value = "查看文章浏览历史")
    @GetMapping("/findReadLog")
    public RestResult<Page<ArticleReadLog>> findReadLog(@RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "20") int size,
                                                        @RequestParam(defaultValue = "asc") String sort,
                                                        @RequestParam(defaultValue = "id") String direction,
                                                        @ModelAttribute ArticleReadLog sample) {
        LOGGER.debug(" findReadLog : {}", JSON.toJSONString(sample));
        Page<ArticleReadLog> samples = articleReadLogService.findBySamples(sample,
            new PageRequest(page, size,
                new Sort(Sort.Direction.fromString(direction), sort)));
        return RestResultGenerator.genSuccessResult(samples);
    }

}
