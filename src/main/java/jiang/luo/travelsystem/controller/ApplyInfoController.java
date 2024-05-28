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
     * @param firstApplyDTO
     * @return
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
     * 根据姓名查找订单信息
     * @param name
     * @return
     */
    @ApiOperation("根据负责人姓名查找申请信息")
    @GetMapping
    public Result<List<ApplyInfo>> getByName(@RequestParam String name){
        try {
            List<ApplyInfo> applyInfoList = applyInfoService.getByName(name);
            return Result.success(applyInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查找申请信息失败");
        }
    }

    /**
     * 支付订金
     * @param id
     * @return
     */
    @ApiOperation("支付订金")
    @PostMapping("/paydeposit")
    public Result payDeposit(@RequestParam Integer id) {
        try {
            applyInfoService.payDeposit(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("订金支付失败");
        }
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @ApiOperation("分页查询")
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PageQueryDTO pageQueryDTO){
        try {
            PageResult pageResult = applyInfoService.pageQuery(pageQueryDTO);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("分页查询失败");
        }
    }

}
