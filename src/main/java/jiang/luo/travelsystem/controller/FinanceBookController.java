package jiang.luo.travelsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.FinanceBook;
import jiang.luo.travelsystem.service.FinanceBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financebook")
public class FinanceBookController {
    @Autowired
    private FinanceBookService financeBookService;
    @GetMapping("/page")
    public IPage<FinanceBook> page(){
        return financeBookService.pageQuery(1, 10);
    }
}
