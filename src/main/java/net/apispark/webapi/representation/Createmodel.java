package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Createmodel {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;

    
    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }


    private java.lang.String model_spec;

    
    public java.lang.String getModel_spec() {
        return model_spec;
    }

    public void setModel_spec(java.lang.String model_spec) {
        this.model_spec = model_spec;
    }


    private java.lang.String createdAt;

    
    public java.lang.String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.lang.String createdAt) {
        this.createdAt = createdAt;
    }

}
