import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

/**
 * 线程安全的日期格式化解析工具
 */
public class ThreadLocalDateUtil {

    public static void main(String[] args) {
        long l1 = ThreadLocalDateUtil.parse("2024-04-15 00:00:00").getTime();

        // 获取当天的0点时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long l2 = calendar.getTimeInMillis();

        System.out.println("1713319020667".compareTo("1713269687335"));
//        System.out.println(l2);
//        System.out.println(LocalDate.now().atStartOfDay(ZoneOffset.UTC));
    }

    /**
     * 默认格式化模式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_DAY = "yyyy-MM-dd";

    /**
     * 重写initialValue 方法
     * 当我们使用
     * ThreadLocal 的 get 方法的时候
     * ThreadLocal 会先查看我们 是否主动使用了  set方法设置了值
     * 如果没有，或者set进去的被remove了，就使用 initialValue 返回的值
     * 如果不重写，initialValue 默认返回 null
     * <p>
     * 这里重写了 initialValue 我们就不需要手动 set的方式去添加 SimpleDateFormat
     */
    private static final ThreadLocal<SimpleDateFormat> threadLocalSdf = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    /**
     * 设置格式化模式
     *
     * @param pattern
     */
    public static void setPattern(String pattern) {
        threadLocalSdf.get().applyPattern(pattern);
    }

    /**
     * 使用默认的 pattren
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DEFAULT_FORMAT);
    }

    /**
     * 根据传入的pattern设置
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (pattern == null || "".equals(pattern)) {
            throw new IllegalArgumentException("pattern is not allow null or '' ");
        }
        setPattern(pattern);
        return threadLocalSdf.get().format(date);
    }

    /**
     * 使用默认的pattern
     *
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, DEFAULT_FORMAT);
    }

    /**
     * 手动设置模式
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date parse(String dateStr, String pattern) {
        setPattern(pattern);
        Date date = null;
        try {
            date = threadLocalSdf.get().parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 根据时间字符串获取时间
     * 说明：会按照yyyy-MM-dd HH:mm:ss和yyyy-MM-dd两种格式进行处理
     *
     * @param dateStr
     * @return
     */
    public static Date getDate(String dateStr) {
        return ThreadLocalDateUtil.parse(dateStr) != null ? ThreadLocalDateUtil.parse(dateStr) : ThreadLocalDateUtil.parse(dateStr, "yyyy-MM-dd");
    }
}
