package jiang.luo.travelsystem.pojo;

import lombok.Data;

@Data
public class PageQueryDTO {
    /**
     * 页码
     */
    Integer pageNum;

    /**
     * 页大小
     */
    Integer pageSize;

    /**
     * 查询参数
     */
    Object param;
}
