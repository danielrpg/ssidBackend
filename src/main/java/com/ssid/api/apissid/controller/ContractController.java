package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.AreaCommand;
import com.ssid.api.apissid.command.ContractCommand;
import com.ssid.api.apissid.command.ProgramSsoCommand;
import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.services.ContractService;
import com.ssid.api.apissid.services.SPSerives.SPContractService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ApiPath.CONTRACT_PATH)
public class ContractController {

    private ContractService contractService;
    private SPContractService spContractService;

    public ContractController(ContractService contractService, SPContractService spContractService) {
        this.contractService = contractService;
        this.spContractService = spContractService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public List<Contract> getAllContracts() {
        return spContractService.getAllContracts();
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Map<String, Object>> saveContract(@RequestBody Contract contract) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spContractService.createContract(contract));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> deleteContract(@PathVariable Long id) {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("success", this.spContractService.deleteContract(id));
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping( value = "/update/{id}", method = RequestMethod.PUT)
    public Contract updatePersonal(@RequestBody Contract contract, @PathVariable("id") Long id) {
        return  this.spContractService.updateContract(id, contract);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public @ResponseBody
    ContractCommand findContractByCode(@PathVariable(value = "code") String code){

        Contract contract = this.contractService.findByCode(code);
        if(contract != null){
            return new ContractCommand(contract);
        }
        else {
            return new ContractCommand();
        }
    }




}
