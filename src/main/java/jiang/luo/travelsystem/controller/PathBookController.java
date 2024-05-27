package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.pojo.PathBookDTO;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.PathBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "旅游路线相关接口")
@RestController
@RequestMapping("/pathbook")
public class PathBookController {
    @Autowired
    private PathBookService pathBookService;

    /**
     * 旅游路线分页查询
     * @return
     */
    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Result<PageResult> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        try {
            PageResult pageResult = pathBookService.pageQuery(pageNum, pageSize);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("分页查询失败");
        }
    }

    /**
     * 新增或变更路线
     * @param pathBookDTO
     * @return
     */
    @ApiOperation("新增或变更路线")
    @PostMapping("save")
    public Result save(@RequestBody PathBookDTO pathBookDTO){
        try {
            pathBookService.savePathBook(pathBookDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("保存路线失败");
        }
    }

    /**
     * 逻辑删除路线
     * @param id
     * @return
     */
    @ApiOperation("逻辑删除路线")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        try {
            pathBookService.deletePathLogicallyById(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("删除路线失败");
        }
    }

    /**
     * 根据id查询路线信息
     * @param id
     * @return
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
