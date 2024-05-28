package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName apply_info
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
    private LocalDate paymentSendDate;

    /**
     * 余款支付情况，0-未支付   1-已支付
     */
    private Integer balanceStatus;

    /**
     * 数据更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 订金计算比例
     */
    private Double depositRatio;
    // TODO 删除影响？
//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

}