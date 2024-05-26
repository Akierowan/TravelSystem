package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.service.PathBookService;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author lenovo
* @description 针对表【path_book】的数据库操作Service实现
* @createDate 2024-05-26 14:48:56
*/
@Service
public class PathBookServiceImpl extends ServiceImpl<PathBookMapper, PathBook>
    implements PathBookService{

    @Autowired
    PathBookMapper pathBookMapper;

    @Override
    public PathBook queryPathByPathNumber(Integer id) {
        return pathBookMapper.selectById(id);

    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public IPage<PathBook> queryPage(int pageNum, int pageSize) {
        Page<PathBook> page = new Page<>(pageNum, pageSize);
        return pathBookMapper.selectPage(page, null);
//        return this.page(page, queryWrapper);
    }
}




