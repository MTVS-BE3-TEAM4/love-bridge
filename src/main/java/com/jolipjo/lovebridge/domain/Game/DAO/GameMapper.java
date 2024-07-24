package com.jolipjo.lovebridge.domain.Game.DAO;

import com.jolipjo.lovebridge.domain.Game.DTO.GameDTO;
import com.jolipjo.lovebridge.domain.Game.DTO.MiniGameDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface GameMapper {

    MiniGameDto getMiniGameDto(Long memberId);

    GameDTO SetCount(String count);

    void insertMission(Map<String, Object> parmas);
}
