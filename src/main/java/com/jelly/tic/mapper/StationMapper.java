package com.jelly.tic.mapper;

import com.jelly.tic.entity.Station;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StationMapper {

    @Select("SELECT * FROM stations WHERE start = #{start} AND reach = #{reach}")
    List<Station> getByStartAndReach(@Param("start") String start, @Param("reach") String reach);
}
