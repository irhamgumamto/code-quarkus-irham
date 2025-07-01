package org.acme.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class UserEvent {
    public String userId;
    public String action;
    public String timestamp;
}
