package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.ApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="申请信息相关接口")
@RestController
@RequestMapping("/applyinfo")
@CrossOrigin
public class ApplyInfoController {
    @Autowired
    private ApplyInfoService applyInfoService;

    /**
     * 第一次申请
     */
    @ApiOperation("初次提交申请")
    @PostMapping("/firstapply")
    public Result firstApply(@RequestBody FirstApplyDTO firstApplyDTO) {
        try {
            applyInfoService.saveFirstApply(firstApplyDTO);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("初次申请失败");
        }
    }



    /**
     * 支付订金
     */
    @ApiOperation("支付订金")
    @PutMapping("/paydeposit")
    public Result payDeposit(@RequestParam Integer id) {
        try {
            applyInfoService.payDeposit(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("订金支付失败");
        }
    }

    /**
     * 支付余款
     */
    @ApiOperation("支付余款")
    @PostMapping("/paybalance")
    public Result payBalance(@RequestParam Integer id) {
        try {
            applyInfoService.payBalance(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("余款支付失败");
        }
    }

    /**
     * 分页查询
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PageQueryDTO pageQueryDTO){
        try {
            PageResult pageResult = applyInfoService.pageQuery(pageQueryDTO);
            return Result.success(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("分页查询失败");
        }
    }

    /**
     * 取消整个申请
     */
    @ApiOperation("取消整个申请")
    @PutMapping("/cancel")
    public Result cancelApply(Integer id){
        try {
            applyInfoService.cancelApply(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("取消申请失败");
        }
    }

}
