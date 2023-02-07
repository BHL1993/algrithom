package annotation;

public @interface Ext {
    /**
     * 维度全部匹配通配符
     */
    String DEFAULT_MATCH_ALL = "DEFAULT";

    /**
     * 回传通道
     *
     * @return
     */
    String channel() default DEFAULT_MATCH_ALL;

    /**
     * 回传商家
     *
     * @return
     */
    String[] seller() default DEFAULT_MATCH_ALL;

    /**
     * 回传节点
     *
     * @return
     */
    String[] status() default {DEFAULT_MATCH_ALL};
}
