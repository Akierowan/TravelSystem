package jiang.luo.travelsystem.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ApplyBookDTO {

    /**
     *
     */
    private String tourCode;

    /**
     * 旅团启航日期
     */
    private Date departDate;

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
    private Date birthday;

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




}
