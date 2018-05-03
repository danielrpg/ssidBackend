package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Contract;
import com.ssid.api.apissid.domain.Personal;
import com.ssid.api.apissid.domain.PersonalPositionContract;
import com.ssid.api.apissid.domain.Position;

import java.util.Date;

/**
 * @author Jesus David Piérola Alvarado
 */

public class PersonalPositionContractCommand {
    private Date initDate;
    private Date endDate;
    private String turno;
    private boolean status;
    private Long personalId;
    private String personalName;
    private Long positionId;
    private String positionName;
    private Long contractId;
    private String contractCode;

    public PersonalPositionContractCommand() {
    }

    public PersonalPositionContractCommand(PersonalPositionContract personalPositionContract) {
        setInitDate(personalPositionContract.getInitDate());
        setEndDate(personalPositionContract.getEndDate());
        setTurno(personalPositionContract.getTurno());
        setStatus(personalPositionContract.isStatus());
        setPersonalId(personalPositionContract.getPersonal().getId());
        setPersonalName(personalPositionContract.getPersonal().getName());
        setPositionId(personalPositionContract.getPosition().getId());
        setPositionName(personalPositionContract.getPosition().getName());
        setContractCode(personalPositionContract.getContract().getCode());
        setContractId(personalPositionContract.getContract().getId());
    }

    public PersonalPositionContract toPersonalPositionContract() {
        PersonalPositionContract personalPositionContract = new PersonalPositionContract();

        personalPositionContract.setInitDate(getInitDate());
        personalPositionContract.setEndDate(getEndDate());
        personalPositionContract.setTurno(getTurno());
        personalPositionContract.setStatus(isStatus());

        Personal personal = new Personal();
        personal.setId(getPersonalId());
        personalPositionContract.setPersonal(personal);

        Position position = new Position();
        position.setId(getPositionId());
        personalPositionContract.setPosition(position);

        Contract contract = new Contract();
        contract.setId(getContractId());
        personalPositionContract.setContract(contract);

        return personalPositionContract;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Long personalId) {
        this.personalId = personalId;
    }

    public String getPersonalName() {
        return personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
}
