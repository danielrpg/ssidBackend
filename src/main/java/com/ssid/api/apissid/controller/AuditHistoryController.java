package com.ssid.api.apissid.controller;


import com.ssid.api.apissid.domain.AuditHistory;
import com.ssid.api.apissid.services.SPSerives.SPAuditHistoryService;
import com.ssid.api.apissid.util.ApiPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/**
 * @author Boris Medrano
 */
@RestController
@RequestMapping(value = ApiPath.AUDITHISTORY_PATH)
public class AuditHistoryController {


    private SPAuditHistoryService spAuditHistoryService;

    @Autowired
    public AuditHistoryController(SPAuditHistoryService spAuditHistoryService) {

        this.spAuditHistoryService = spAuditHistoryService;
    }


    @RequestMapping( value = {"", "/"}, method = RequestMethod.GET)
    public List<AuditHistory> getAllAuditHistory(){
        return this.spAuditHistoryService.getAllAuditHistory();
    }


    @RequestMapping( value = "/filter", method = RequestMethod.GET)
    public List<AuditHistory> getAuditHistory(@RequestParam String startDate, @RequestParam String endDate){
        return this.spAuditHistoryService.getAuditHistory(startDate, endDate);

    }
}