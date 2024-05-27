package jiang.luo.travelsystem.service;

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
     * 逻辑删除路线
     * @param id
     */
    void deletePathLogicallyById(Integer id);

    /**
     * 根据id查询路线信息
     * @param id
     * @return
     */
    PathBook queryPathById(Integer id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult pageQuery(int pageNum, int pageSize);



}
