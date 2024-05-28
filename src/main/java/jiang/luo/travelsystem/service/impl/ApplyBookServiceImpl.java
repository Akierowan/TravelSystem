package jiang.luo.travelsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jiang.luo.travelsystem.pojo.*;
import jiang.luo.travelsystem.service.ApplyBookService;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author lenovo
* @description 针对表【apply_book】的数据库操作Service实现
* @createDate 2024-05-25 12:44:08
*/
@Service
public class ApplyBookServiceImpl extends ServiceImpl<ApplyBookMapper, ApplyBook>
    implements ApplyBookService{

    @Autowired
    ApplyBookMapper applyBookMapper;


    /**
     * 将新的申请书，插入到数据库中
     * @param applyBookDTO
     */
    @Override
    public void saveApplyBook(ApplyBookDTO applyBookDTO) {
        ApplyBook applyBook = new ApplyBook();

        BeanUtils.copyProperties(applyBookDTO, applyBook);

        applyBook.setUpdateTime(new Date());

        applyBookMapper.insert(applyBook);


    }

    /**
     * 更改申请书
     * @param applyBookDTO
     */
    @Override
    public void updateApplyBook(ApplyBookDTO applyBookDTO) {
        ApplyBook applyBook = new ApplyBook();
        BeanUtils.copyProperties(applyBookDTO, applyBook);
        applyBookMapper.updateById(applyBook);
    }

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(PageQueryDTO pageQueryDTO) {
        Page<ApplyBook> page = new Page<>(pageQueryDTO.getPageNum(), pageQueryDTO.getPageSize());
        QueryWrapper<ApplyBook> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", pageQueryDTO.getParam());
        Page<ApplyBook> applyBookPage = applyBookMapper.selectPage(page, queryWrapper);
        return new PageResult(applyBookPage.getTotal(), applyBookPage.getRecords());
    }
}




