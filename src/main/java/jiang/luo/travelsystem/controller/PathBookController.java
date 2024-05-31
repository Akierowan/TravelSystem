package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.PathBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "旅游路线相关接口")
@RestController
@RequestMapping("/pathbook")
@CrossOrigin
public class PathBookController {
    @Autowired
    private PathBookService pathBookService;

    /**
     * 旅游路线分页查询
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PageQueryDTO pageQueryDTO){
        try {
            PageResult pageResult = pathBookService.pageQuery(pageQueryDTO);
            return Result.success(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("分页查询失败");
        }
    }
    /**
     * 新增或变更路线
     */
    @ApiOperation("新增或变更路线")
    @PostMapping("/save")
    public Result save(@RequestBody PathBookDTO pathBookDTO){
        try {
            pathBookService.savePathBook(pathBookDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("保存路线失败");
        }
    }
    /**
     * 根据id查询路线信息
     */
    @ApiOperation("根据id查询路线信息")
    @GetMapping
    public Result<PathBook> queryPathById(@RequestParam Integer id){
        try {
            PathBook pathBook = pathBookService.getById(id);
            return Result.success(pathBook);
        } catch (Exception e) {
            return Result.error("无法获取改路线信息");
        }
    }
}
