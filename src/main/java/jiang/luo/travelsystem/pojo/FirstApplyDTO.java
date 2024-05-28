package jiang.luo.travelsystem.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class FirstApplyDTO {

    private String principalName;

    private String phone;

    private Integer adultNumber;

    private Integer childNumber;

    private Integer pathId;

    private LocalDate departureDate;


}