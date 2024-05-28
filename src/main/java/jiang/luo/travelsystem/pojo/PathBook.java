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
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName path_book
 */
@TableName(value ="path_book")
@Data
@NoArgsConstructor
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
    private LocalDateTime updateTime;

    /**
     * 是否逻辑删除，0正常，1删除
     */
    private Integer deleteStatus;

    /**
     *  上一版本的id
     */
    private Integer lastVersionId;
    // TODO 删除影响？
//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;

}