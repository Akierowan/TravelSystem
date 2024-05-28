package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.pojo.PathBookDTO;
import jiang.luo.travelsystem.service.PathBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
     */
    @Override
    public void savePathBook(PathBookDTO pathBookDTO) throws Exception {
        PathBook pathBook = new PathBook();
        BeanUtils.copyProperties(pathBookDTO, pathBook);

        if (pathBookDTO.getId() != null) { // 若传来的pathBookDTO的id不为空则是变更路线
            pathBook.setId(null);
            pathBook.setLastVersionId(pathBookDTO.getId());
            //逻辑删除原路线
            PathBook del = pathBookMapper.selectById(pathBookDTO.getId());
            if (del.getDeleteStatus() == 1) {
                throw new Exception();
            }
            del.setDeleteStatus(1);
            del.setUpdateTime(LocalDateTime.now());
            pathBookMapper.updateById(del);
        } else { // 此为新增路线
            QueryWrapper<PathBook> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("path_number", pathBookDTO.getPathNumber());
            List<PathBook> pathBooks = pathBookMapper.selectList(queryWrapper);
            if (!pathBooks.isEmpty()) {
                throw new Exception();
            }
        }
        pathBook.setUpdateTime(LocalDateTime.now());
        pathBookMapper.insert(pathBook);
    }

    /**
     * 分页查询
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<PathBook> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        QueryWrapper<PathBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("path_number", pageQueryDTO.getParam());
        Page<PathBook> pathBookPage = pathBookMapper.selectPage(page, queryWrapper);
        return new PageResult(pathBookPage.getTotal(), pathBookPage.getRecords());
    }
}




