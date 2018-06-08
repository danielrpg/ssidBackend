package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.AuditHistory;
import java.util.Date;

/**
 * @author Boris Medrano
 */

public class AuditHistoryCommand {

    private Long audit_id;
    private String tableName;
    private String columnName;
    private String ids;
    private String oldvalue;
    private String newvalue;
    private String modifiedBy;
    private Date date;
    private Date modifiedDate;

    public AuditHistoryCommand() {
    }

    public AuditHistoryCommand(AuditHistory auditHistory) {

        setAudit_id(auditHistory.getAudit_id());
        setTableName(auditHistory.getTableName());
        setColumnName(auditHistory.getColumnName());
        setIds(auditHistory.getIds());
        setOldvalue(auditHistory.getOldvalue());
        setNewvalue(auditHistory.getNewvalue());
        setModifiedBy(auditHistory.getModifiedBy());
        setDate(auditHistory.getDate());
        setModifiedDate(auditHistory.getModifiedDate());

    }

    public Long getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Long audit_id) {
        this.audit_id = audit_id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(String oldvalue) {
        this.oldvalue = oldvalue;
    }

    public String getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(String newvalue) {
        this.newvalue = newvalue;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
