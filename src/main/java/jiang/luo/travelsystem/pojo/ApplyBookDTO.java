package jiang.luo.travelsystem.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ApplyBookDTO {
    /**
     * 主键
     */
    Integer id;
    /**
     *
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
     *
     */
    private String email;

    /**
     *
     */
    private String postalCode;

    /**
     *
     */
    private String nameVice;

    /**
     *
     */
    private String relationship;

    /**
     *
     */
    private String addressVice;

    /**
     *
     */
    private String phoneVice;

    /**
     * 申请信息id
     */
    private Integer applyInfoId;

}
