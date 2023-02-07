package sort;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分派网点结果DTO
 */
@Getter
@Setter
public class AssignWebsiteResponseDto implements Serializable {

    /**
     * 网点编码
     */
    private String websiteNo;

    /**
     * 网点名称
     */
    private String websiteName;

    /**
     * 一级地址id
     */
    private Integer firstAddrId;

    /**
     * 二级地址id
     */
    private Integer secondAddrId;

    /**
     * 三级地址id
     */
    private Integer thirdAddrId;

    /**
     * 四级地址id
     */
    private Integer fourAddrId;

    /**
     * 一级地址name
     */
    private String firstAddrName;

    /**
     * 二级地址name
     */
    private String secondAddrName;

    /**
     * 三级地址name
     */
    private String thirdAddrName;

    /**
     * 四级地址name
     */
    private String fourAddrName;

    /**
     * 详细地址
     */
    private String address;

    /**
     * promise时效
     */
    private String agingTime;

    /**
     * promise时效解析出的时效天数
     */
    private Integer websiteAgingDay;

    /**
     * 产能日期开关
     */
    private Integer capacityStatus;

    /**
     * 是否不限制产能1是0否
     */
    private Integer capacityFreeSale;

    /**
     * 产能总量，-1表示不限制产能
     */
    private Long capacityTotalQty;
    /**
     * 扣减数量
     */
    private Long capacityOccupyQty;
    /**
     * 剩余数量
     */
    private Long capacityAvailableQty;

    /**
     * 优先级，主要针对可用网点的来源，数字越小 表示优先级越高,
     */
    private Integer priority;

    /**
     * 可用产能剩余比例
     */
    private BigDecimal capacityAvailableQtyRatio;

    /**
     * 保底量
     */
    private Long leastQty;

    /**
     * 保底量完成率
     */
    private BigDecimal leastQtyCompletionRate;

    /**
     * 竞争力
     */
    private String rankLevel;

    /**
     * 保底量未完成率
     */
    private BigDecimal leastQtyUnCompletionRate;

}
