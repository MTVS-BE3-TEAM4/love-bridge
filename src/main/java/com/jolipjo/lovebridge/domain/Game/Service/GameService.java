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


    public GameDTO SetCount(String count) {
        return gameMapper.SetCount(count);
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
}
