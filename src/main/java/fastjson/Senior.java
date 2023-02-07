package fastjson;

import com.alibaba.fastjson.JSON;

/**
 * @author ：BaiHailong
 * @date ：Created in 2021/11/23 10:25 上午
 */
public class Senior extends Super {
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Senior senior = new Senior();
        senior.setName("x");
        senior.setAge("y");
        System.out.println(JSON.toJSONString(senior));
    }
}
