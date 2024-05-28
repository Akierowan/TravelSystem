package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.SerializationUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.PageQueryDTO;
import jiang.luo.travelsystem.pojo.PageResult;
import jiang.luo.travelsystem.pojo.PathBook;
import jiang.luo.travelsystem.pojo.PathBookDTO;
import jiang.luo.travelsystem.service.PathBookService;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
     * @return
     */
    @Override
    public boolean savePathBook(PathBookDTO pathBookDTO) {
        PathBook pathBook = new PathBook();
        BeanUtils.copyProperties(pathBookDTO, pathBook);
        // 若传来的pathBookDTO的id不为空则是变更路线，否则为新增路线
        if (pathBookDTO.getId() != null) {
            pathBook.setId(null);
            pathBook.setLastVersionId(pathBookDTO.getId());
            //逻辑删除原路线
            PathBook del = pathBookMapper.selectById(pathBookDTO.getId());
            if (del.getDeleteStatus() == 1) {
                return false;
            }
            del.setDeleteStatus(1);
            del.setUpdateTime(LocalDateTime.now());
            pathBookMapper.updateById(del);
        }
        pathBook.setUpdateTime(LocalDateTime.now());
        pathBookMapper.insert(pathBook);
        return true;
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
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




