package jiang.luo.travelsystem.pojo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FirstApplyDTO {

    private String principalName;

    private String phone;

    private Integer adultNumber;

    private Integer childNumber;

    private String pathNumber;

    private LocalDate departureDate;


}