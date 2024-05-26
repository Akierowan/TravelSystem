package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
}




