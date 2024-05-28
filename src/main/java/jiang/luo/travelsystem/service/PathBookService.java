package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import com.baomidou.mybatisplus.extension.service.IService;
import jiang.luo.travelsystem.pojo.PathBookDTO;

public interface PathBookService extends IService<PathBook> {

    /**
     * 新增或变更路线
     */
    void savePathBook(PathBookDTO pathBookDTO) throws Exception;


    /**
     * 分页查询
     */
    PageResult pageQuery(PageQueryDTO pageQueryDTO);


}
