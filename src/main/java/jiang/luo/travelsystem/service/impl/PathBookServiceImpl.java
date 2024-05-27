package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.pojo.PathBookDTO;
import jiang.luo.travelsystem.service.PathBookService;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /**
     * 新增或变更路线
     * @param pathBookDTO
     */
    @Override
    public void savePathBook(PathBookDTO pathBookDTO) {
        PathBook pathBook = new PathBook();
        BeanUtils.copyProperties(pathBookDTO, pathBook);
        pathBook.setUpdateTime(new Date());
        pathBookMapper.insert(pathBook);
    }

    /**
     * 逻辑删除路线
     * @param id
     */
    @Override
    public void deletePathLogicallyById(Integer id) {
        PathBook pathBook = new PathBook();
        pathBook.setId(id);
        pathBook.setDeleteStatus(1);
        pathBook.setUpdateTime(new Date());
        pathBookMapper.updateById(pathBook);
    }

    /**
     * 根据id查找路线信息
     * @param id
     * @return
     */
    @Override
    public PathBook queryPathById(Integer id) {
        return pathBookMapper.selectById(id);

    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult pageQuery(int pageNum, int pageSize) {
        Page<PathBook> page = new Page<>(pageNum, pageSize);
        Page<PathBook> pathBookPage = pathBookMapper.selectPage(page, null);
        return new PageResult(pathBookPage.getTotal(), pathBookPage.getRecords());
//        return this.page(page, queryWrapper);
    }
}




