package com.jelly.tic.service;

import com.jelly.tic.entity.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StationService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JdbcTemplate jdbcTemplate;

    // 将ResultSet转换为Javabean
    RowMapper<Station> stationRowMapper = new BeanPropertyRowMapper<>(Station.class);

    public Station getStationById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM stations WHERE id = ?", new Object[]{id}, stationRowMapper);
    }


    public List<Station> getStationByStartAndReach(String start, String reach) {
        try {
            List<Station> stations = jdbcTemplate.query("SELECT * FROM stations WHERE start = ? AND reach = ?"
                    , new Object[]{start, reach}
                    , stationRowMapper);
            return stations;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO
    public Station getStationByStart_time(String start_time) {
        return null;
    }
}