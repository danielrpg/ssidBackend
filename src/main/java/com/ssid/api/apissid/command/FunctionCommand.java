package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Area;
import com.ssid.api.apissid.domain.Function;

/**
 * @author Jesus David Piérola Alvarado
 */

public class FunctionCommand {
    private Long id;
    private String name;
    private String description;

    public FunctionCommand() {
    }

    public FunctionCommand(Function function) {
        setId(function.getId());
        setName(function.getName());
        setDescription(function.getDescription());
    }

    public Function toFunction() {
        Function function = new Function();

        function.setId(getId());
        function.setName(getName());
        function.setDescription(getDescription());

        return function;
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
}
