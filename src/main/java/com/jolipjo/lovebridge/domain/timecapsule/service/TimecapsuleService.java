package com.jolipjo.lovebridge.domain.timecapsule.service;

import com.jolipjo.lovebridge.domain.timecapsule.dao.TimecapsuleMapper;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleListDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleViewDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleWriteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TimecapsuleService {

    private final TimecapsuleMapper timecapsulMapper;

    public TimecapsuleService(TimecapsuleMapper timecapsulMapper) {
        this.timecapsulMapper = timecapsulMapper; 
    }

    public List<TimecapsuleViewDTO> findAllView() {

        return timecapsulMapper.findAllView();
    }


    public List<TimecapsuleListDTO> findAllList(Long memberId) {

        return timecapsulMapper.findAllList(memberId);
    }

    @Transactional
    public void registNewWirte(TimecapsuleWriteDTO dto) {

        System.out.println(" 서비스 여기까지들어왔습니다");
        timecapsulMapper.findAllWrite(dto);
    }

    public List<TimecapsuleWriteDTO> findAllWrite() {

        return  timecapsulMapper.findAllWrite();
    }

    public List<TimecapsuleViewDTO> findidView(long id) {
        return timecapsulMapper.findidView(id);
    }

}

