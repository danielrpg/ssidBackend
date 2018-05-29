package com.ssid.api.apissid.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class ModelBaseAudit implements Serializable {

//    @Column(columnDefinition = "VARCHAR(50) NOT NULL DEFAULT 'admin'")
    @Transient
    private String CreatedBy;

//    @Column(columnDefinition = "DATETIME NOT NULL DEFAULT GETDATE()")
    @Transient
    private Date CreatedDate;

//    @Column(columnDefinition = "VARCHAR(50) NOT NULL DEFAULT 'admin'")
    @Transient
    private String ModifiedBy;

//    @Column(columnDefinition = "DATETIME NOT NULL DEFAULT GETDATE()")
    @Transient
    private Date ModifiedDate;

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getModifiedBy() {
        return ModifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        ModifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }
}
