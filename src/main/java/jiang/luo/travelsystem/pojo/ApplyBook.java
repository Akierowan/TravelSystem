package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@TableName(value ="apply_book")
@Data
public class ApplyBook implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 旅游团代码
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
     *  邮箱
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
     * 数据更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 申请信息的id
     */
    private Integer applyInfoId;
}