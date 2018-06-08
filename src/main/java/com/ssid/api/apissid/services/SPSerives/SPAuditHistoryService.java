package com.ssid.api.apissid.services.SPSerives;

import com.ssid.api.apissid.domain.AuditHistory;


import java.util.List;

public interface SPAuditHistoryService {

    List<AuditHistory> getAllAuditHistory();
    List<AuditHistory> getAuditHistory(String date, String date1);


}
