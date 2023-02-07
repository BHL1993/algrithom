package sort;

/**
 * 洗护网点时效等级枚举
 *
 * @author ：BaiHailong
 * @date ：Created in 2022/8/12 9:17 上午
 */
public enum SrvWebsiteAgingLevelEnum {
    FIRST_LEVEL_ZERO(-1, 0, 1),
    FIRST_LEVEL_NON_ZERO(0, 3, 1),
    SECOND_LEVEL(3, 6, 2),
    THIRD_LEVEL(6, 9, 3),
    FORTH_LEVEL_POSITIVE(9, Integer.MAX_VALUE, 4),
    FORTH_LEVEL_NEGATIVE(Integer.MIN_VALUE, 0, Integer.MAX_VALUE),
    ;

    /**
     * 时效等级下限（开区间）
     */
    private Integer low;

    /**
     * 时效等级上限（闭区间）
     */
    private Integer high;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 根据网点时效获取时效等级
     *
     * @param aging 网点时效
     * @return      时效等级
     */
    public static int getLevelByAging(Integer aging) {
        if (null == aging) {
            return Integer.MAX_VALUE;
        }

        for (SrvWebsiteAgingLevelEnum srvWebsiteAgingLevelEnum : values()) {
            //左闭右开
            if (srvWebsiteAgingLevelEnum.getLow() < aging && aging <= srvWebsiteAgingLevelEnum.getHigh()) {
                return srvWebsiteAgingLevelEnum.getLevel();
            }
        }

        return Integer.MAX_VALUE;
    }

    SrvWebsiteAgingLevelEnum(Integer low, Integer high, Integer level) {
        this.low = low;
        this.high = high;
        this.level = level;
    }

    public Integer getLow() {
        return low;
    }

    public Integer getHigh() {
        return high;
    }

    public Integer getLevel() {
        return level;
    }
}
