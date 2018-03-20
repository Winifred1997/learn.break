package com.learn.api.article.controllers;


import com.alibaba.fastjson.JSON;
import com.learn.api.article.beans.ArticleReadLogData;
import com.learn.api.article.entities.ArticleContent;
import com.learn.api.article.entities.ArticleReadLog;
import com.learn.api.article.services.ArticleContentService;
import com.learn.api.article.services.ArticleReadLogService;
import com.learn.api.common.ErrorCode;
import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.user.entities.TeacherAccount;
import com.learn.api.user.entities.UserInfo;
import com.learn.api.user.services.TeacherAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    TeacherAccountService teacherAccountService;

    @ApiOperation(value = "根据文章类型查看文章")
    @GetMapping("/findByType")
    public RestResult<List<ArticleContent>> findByType(@RequestParam("type") Integer type) {
        if (null == type) {
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        List<ArticleContent> articleContents = articleContentService.findByType(type);
        List<TeacherAccount> teacherAccounts = teacherAccountService.findAll();
        HashMap<Long, String> collect = teacherAccounts.stream().collect(HashMap::new, (map, teacher) -> map.put(teacher.getId(), teacher.getNickName()), HashMap::putAll);
        if (null != articleContents && 0 < articleContents.size()) {
            for (ArticleContent content : articleContents) {
                content.setTeacherName(collect.get(content.getTeacherAccountId()));
            }
        }
        return RestResultGenerator.genSuccessResult(articleContents);
    }

    @ApiOperation(value = "根据文章id查看文章")
    @GetMapping("/findById")
    public RestResult<ArticleContent> findById(@RequestParam("id") Long id) {
        if (null == id) {
            return RestResultGenerator.genErrorResult(ErrorCode.SERVER_ERROR_COMM);
        }
        ArticleContent content = articleContentService.findById(id);
        TeacherAccount teacherAccount = teacherAccountService.findById(content.getTeacherAccountId());
        if (null != teacherAccount && null != content) {
            content.setTeacherName(teacherAccount.getNickName());
        }
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
