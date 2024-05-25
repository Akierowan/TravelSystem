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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ApplyBook other = (ApplyBook) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTourCode() == null ? other.getTourCode() == null : this.getTourCode().equals(other.getTourCode()))
            && (this.getDepartDate() == null ? other.getDepartDate() == null : this.getDepartDate().equals(other.getDepartDate()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getNameVice() == null ? other.getNameVice() == null : this.getNameVice().equals(other.getNameVice()))
            && (this.getRelationship() == null ? other.getRelationship() == null : this.getRelationship().equals(other.getRelationship()))
            && (this.getAddressVice() == null ? other.getAddressVice() == null : this.getAddressVice().equals(other.getAddressVice()))
            && (this.getPhoneVice() == null ? other.getPhoneVice() == null : this.getPhoneVice().equals(other.getPhoneVice()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTourCode() == null) ? 0 : getTourCode().hashCode());
        result = prime * result + ((getDepartDate() == null) ? 0 : getDepartDate().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getNameVice() == null) ? 0 : getNameVice().hashCode());
        result = prime * result + ((getRelationship() == null) ? 0 : getRelationship().hashCode());
        result = prime * result + ((getAddressVice() == null) ? 0 : getAddressVice().hashCode());
        result = prime * result + ((getPhoneVice() == null) ? 0 : getPhoneVice().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}