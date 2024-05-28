package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName apply_book
 */
@TableName(value ="apply_book")
@Data
public class ApplyBook implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

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
     * 数据更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 申请信息的id
     */
    private Integer applyInfoId;
    // TODO 删除影响？
//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

}