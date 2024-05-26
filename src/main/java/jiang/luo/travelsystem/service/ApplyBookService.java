package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.ApplyBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.ApplyBookDTO;

import java.util.function.ToDoubleBiFunction;

/**
* @author lenovo
* @description 针对表【apply_book】的数据库操作Service
* @createDate 2024-05-25 12:44:08
*/
public interface ApplyBookService extends IService<ApplyBook> {


    void saveApplyBook(ApplyBookDTO applyBookDTO);



}
