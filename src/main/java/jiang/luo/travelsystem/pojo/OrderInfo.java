package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName order_info
 */
@TableName(value ="order_info")
@Data
public class OrderInfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 订金
     */
    private Double deposit;

    /**
     * 申请书编号
     */
    private Integer applyBookId;

    /**
     * 所选旅游路线总价格
     */
    private Double totalPrice;

    /**
     * 0: 未交订金, 1: 已交订金
     */
    private Integer depositStatus;

    /**
     * 0: 未取消, 1: 已取消
     */
    private Integer cancelStatus;

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
        OrderInfo other = (OrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getApplyBookId() == null ? other.getApplyBookId() == null : this.getApplyBookId().equals(other.getApplyBookId()))
            && (this.getTotalPrice() == null ? other.getTotalPrice() == null : this.getTotalPrice().equals(other.getTotalPrice()))
            && (this.getDepositStatus() == null ? other.getDepositStatus() == null : this.getDepositStatus().equals(other.getDepositStatus()))
            && (this.getCancelStatus() == null ? other.getCancelStatus() == null : this.getCancelStatus().equals(other.getCancelStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getApplyBookId() == null) ? 0 : getApplyBookId().hashCode());
        result = prime * result + ((getTotalPrice() == null) ? 0 : getTotalPrice().hashCode());
        result = prime * result + ((getDepositStatus() == null) ? 0 : getDepositStatus().hashCode());
        result = prime * result + ((getCancelStatus() == null) ? 0 : getCancelStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deposit=").append(deposit);
        sb.append(", applyBookId=").append(applyBookId);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", depositStatus=").append(depositStatus);
        sb.append(", cancelStatus=").append(cancelStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}