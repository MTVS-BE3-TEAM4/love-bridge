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


    public GameDTO setAttendCnt(String attendCnt) {
        return gameMapper.SetCount(attendCnt);
    }




    public void missionInsert(String mission, Long memberId){
        // gameService.missionInsert(FWish,memberDetail.getMember().getId());
        System.out.println(mission);
        System.out.println(memberId);

        Map<String,Object> params = new HashMap<>();
        params.put("mission",mission);
        params.put("memberId",memberId);
        gameMapper.insertMission(params);
    }

    public void attendanceInsert(String attendCnt, Long memberId){
        System.out.println(attendCnt);
        System.out.println(memberId);
        Map<String,Object> value = new HashMap<>();
        value.put("attendCnt",attendCnt);
        System.out.println("attendCnt ::" + attendCnt);
        System.out.println("memberId ::" + memberId);
        value.put("memberId",memberId);
        gameMapper.insertAttendance(value);


    }
}
