package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName order_info
 */
@TableName(value ="apply_info")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyInfo implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 负责人姓名
     */
    private String principalName;

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
     * 订金支付情况 ，0: 未交订金, 1: 已交订金
     */
    private Integer depositStatus;

    /**
     * 申请取消情况，0: 未取消, 1: 已取消
     */
    private Integer cancelStatus;

    /**
     * 支付截止日期
     */
    private Date payDeadline;

    /**
     * 交款单发送日期
     */
    private Date paymentSendDate;

    /**
     * 余款支付情况，0-未支付   1-已支付
     */
    private Integer balanceStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


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
        sb.append(", payDeadline=").append(payDeadline);
        sb.append(", paymentSendDate=").append(paymentSendDate);
        sb.append(", balanceStatus=").append(balanceStatus);
        sb.append(", principalName=").append(principalName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}