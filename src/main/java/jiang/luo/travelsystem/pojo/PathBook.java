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