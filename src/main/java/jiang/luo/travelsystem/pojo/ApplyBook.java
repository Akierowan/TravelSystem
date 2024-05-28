package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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

    /**
     * 数据更新时间
     */
    private Date updateTime;

    /**
     * 申请信息的id
     */
    private Integer applyInfoId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tourCode=").append(tourCode);
        sb.append(", departDate=").append(departDate);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", email=").append(email);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", nameVice=").append(nameVice);
        sb.append(", relationship=").append(relationship);
        sb.append(", addressVice=").append(addressVice);
        sb.append(", phoneVice=").append(phoneVice);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", applyInfoId=").append(applyInfoId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}