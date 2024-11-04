package sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/5/6 11:21 上午
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueryFeatureEntity {
    private String waybillCode;
    private String operatorSiteId;
    private String operatorSite;
    private String operatorUserId;
    private String operatorUserErp;
    private String operatorUser;
    private Date waybillStateCreateTime;
    private String state;


}
