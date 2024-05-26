package jiang.luo.travelsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.service.PathBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class PathBookController {
    @Autowired
    private PathBookService pathBookService;

    @GetMapping("/page")
    public IPage<PathBook> page(){
        return pathBookService.queryPage(1, 10);
    }
}
