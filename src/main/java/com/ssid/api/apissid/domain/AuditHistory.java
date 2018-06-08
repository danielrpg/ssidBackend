package com.ssid.api.apissid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 */

@Entity
@Table(name = "audithistory")
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")*/
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_AuditHistoryAll",
                procedureName = "sp_AuditHistoryAll",
                resultClasses = AuditHistory.class),
        @NamedStoredProcedureQuery(
                name = "sp_AuditHistory",
                procedureName = "sp_AuditHistory",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "start_date", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "end_date", type = String.class)
                },
                resultClasses = AuditHistory.class
        )

})
public class AuditHistory implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long audit_id;

    @Column(name = "table_name", length = 100)
    private String tableName;

    @Column(name = "column_name", length = 100)
    private String columnName;

    @Column(name = "id", length = 100)
    private String ids;

    @Column(name = "old_value", length = 100)
    private String oldvalue;

    @Column(name = "new_value", length = 100)
    private String newvalue;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;

    @Column(name = "date")
    private Date date;

    @Column(name = "modified_date")
    private Date modifiedDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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