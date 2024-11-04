package trainsien;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：BaiHailong
 * @date ：Created in 2024/4/19 9:13 上午
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //算法日志记录


        String test = "ADD-ACC-";
        String[] arr = test.split("-");

        System.out.println(customRegexDeliveryOnDoor("1244444433333333你好北京ABV"));
    }



    public static String customRegexDeliveryOnDoor(String content) throws Exception {
        //Step 1 - 正则表达式去除不需要的字符
        String removeReg = "\\\\【.*?】+|\\\\《.*?》+|\\\\#.*?#+|[.!/_,$&%^*<>+\"\"'?@|:;；~{}#]+|[——！\\\\，。=？、：“”‘’￥……（）《》【】]|[\\[\\]]";
        content = content.replaceAll("<.*?>", " "); //剔除html标签，替换为空格
        content = content.replaceAll("[\\s+.!/_,$%^*(+\"\']+|[+——！，。？、~@#￥%……&*（）]+", "");
        content = content.replaceAll(removeReg, "");
        content = content.replaceAll("\\d+", "");
        content = content.replaceAll("[a-zA-Z]", "");
        content = content.replaceAll("嗯|哦｜呢|呃|啊|喂|唉|哎", "");
        return content;
    }
}
