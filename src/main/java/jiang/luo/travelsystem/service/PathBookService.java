package jiang.luo.travelsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jiang.luo.travelsystem.pojo.PathBook;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lenovo
* @description 针对表【path_book】的数据库操作Service
* @createDate 2024-05-26 14:48:56
*/
public interface PathBookService extends IService<PathBook> {

    //TODO 插入新路线


    //TODO 逻辑删除路线

    //TODO 查询路径
    PathBook queryPathByPathNumber(Integer id);

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<PathBook> queryPage(int pageNum, int pageSize);



}
