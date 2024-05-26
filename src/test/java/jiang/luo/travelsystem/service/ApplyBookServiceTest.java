package jiang.luo.travelsystem.service;

import jiang.luo.travelsystem.mapper.ApplyBookMapper;
import jiang.luo.travelsystem.pojo.ApplyBook;
import jiang.luo.travelsystem.pojo.ApplyBookDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplyBookServiceTest {
    @Autowired
    private ApplyBookMapper applyBookMapper;

    @Autowired
    private ApplyBookService applyBookService;
    @Test
    public void testInsert() {

        ApplyBookDTO applyBookDTO = new ApplyBookDTO();

        applyBookDTO.setTourCode("123");
        applyBookDTO.setDepartDate( new Date(124 , 2,12) );
        applyBookDTO.setName("罗旺");
        applyBookDTO.setGender(0);
        applyBookDTO.setBirthday(new Date(124 , 2,12) );
        applyBookDTO.setPhone("10388569345");
        applyBookDTO.setAddress("武汉理工大学");
        applyBookDTO.setEmail("jigbx0421232@126.com");
        applyBookDTO.setPostalCode("012123");
        applyBookDTO.setNameVice("啊手动阀手动阀");
        applyBookDTO.setRelationship("父亲");
        applyBookDTO.setAddressVice("武汉理工大虚呃");
        applyBookDTO.setPhoneVice("49588374657");

        applyBookService.saveApplyBook(applyBookDTO);

        Map<String,Object>mp = new HashMap<>();
        mp.put("name","罗旺");

        System.out.println(applyBookMapper.selectByMap(mp));

    }





}