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
 * @TableName path_book
 */
@TableName(value ="path_book")
@Data
public class PathBook implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 数据更新时间
     */
    private Date updateTime;

    /**
     * 是否逻辑删除，0正常，1删除
     */
    private Integer deleteStatus;

    /**
     *  上一版本的id
     */
    private Integer lastVersionId;

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
        PathBook other = (PathBook) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPathNumber() == null ? other.getPathNumber() == null : this.getPathNumber().equals(other.getPathNumber()))
            && (this.getPath() == null ? other.getPath() == null : this.getPath().equals(other.getPath()))
            && (this.getAdultPrice() == null ? other.getAdultPrice() == null : this.getAdultPrice().equals(other.getAdultPrice()))
            && (this.getChildPrice() == null ? other.getChildPrice() == null : this.getChildPrice().equals(other.getChildPrice()))
            && (this.getDiscount() == null ? other.getDiscount() == null : this.getDiscount().equals(other.getDiscount()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleteStatus() == null ? other.getDeleteStatus() == null : this.getDeleteStatus().equals(other.getDeleteStatus())
            && (this.getLastVersionId() == null ? other.getLastVersionId() == null : this.getLastVersionId()).equals(other.getLastVersionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPathNumber() == null) ? 0 : getPathNumber().hashCode());
        result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
        result = prime * result + ((getAdultPrice() == null) ? 0 : getAdultPrice().hashCode());
        result = prime * result + ((getChildPrice() == null) ? 0 : getChildPrice().hashCode());
        result = prime * result + ((getDiscount() == null) ? 0 : getDiscount().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleteStatus() == null) ? 0 : getDeleteStatus().hashCode());
        result = prime * result + ((getLastVersionId() == null) ? 0 : getLastVersionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pathNumber=").append(pathNumber);
        sb.append(", path=").append(path);
        sb.append(", adultPrice=").append(adultPrice);
        sb.append(", childPrice=").append(childPrice);
        sb.append(", discount=").append(discount);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", lastVersionId=").append(lastVersionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}