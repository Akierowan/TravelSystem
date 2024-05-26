package jiang.luo.travelsystem.controller;

import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.PathBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathbook")
public class PathBookController {
    @Autowired
    private PathBookService pathBookService;

    @GetMapping("/page")
    public Result<PageResult> page() {
        PageResult pageResult = pathBookService.pageQuery(1, 10);
        return Result.success(pageResult);
    }


}
