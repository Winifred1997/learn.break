package com.learn.api.tag.controllers;

import com.learn.api.common.RestResult;
import com.learn.api.common.RestResultGenerator;
import com.learn.api.tag.entities.ArticleTag;
import com.learn.api.tag.services.ArticleTagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("文章内容API")
@RestController
@RequestMapping("/articleTag")
public class ArticleTagController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleTagController.class);

    @Autowired
    ArticleTagService articleTagService;

    @ApiOperation(value = "查询所有标签")
    @GetMapping("/findAll")
    public RestResult<List<ArticleTag>> findAll() {
        return RestResultGenerator.genSuccessResult(articleTagService.findAll());
    }

    @ApiOperation(value = "保存标签")
    @PostMapping("/save")
    public RestResult<ArticleTag> save(@RequestBody ArticleTag articleTag) {
        return RestResultGenerator.genSuccessResult(articleTagService.save(articleTag));
    }

}
