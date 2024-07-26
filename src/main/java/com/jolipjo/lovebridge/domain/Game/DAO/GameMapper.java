package com.jolipjo.lovebridge.domain.Game.DAO;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    GameDTO SetCount(Integer count);

    //나의 정보를 찾겠다.
    MiniGameDto findAllByMe(Long memberId);

    //상대의 정보를 찾겠다.
    MiniGameDto findAllByPartner(Long partnerId);

    // 미션
    void insertMission(Map<String, Object> parmas);

    void deleteMission(Map<String, Object> parmas);

    void updateMission(Map<String, Object> params);

    // 출석일수
    void insertAttendance(Map<String, Object> value);

    void updateAttendance(Map<String, Object> value);

    void deleteAttendance(Map<String, Object> value);


}
