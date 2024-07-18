package com.jolipjo.lovebridge.domain.timecapsule.service;

import com.jolipjo.lovebridge.domain.timecapsule.dao.TimecapsuleMapper;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleViewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimecapsuleService {

    private final TimecapsuleMapper timecapsulMapper;

    public TimecapsuleService(TimecapsuleMapper timecapsulMapper) { this.timecapsulMapper = timecapsulMapper; }

    public List<TimecapsuleViewDTO> findAllView() {

        return timecapsulMapper.findAllView();

    }
}
