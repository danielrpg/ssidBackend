package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Equipament;
import com.ssid.api.apissid.command.ImageUtilsCommand;
import com.ssid.api.apissid.services.ImageUtils;

public class EquipamentCommand {
    private Long id;
    private String name;
    private String description;
    private Integer type;
    private String image;
    /*private Object[] kardexs;
    private Object[] inventories = new Object[0];*/

    public EquipamentCommand() {
    }

    public EquipamentCommand(Equipament equipament) {
        setId(equipament.getId());
        setName(equipament.getName());
        setDescription(equipament.getDescription());
        setType(equipament.getType());
        setImage("");
        //setImage(ImageUtilsCommand.setImageBase64(equipament.getImage()));
    }

    public Equipament toEquipament() {
        Equipament equipament = new Equipament();
        equipament.setId(getId());
        equipament.setName(getName());
        equipament.setDescription(getDescription());
        equipament.setType(getType());
        equipament.setImage(new Byte[0]);
        //equipament.setImage(ImageUtilsCommand.decodeToImage(getImage()));
        return equipament;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*public Object[] getKardexs() {
        return kardexs;
    }

    public void setKardexs(Object[] kardexs) {
        this.kardexs = kardexs;
    }

    public Object[] getInventories() {
        return inventories;
    }

    public void setInventories(Object[] inventories) {
        this.inventories = inventories;
    }*/
}
