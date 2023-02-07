/**
 * @author ：BaiHailong
 * @date ：Created in 2021/12/9 10:19 上午
 */
public class StackOverFlow {
    private int i;

    public void plus() {

        while(true){
            i++;
            Integer o = new Integer(3000);
        }
    }

    public static void main(String[] args) {
        StackOverFlow stackOverFlow = new StackOverFlow();
        try {
            stackOverFlow.plus();
        } catch (Error e) {
            System.out.println("Error:stack length:" + stackOverFlow.i);
            e.printStackTrace();
        }
    }
}
