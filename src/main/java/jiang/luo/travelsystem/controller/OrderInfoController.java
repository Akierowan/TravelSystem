package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.OrderInfo;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="订单信息相关接口")
@RestController
@RequestMapping("/orderinfo")
@CrossOrigin
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 第一次申请
     * @param firstApplyDTO
     * @return
     */
    @ApiOperation("初次提交申请")
    @PostMapping("/firstapply")
    public Result firstApply(@RequestBody FirstApplyDTO firstApplyDTO) {
        try {
            orderInfoService.saveFirstApply(firstApplyDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("初次申请失败");
        }
    }

    /**
     * 根据姓名查找订单信息
     * @param name
     * @return
     */
    @ApiOperation("根据姓名查找订单信息")
    @GetMapping
    public Result<List<OrderInfo>> getByName(@RequestParam String name){
        try {
            List<OrderInfo> orderInfoList = orderInfoService.getByName(name);
            return Result.success(orderInfoList);
        } catch (Exception e) {
            return Result.error("查找订单信息失败");
        }
    }

    /**
     * 支付订金
     * @param id
     * @return
     */
    @ApiOperation("支付订金")
    @PostMapping("/paydeposit")
    public Result payDeposit(@RequestBody Integer id) {
        try {
            orderInfoService.payDeposit(id);
            return Result.success();
        } catch (Exception e) {
            return Result.error("订金支付失败");
        }
    }
}
