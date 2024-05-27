package jiang.luo.travelsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.Result;
import jiang.luo.travelsystem.service.FinanceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financebook")
public class FinanceBookController {
    @Autowired
    private FinanceBookService financeBookService;

    /**
     * 财务报表分页查询
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        try {
            PageResult pageResult = financeBookService.pageQuery(pageNum, pageSize);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("分页查询失败");
        }
    }
}
