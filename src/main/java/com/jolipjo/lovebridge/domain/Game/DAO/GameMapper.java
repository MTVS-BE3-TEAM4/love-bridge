package com.jolipjo.lovebridge.domain.Game.DAO;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    //MiniGameDto getMiniGameDto(Long memberId);

    GameDTO SetCount(Integer count);

    MiniGameDto findAllById(Long memberId);
    
    void insertMission(Map<String, Object> parmas);

    void deleteMission(Map<String, Object> parmas);

    void updateMission(Map<String, Object> params);

    void insertAttendance(Map<String, Object> value);

    void updateAttendance(Map<String, Object> value);

    void deleteAttendance(Map<String, Object> value);


}
