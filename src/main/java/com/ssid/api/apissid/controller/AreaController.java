package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.services.AreaService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Jesus David Piérola Alvarado
 */
@RestController
public class AreaController {

    private AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping(path = ApiPath.AREA_PATH)
    public List<Area> getListArea() {
        return this.areaService.findAll();
    }

    @GetMapping(value = ApiPath.AREA_PATH + "/id/")
    public Area findById(@PathParam("id") long id) {
        return this.areaService.findById(id);
    }

    @GetMapping(value = ApiPath.AREA_PATH + "/name/")
    public List<Area> findByName(@PathParam("name") String name) {
        return this.areaService.findByName(name);
    }

    @RequestMapping(value = ApiPath.AREA_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveArea(@RequestBody Area area) {
        this.areaService.save(area);
    }

    @RequestMapping(value = ApiPath.AREA_PATH, method = RequestMethod.PATCH)
    public @ResponseBody
    void updateArea(@RequestBody Area area) {
        this.areaService.save(area);
    }

    @RequestMapping(value = ApiPath.AREA_PATH, method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteArea(@PathParam("id") long id) {
        this.areaService.deleteById(id);
    }
}
