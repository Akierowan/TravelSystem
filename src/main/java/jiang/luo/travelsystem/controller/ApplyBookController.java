package jiang.luo.travelsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jiang.luo.travelsystem.pojo.ApplyBook;
import jiang.luo.travelsystem.pojo.ApplyBookDTO;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.ApplyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="旅游申请书相关接口")
@RestController
@RequestMapping("/applybook")
@CrossOrigin
public class ApplyBookController {
    @Autowired
    private ApplyBookService applyBookService;

    /**
     * 提交旅游申请书
     * @param applyBookDTO
     * @return
     */
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

    /**
     * 根据id查找旅游申请书
     * @param id
     * @return
     */
    @ApiOperation("根据id查找旅游申请书")
    @GetMapping
    public Result<ApplyBook> getById(@RequestParam Integer id){
        try {
            ApplyBook applyBook = applyBookService.getById(id);
            return Result.success(applyBook);
        } catch (Exception e) {
            return Result.error("获取旅游申请书失败");
        }
    }

    /**
     * 变更旅游申请书
     * @param applyBookDTO
     * @return
     */
    @ApiOperation("变更旅游申请书")
    @PostMapping("/alter")
    public Result alterApplyBook(@RequestBody ApplyBookDTO applyBookDTO){
        try {
            applyBookService.updateApplyBook(applyBookDTO);
            return Result.success();
        } catch (Exception e) {
            return Result.error("变更旅游申请书失败");
        }
    }

}
