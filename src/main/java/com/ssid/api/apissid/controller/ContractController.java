package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.command.AreaCommand;
import com.ssid.api.apissid.command.ContractCommand;
import com.ssid.api.apissid.command.ProgramSsoCommand;
import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.services.ContractService;
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
public class ContractController {
    private ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @RequestMapping(value = ApiPath.CONTRACT_PATH, method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getAllContracts() {
        Map<String, Object> mapResponse = new HashMap<>();
        mapResponse.put("status", "ok");
        List<ContractCommand> contractList = new ArrayList<>();
        this.contractService.findAll().forEach(contract -> {
            contractList.add(new ContractCommand(contract));
        });
        mapResponse.put("data", contractList);
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @RequestMapping(value = ApiPath.CONTRACT_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveContract(@RequestBody ContractCommand contractCommand) {
        if (StringUtils.isEmpty(contractCommand.getId())) {
            this.contractService.saveContract(contractCommand.toContract());
        } else {
            // se busca el objeto existente
            Contract contract = this.contractService.findById(contractCommand.getId());
            contract.setCode(contractCommand.getCode());
            contract.setCity(contractCommand.getCity());
            contract.setDate(contractCommand.getDate());
            contract.setSalary(contractCommand.getSalary());
            contract.setDescription(contractCommand.getDescription());
            contract.setType(contractCommand.getType());
            this.contractService.saveContract(contract);
        }
    }

    @RequestMapping(value = ApiPath.CONTRACT_BY_CODE, method = RequestMethod.GET)
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
