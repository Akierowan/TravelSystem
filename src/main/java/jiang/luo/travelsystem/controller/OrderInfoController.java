package jiang.luo.travelsystem.controller;

import jiang.luo.travelsystem.pojo.FirstApplyDTO;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 第一次申请
     * @param firstApplyDTO
     * @return
     */
    @PostMapping("/firstapply")
    public Result firstApply(@RequestBody FirstApplyDTO firstApplyDTO) {
        try {
            orderInfoService.saveFirstApply(firstApplyDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("初次申请失败");
        }
    }
}
