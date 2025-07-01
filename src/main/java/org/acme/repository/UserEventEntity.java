package org.acme.repository;

import jakarta.persistence.*;

@Entity
@Table(name = "user_events")
public class UserEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String userId;
    public String action;
    public String timestamp;
}
