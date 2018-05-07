package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.PositionCommand;
import com.ssid.api.apissid.command.PositionTreeCommand;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.services.PositionService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jesus David Piérola Alvarado
 */
@RestController
@RequestMapping(value = ApiPath.POSITION_PATH)
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListPosition() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<PositionCommand> positionList = new ArrayList<>();
        this.positionService.findAll().forEach(position -> {
            positionList.add(new PositionCommand(position));
        });
        mapResponse.put("data", positionList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/tree/{tree}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getListPositionsTree(@PathVariable String tree) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<PositionTreeCommand> positionList = new ArrayList<>();
        this.positionService.findAll().forEach(position -> {
            positionList.add(new PositionTreeCommand(position));
        });
        //Mapeamos la estructura organizacional por precedencias
        mapResponse.put("data", mapTreePositions(positionList));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    private List<PositionTreeCommand> mapTreePositions(List<PositionTreeCommand> positionList) {
        List<PositionTreeCommand> mapList = new ArrayList<>();

        //get parent
        PositionTreeCommand parent = positionList.stream()
                .filter((position) -> position.getParentId() == 0)
                .findFirst().get();

        if (parent != null) {
            parent = addChildren(parent, positionList);
            mapList.add(parent);
        } else {
            mapList = positionList;
        }

        return mapList;
    }

    private PositionTreeCommand addChildren(PositionTreeCommand parent, List<PositionTreeCommand> positionList) {

        if (positionList != null && !positionList.isEmpty() && positionList.size() > 0) {
            List<PositionTreeCommand> list = new ArrayList<>();
            positionList.stream().filter(pos -> pos.getId() != parent.getId()
                    && pos.getParentId() == parent.getId())
                    .forEach(p -> {
                        list.add(p);
                    });

            if (list != null && !list.isEmpty()) {
                for (PositionTreeCommand posTree : list) {
                    posTree = addChildren(posTree, positionList);

                    List<PositionTreeCommand> children = new ArrayList<PositionTreeCommand>();

                    if(parent.getChildren() != null
                            && !parent.getChildren().isEmpty()
                            && parent.getChildren().size() > 0){
                        children = parent.getChildren();
                    }

                    children.add(posTree);
                    parent.setChildren((ArrayList<PositionTreeCommand>) children);
                }
            } else {
                return parent;
            }
        }

        if(parent.getChildren() != null
                && !parent.getChildren().isEmpty()
                && parent.getChildren().size() > 0){
            parent.setExpanded(true);
        }

        return parent;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getPositionById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Position position = this.positionService.findById(id);

        if (position != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new PositionCommand(position));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createPosition(@RequestBody PositionCommand positionCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", positionService.save(positionCommand.toPosition()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updatePosition(@RequestBody PositionCommand positionCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", positionService.updatePosition(positionCommand.toPosition(), (long) id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deletePosition(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.positionService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/haveChildren/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getIfHaveChildren(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<PositionTreeCommand> positionList = new ArrayList<>();
        this.positionService.findAll().stream().filter(pos -> pos.getParentPosition() != null)
                .forEach(position -> {
            positionList.add(new PositionTreeCommand(position));
        });
        //revisamos si de todos los que tienen padres, hay alguno que dependa de este cargo
        List<PositionTreeCommand> positionReview = new ArrayList<>();
        positionList.stream().filter(pos -> pos.getParentId() == id)
                .forEach(position -> {
            positionReview.add(position);
        });

        if(positionReview != null && !positionReview.isEmpty() && positionReview.size() > 0)
        {
            mapResponse.put("data", true);
        }
        else
        {
            mapResponse.put("data", false);
        }

        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}