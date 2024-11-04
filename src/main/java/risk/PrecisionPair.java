package risk;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/8/15 10:32 上午
 */
public class PrecisionPair {
    private double threshold;

    private double precision;

    public PrecisionPair(double threshold, double precision) {
        this.threshold = threshold;
        this.precision = precision;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }
}
