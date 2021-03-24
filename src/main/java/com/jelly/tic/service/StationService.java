package com.jelly.tic.service;

import com.jelly.tic.entity.Station;
import com.jelly.tic.mapper.StationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StationService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StationMapper stationMapper;

    public List<Station> getStationByStartAndReach(String start, String reach) {
        try {
            List<Station> stations = stationMapper.getByStartAndReach(start, reach);
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