package com.jolipjo.lovebridge.domain.timecapsule.dao;

import com.jolipjo.lovebridge.domain.member.entity.Member;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleListDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleViewDTO;
import com.jolipjo.lovebridge.domain.timecapsule.dto.TimecapsuleWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimecapsuleMapper {

    //resultMap를 조회하면 데이터가 나온다
    //그 데이터를 어떤 객체로 만들어서 뿌려줄지정한다
    // <select id="findAllView" resultMap="TimecapsuleViewDTO">
    /*
    * 이 경우에는 맵퍼에서 findAllView 를 실행하면
    * TimecapsuleViewDTO 로 반환할것이고
    * 이것은 별명인것이다
    * DTO는 화면중심
    * */
    List<TimecapsuleListDTO> findAllList(Long memberId);

    List<TimecapsuleViewDTO> findAllView();


    void join(Member member);


    void registNnewWirte(String sealingdate, String releasedate, String title, String detail);

    void findAllWrite(TimecapsuleWriteDTO timecapsuleWriteDTO);


    List<TimecapsuleWriteDTO> findAllWrite();
}
