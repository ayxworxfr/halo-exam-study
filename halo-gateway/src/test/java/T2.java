import java.time.ZonedDateTime;

/**
 * @author: evildoer
 * @datetime: 2021/1/28 12:33
 */
public class T2 {

    public static void main(String[] args) {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        //2021-01-28T12:34:30.361+08:00[Asia/Shanghai]
    }
}
