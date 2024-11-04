package risk;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/8/15 10:32 上午
 */
public class RecallPair {
    private double threshold;

    private double recall;

    public RecallPair(double threshold, double recall) {
        this.threshold = threshold;
        this.recall = recall;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }
}
