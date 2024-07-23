package com.jolipjo.lovebridge.domain.Game.DAO;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;

public interface GameMapper {

    MiniGameDto getMiniGameDto(Long memberId);

    GameDTO SetCount(Integer count);
}
