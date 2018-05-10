package com.ssid.api.apissid.controller;



import com.ssid.api.apissid.command.ContractCommand;
import com.ssid.api.apissid.command.RequirementCommand;
import com.ssid.api.apissid.domain.Position;
import com.ssid.api.apissid.domain.Requirement;
import com.ssid.api.apissid.services.PositionService;
import com.ssid.api.apissid.services.RequirementService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = ApiPath.REQUIREMENT_PATH)
public class RequirementController {

    private RequirementService requirementService;
    private PositionService positionService;

    @Autowired
    public RequirementController(RequirementService requirementService,PositionService positionService) {
        this.requirementService = requirementService;
        this.positionService=positionService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllRequirements() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");

        List<RequirementCommand> requirementList = new ArrayList<>();
        this.requirementService.findAll().forEach(requirement -> {
            requirementList.add(new RequirementCommand(requirement));
        });

        mapResponse.put("data", requirementList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRequirementById(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();

        Position position = this.positionService.findById(id);

        List<RequirementCommand> requirementList = new ArrayList<>();
        this.requirementService.findByPosition(position).forEach(requirement -> {
            requirementList.add(new RequirementCommand(requirement));
        });

        if (!requirementList.isEmpty()) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", requirementList);
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRequiremenrByName(@PathVariable String name) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        mapResponse.put("data", this.requirementService.findByName(name));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createRequirement(@RequestBody RequirementCommand  requirementCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
       if(StringUtils.isEmpty(requirementCommand.getId())) {
            mapResponse.put("status", "created");
            requirementService.createRequirement(requirementCommand);
            return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);

        }
        else
        {
                mapResponse.put("status", "updated");
                requirementService.updateRequirement(requirementCommand,requirementCommand.getId());
                return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateRequirement(@RequestBody RequirementCommand requirementCommand, @PathVariable int id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        requirementService.updateRequirement(requirementCommand,requirementCommand.getId());
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteRequirement(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "deleted");
        this.requirementService.deleteById(id);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = ApiPath.CONTRACT_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveContract(@RequestBody RequirementCommand requirementCommand) {
        if (StringUtils.isEmpty(requirementCommand.getId())) {
            this.requirementService.saveRequirements(requirementCommand.toRequirement());
        } else {
            // se busca el objeto existente
            Requirement requirement = this.requirementService.findById(requirementCommand.getId());
            requirement.setName(requirementCommand.getName());
            requirement.setDescription(requirementCommand.getDescription());
            this.requirementService.saveRequirements(requirement);
        }


    }
}
