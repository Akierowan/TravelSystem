package jiang.luo.travelsystem.pojo;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FirstApplyDTO {

    /**
     * 负责人姓名
     */
    private String principalName;

    /**
     * 电话
     */
    private String phone;


    /**
     * 大人人数
     */
    private Integer adultNumber;

    /**
     * 小孩人数
     */
    private Integer childNumber;

    /**
     * 路线编号
     */
    private String pathNumber;

    /**
     * 出发日期
     */
    private LocalDate departDate;


}
