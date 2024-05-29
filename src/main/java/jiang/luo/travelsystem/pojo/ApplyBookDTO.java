package jiang.luo.travelsystem.pojo;

import lombok.Data;
import java.time.LocalDate;


@Data
public class ApplyBookDTO {
    /**
     * 主键
     */
    Integer id;
    /**
     * 邮政编码
     */
    private String tourCode;

    /**
     * 旅团启航日期
     */
    private LocalDate departDate;

    /**
     * 路线编号
     */
    private String pathNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别，0是女，1是男
     */
    private Integer gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 副联系人姓名
     */
    private String nameVice;

    /**
     * 关系
     */
    private String relationship;

    /**
     * 副联系地址
     */
    private String addressVice;

    /**
     * 副电话
     */
    private String phoneVice;

    /**
     * 申请信息id
     */
    private Integer applyInfoId;

}
