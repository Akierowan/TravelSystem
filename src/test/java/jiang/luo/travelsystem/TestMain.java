package jiang.luo.travelsystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class TestMain {
    // 判断是否成年
    public static boolean isAdult(LocalDate birthDate) {
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();

        // 计算生日和当前日期之间的Period
        Period period = Period.between(birthDate, currentDate);

        // 判断年龄是否大于等于18
        return period.getYears() >= 18;
    }

    public static void main(String[] args) {
        // 定义日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 输入生日字符串
        String birthDateString = "2005-05-28"; // 示例生日，可以根据需要更改

        try {
            // 将字符串解析为LocalDate对象
            LocalDate birthDate = LocalDate.parse(birthDateString, formatter);

            // 判断是否成年
            boolean adult = isAdult(birthDate);

            // 输出结果
            if (adult) {
                System.out.println("此人已成年。");
            } else {
                System.out.println("此人未成年。");
            }
        } catch (DateTimeParseException e) {
            System.out.println("日期格式错误，请输入正确的日期格式：yyyy-MM-dd");
        }
    }
}
