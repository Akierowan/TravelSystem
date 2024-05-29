package jiang.luo.travelsystem.pojo;

import lombok.Data;

@Data
public class PathBookDTO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 所选旅游路径的编号
     */
    private String pathNumber;

    /**
     * 旅游路径
     */
    private String path;

    /**
     * 成人价格
     */
    private Double adultPrice;

    /**
     * 儿童价格
     */
    private Double childPrice;

    /**
     * 打折信息
     */
    private String discount;

}
