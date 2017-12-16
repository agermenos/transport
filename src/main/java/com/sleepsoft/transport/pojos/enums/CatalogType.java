package com.sleepsoft.transport.pojos.enums;

public enum CatalogType {
    CONTACT_TYPE("contact_type"),
    TRANSPORT_TYPE("transport_type");
    private String definition;

    CatalogType(String definition){
        this.definition = definition;
    }

    public String definition(){
        return definition;
    }
}
