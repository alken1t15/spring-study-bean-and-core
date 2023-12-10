package org.example.listener.entity;

import java.util.EventObject;

public class EntityEvent extends EventObject {
    private final AccessType accessType;

    public EntityEvent(Object entiy, AccessType accessType) {
        super(entiy);
        this.accessType = accessType;
    }

    public AccessType getAccessType() {
        return accessType;
    }
}
