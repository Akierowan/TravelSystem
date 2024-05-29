package jiang.luo.travelsystem;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.mapper.ApplyInfoMapper;
import jiang.luo.travelsystem.mapper.PathBookMapper;
import jiang.luo.travelsystem.pojo.ApplyBook;
import jiang.luo.travelsystem.pojo.ApplyInfo;
import jiang.luo.travelsystem.pojo.PathBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class TravelSystemApplicationTests {
    public static void main(String[] args) {
        // 创建两个LocalDate对象
        LocalDate date1 = LocalDate.of(2024, 5, 29); // 示例日期
        LocalDate date2 = LocalDate.of(2024, 6, 28); // 示例日期

        // 计算两个日期之间的天数差
        long daysBetween = ChronoUnit.DAYS.between(date1, date2);

        // 打印结果
        System.out.println("两个日期相差的天数: " + daysBetween + " 天");
    }
}
