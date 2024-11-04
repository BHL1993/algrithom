package risk;

/**
 * @author ：BaiHailong
 * @date ：Created in 2023/8/15 10:29 上午
 */

public class Predict {
    private int label;

    private double prob;

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
}
