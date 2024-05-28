package jiang.luo.travelsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * 
 * @TableName finance_book
 */
@TableName(value ="finance_book")
@Data
public class FinanceBook implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 收到的钱
     */
    private Double amount;

    /**
     * 资金流水类型，0: 订金支付, 1: 余款支付, 2: 退款
     */
    private Integer type;

    /**
     * 资金流水生成时间
     */
    private LocalDateTime updateTime;

    /**
     * 对应订单信息
     */
    private Integer applyInfoId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}