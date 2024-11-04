package risk;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Gis经纬度解析结果
 *
 * @author ：BaiHailong
 * @date ：Created in 2023/12/8 2:31 下午
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GisGeoResult {
    /**
     * 地址的纬度
     */
    private BigDecimal latitude;
    /**
     * 地址的经度
     */
    private BigDecimal longitude;
}
