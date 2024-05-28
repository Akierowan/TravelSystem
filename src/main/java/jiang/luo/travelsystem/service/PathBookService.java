package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PathBookDTO;

/**
* @author lenovo
* @description 针对表【path_book】的数据库操作Service
* @createDate 2024-05-26 14:48:56
*/
public interface PathBookService extends IService<PathBook> {

    /**
     * 新增或变更路线
     * @param pathBookDTO
     */
    void savePathBook(PathBookDTO pathBookDTO);


    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    PageResult pageQuery(PageQueryDTO pageQueryDTO);


}
