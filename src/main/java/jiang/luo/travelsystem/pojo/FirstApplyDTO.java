package jiang.luo.travelsystem.pojo;

import lombok.Data;
import org.springframework.scheduling.support.SimpleTriggerContext;

import java.security.PrivateKey;
import java.util.Date;

@Data
public class FirstApplyDTO {

    private String name;

    private String phone;

    private Integer adultNumber;

    private Integer childNumber;

    private Integer id;

    private Date departureDate;


}