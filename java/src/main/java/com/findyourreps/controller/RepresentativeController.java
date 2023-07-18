package com.findyourreps.controller;

import com.findyourreps.dao.RepDao;
import com.findyourreps.model.Representative;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // alerts Spring that this class is a controller class
@CrossOrigin // avoid CORS (cross-origin resource sharing) errors
public class RepresentativeController {
    private RepDao repDao;

    public RepresentativeController(RepDao repDao) {
        this.repDao = repDao;
    }

    @RequestMapping(value = "/reps", method = RequestMethod.GET)
    public List<Representative> getRepList() {
        List<Representative> repList = repDao.findAll();
        return repList;
    }

    @RequestMapping(value = "/searchName", method = RequestMethod.GET)
    public List<Representative> searchName (@RequestParam("query") String searchQuery,
                                            @RequestParam("size") int size,
                                            @RequestParam("page") int page,
                                            @RequestParam("direction") String direction,
                                            @RequestParam("sort") String sort) {
        List<Representative> repList = repDao.searchName(searchQuery, size, page, direction, sort);
        return repList;
    }

    @RequestMapping(value = "/searchParty", method = RequestMethod.GET)
    public List<Representative> searchParty(@RequestParam("query") String searchQuery,
                                            @RequestParam("size") int size,
                                            @RequestParam("page") int page,
                                            @RequestParam("direction") String direction,
                                            @RequestParam("sort") String sort) {
        List<Representative> repList = repDao.searchParty(searchQuery, size, page, direction, sort);
        return repList;
    }

}
