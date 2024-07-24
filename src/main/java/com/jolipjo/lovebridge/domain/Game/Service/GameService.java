package com.jolipjo.lovebridge.domain.Game.Service;

import com.jolipjo.lovebridge.domain.Game.DAO.GameMapper;
import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    private final GameMapper gameMapper;

    public GameService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    public MiniGameDto getMiniGameDto(Long memberId) {
        return gameMapper.getMiniGameDto(memberId);
    }


    public GameDTO setAttendCnt(Integer attendCnt) {
        return gameMapper.SetCount(attendCnt);
    }




    public void missionInsert(String mission, Long memberId){
        Map<String,Object> params = new HashMap<>();
        params.put("mission",mission);
        params.put("memberId",memberId);
        gameMapper.insertMission(params);
    }

    public void missionUpdate(String mission, Long memberId){
        Map<String,Object> params = new HashMap<>();
        params.put("mission",mission);
        params.put("memberId",memberId);
        gameMapper.updateMission(params);
    }

    public void deleteMission(String mission, Long memberId){
        Map<String,Object> params = new HashMap<>();
        params.put("mission",mission);
        params.put("memberId",memberId);
        gameMapper.deleteMission(params);
    }

    public void attendanceInsert(Integer attendCnt, Long memberId){
        Map<String,Object> value = new HashMap<>();
        value.put("attendCnt",attendCnt);
        value.put("memberId",memberId);
        gameMapper.insertAttendance(value);
    }

    public void deleteAttendanceByCount(Long memberId, Integer attendCnt) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberId", memberId);
        params.put("attendCnt", attendCnt);
        gameMapper.deleteAttendance(params);
    }

    public void updateAttendance(Long memberId, Integer attendCnt) {
        Map<String, Object> params = new HashMap<>();
        params.put("attendCnt", attendCnt);
        params.put("memberId", memberId);
        gameMapper.updateAttendance(params);
    }
}
