package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.FinanceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "财务报表相关接口")
@RestController
@RequestMapping("/financebook")
@CrossOrigin
public class FinanceBookController {
    @Autowired
    private FinanceBookService financeBookService;

    /**
     * 财务报表分页查询
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PageQueryDTO pageQueryDTO) {
        try {
            PageResult pageResult = financeBookService.pageQuery(pageQueryDTO);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("分页查询失败");
        }
    }
}
