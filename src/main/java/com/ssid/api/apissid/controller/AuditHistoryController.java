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


    @RequestMapping( value = "/{date}/{date1}", method = RequestMethod.GET)
    public List<AuditHistory> getAuditHistory(@PathVariable String date, @PathVariable String date1){
        return this.spAuditHistoryService.getAuditHistory(date,date1);

    }
}