package risk;

import com.alibaba.fastjson.JSON;
import org.bitlap.geocoding.Geocoding;
import org.bitlap.geocoding.GeocodingX;
import org.bitlap.geocoding.model.Address;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/9/21 11:11 上午
 */
public class GeocodingClient {
    public static void main(String[] args) {
        GeocodingX geocoding = new GeocodingX();
        final Address address = geocoding.normalizing("河南省许昌市长葛市后河镇行政大道敏业鑫工业园\\t");
        System.out.println(JSON.toJSONString(address));

        String text1 = "山东青岛李沧区延川路116号绿城城园东区7号楼2单元802户";
        String text2 = "山东青岛李沧区延川路绿城城园东区7-2-802";
        Address address1 = geocoding.normalizing(text1);
        Address address2 = geocoding.normalizing(text2);
        System.out.println(geocoding.similarity(address1, address2));

    }
}
