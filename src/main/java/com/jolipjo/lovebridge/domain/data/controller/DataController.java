package com.jolipjo.lovebridge.domain.data.controller;

import com.jolipjo.lovebridge.domain.data.dao.DataMapper;
import com.jolipjo.lovebridge.domain.data.dto.Rate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataMapper dataMapper;

    public DataController(DataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    @PostMapping("/rate")
    public ResponseEntity<Void> rate(@RequestBody Rate rate) {

        System.out.println("rate = " + rate.getRate());

        dataMapper.insertRate(rate);
        return ResponseEntity.ok().build();
    }

}