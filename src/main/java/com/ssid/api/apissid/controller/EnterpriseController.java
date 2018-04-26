package com.ssid.api.apissid.controller;

import com.ssid.api.apissid.domain.Enterprise;
import com.ssid.api.apissid.services.EnterpriseService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
class EnterpriseController {
    private EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @GetMapping(path = ApiPath.ENTERPRISE_PATH)
    public List<Enterprise> getListEnterprises() {
        return this.enterpriseService.getEnterprise();
    }

    @RequestMapping(value = ApiPath.ENTERPRISE_PATH, method = RequestMethod.POST)
    public @ResponseBody
    void saveEnterprises(@RequestBody Enterprise enterprise) {
        this.enterpriseService.setEnterprise(enterprise);
    }
}
