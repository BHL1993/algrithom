package trainsien;

/**
 * @author ：BaiHailong
 * @date ：Created in 2024/4/19 9:14 上午
 */
public class TransientClass {
    private transient int num = 1;
    private String code = "xl";

    public int getNum() {
        return num;
    }

    public String getCode() {
        return code;
    }
}
