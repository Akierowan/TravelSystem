package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.ApplyBookDTO;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.ApplyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="旅游申请书相关接口")
@RestController
@RequestMapping("/applybook")
public class ApplyBookController {
    @Autowired
    private ApplyBookService applyBookService;

    @ApiOperation("提交旅游申请书")
    @PostMapping("save")
    public Result saveApplyBook(@RequestBody ApplyBookDTO applyBookDTO){
        try {
            applyBookService.saveApplyBook(applyBookDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("保存申请书失败");
        }
    }

}
