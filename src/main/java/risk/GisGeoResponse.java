package risk;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Gis经纬度解析接口结果
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/12/8 5:16 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GisGeoResponse {
    /**
     * 状态
     */
    private int status;

    /**
     * 状态消息
     */
    private String message;

    /**
     * 经纬度
     */
    private GisGeoResult result;

    public static void main(String[] args) {
        GisGeoResponse gisGeoResponse = JSON.parseObject("{\n" +
                "    \"result\":{\n" +
                "        \"address\":\"广东深圳市南山区南联社区豪方天际花园2栋2单园8C\",\n" +
                "        \"matchLevel\":10,\n" +
                "        \"latitude\":22.554261,\n" +
                "        \"reliability\":100,\n" +
                "        \"source\":\"1\",\n" +
                "        \"class\":\"com.jd.lbs.geocode.api.dto.GisPointDto\",\n" +
                "        \"analysisType\":\"ELASTIC_SEARCH\",\n" +
                "        \"longitude\":113.919601\n" +
                "    },\n" +
                "    \"message\":\"success\",\n" +
                "    \"class\":\"com.jd.lbs.geocode.api.base.BaseResponse\",\n" +
                "    \"status\":200\n" +
                "}", GisGeoResponse.class);
        System.out.println("aa");
    }
}
