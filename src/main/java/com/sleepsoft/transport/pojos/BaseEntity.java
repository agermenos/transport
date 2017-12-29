package com.sleepsoft.transport.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sleepsoft.transport.util.UUIDUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @Column(nullable = false)
    protected String id;

    @Column(name = "tenant_id", nullable = false, updatable = false)
    @JsonIgnore
    protected String tenantId;

    @Transient
    // explicit get/set methods with JsonIgnore are needed otherwise jackson doesn't ignore them
    protected boolean isNew = true; // need this as getId() == null can not be used for the check as it is conventionally.

    public BaseEntity() {
        id = UUIDUtils.uuidString();
    }

}
