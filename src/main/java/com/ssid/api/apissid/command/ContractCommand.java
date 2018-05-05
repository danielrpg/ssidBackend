package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Contract;

import javax.persistence.Column;
import java.util.Date;



public class ContractCommand {
    private Long id;
    private String code;
    private String city;
    private String type;
    private Date date;
    private Double salary;
    private String description;

    public ContractCommand() {
    }
    public ContractCommand(Contract contract) {
        this.setId(contract.getId());
        this.setCode(contract.getCode());
        this.setCity(contract.getCity());
        this.setType(contract.getType());
        this.setDate(contract.getDate());
        this.setSalary(contract.getSalary());
        this.setDescription(contract.getDescription());
    }

    public Contract toContract() {
        Contract contract = new Contract();
        contract.setId(this.getId());
        contract.setCode(this.getCode());
        contract.setCity(this.getCity());
        contract.setType(this.getType());
        contract.setDate(this.getDate());
        contract.setSalary(this.getSalary());
        contract.setDescription(this.getDescription());

        return contract;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
