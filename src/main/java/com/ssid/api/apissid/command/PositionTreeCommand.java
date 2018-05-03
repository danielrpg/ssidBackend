package com.ssid.api.apissid.command;

import com.ssid.api.apissid.domain.Position;

import java.util.ArrayList;

/**
 * @author Jesus David Piérola Alvarado
 */

public class PositionTreeCommand {
    private Long id;
    private String name;
    private ArrayList<PositionTreeCommand> children = new ArrayList<>();
    private boolean isExpanded;
    private Long parentId;

    public PositionTreeCommand() {
    }

    public PositionTreeCommand(Position position) {
        setId(position.getId());
        setName(position.getName());
        setExpanded(false);
        setChildren(null);

        if (position.getParentPosition() != null) {
            setParentId(position.getParentPosition().getId());
        } else {
            setParentId((long) 0);
        }
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

    public ArrayList<PositionTreeCommand> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<PositionTreeCommand> children) {
        this.children = children;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
