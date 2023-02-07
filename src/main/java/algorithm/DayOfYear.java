package algorithm;

/**
 * 一年中的第几天
 * 
 * 给你一个字符串date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * 
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 * @author ：BaiHailong
 * @date ：Created in 2021/12/21 9:09 上午
 */
public class DayOfYear {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("01"));
    }

    public int dayOfYear(String date) {
        String[] da = date.split("-");
        int year = Integer.parseInt(da[0]);
        int month = Integer.parseInt(da[1]);
        int day = Integer.parseInt(da[2]);

        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += getTotalMonthDays(i, year);
        }
        return ans + day;
    }

    public int getTotalMonthDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return year % 4 == 0 ? 29 : 28;
        }
        return 0;
    }
}
