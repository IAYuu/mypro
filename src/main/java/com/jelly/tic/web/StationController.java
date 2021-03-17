package com.jelly.tic.web;

import com.jelly.tic.entity.Station;
import com.jelly.tic.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// DispatcherServlet
@Controller
@RequestMapping("/")
public class StationController {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StationService stationService;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("welcome");
        return new ModelAndView("index.html");
    }

    @GetMapping("/query")
    public ModelAndView query() {
        logger.info("get + it's querying");
        return new ModelAndView("query.html");
    }

    @PostMapping("/query")
    public ModelAndView doQuery(@RequestParam("start") String start, @RequestParam("reach") String reach) {
        logger.info("---------------post + it's querying----------");
        List<Station> stations = null;
        try {
            logger.info(String.format("start: %s, reach: %s", start, reach));
            stations = stationService.getStationByStartAndReach(start, reach);
            logger.info("stations: " + stations.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 可扩展，例如传入user_model，使用Map.of(key, value)
        return new ModelAndView("query_res.html", "stations", stations);
    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        return new ModelAndView("query_res.html");
    }
}
