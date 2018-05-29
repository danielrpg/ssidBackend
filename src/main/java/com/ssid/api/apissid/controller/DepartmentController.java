package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.DepartmentCommand;
import com.ssid.api.apissid.domain.Department;
import com.ssid.api.apissid.services.DepartmentService;
import com.ssid.api.apissid.services.SPSerives.SPDeparmentService;
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
@RequestMapping(value = ApiPath.DEPARTMENT_PATH)
public class DepartmentController {

    private DepartmentService departmentService;
    private SPDeparmentService spDeparmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, SPDeparmentService spDeparmentService) {
        this.departmentService = departmentService;
        this.spDeparmentService = spDeparmentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllDepartments() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<DepartmentCommand> departmentList = new ArrayList<>();
        this.spDeparmentService.getAllDepartment().forEach(department -> {
            departmentList.add(new DepartmentCommand(department));
        });
        mapResponse.put("data", departmentList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getDepartmentById(@PathVariable long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Department department = this.departmentService.findById(id);

        if (department != null) {
            mapResponse.put("status", "ok");
            mapResponse.put("data", new DepartmentCommand(department));
            return new ResponseEntity<>(mapResponse, HttpStatus.OK);
        } else {
            mapResponse.put("status", "not found");
            mapResponse.put("data", null);
            return new ResponseEntity<>(mapResponse, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getDepartmentByName(@PathVariable String name) {
        List<DepartmentCommand> departmentList = new ArrayList<>();
        this.departmentService.findByName(name).forEach(department -> {
            departmentList.add(new DepartmentCommand(department));
        });
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        mapResponse.put("data", departmentList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> createDepartment(@RequestBody DepartmentCommand departmentCommand) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "created");
        mapResponse.put("data", spDeparmentService.createDepartment(departmentCommand.toDepartment()));
        return new ResponseEntity<>(mapResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, Object>> updateDepartment(@RequestBody DepartmentCommand departmentCommand, @PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "updated");
        mapResponse.put("data", spDeparmentService.updateDepartment(id, departmentCommand.toDepartment()));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteDepartment(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", this.spDeparmentService.deleteDepartment(id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }
}
