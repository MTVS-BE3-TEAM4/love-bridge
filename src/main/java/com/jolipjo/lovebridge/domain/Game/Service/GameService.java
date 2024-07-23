package com.jolipjo.lovebridge.domain.Game.Service;

import com.jolipjo.lovebridge.domain.Game.DAO.GameMapper;
import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameMapper gameMapper;

    public GameService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    public MiniGameDto getMiniGameDto(Long memberId) {
        return gameMapper.getMiniGameDto(memberId);
    }


    public GameDTO SetCount(Integer count) {
        return gameMapper.SetCount(count);
    }
}
