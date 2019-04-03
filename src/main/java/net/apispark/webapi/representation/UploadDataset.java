package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class UploadDataset {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;

    
    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }


    private java.lang.String createdAt;

    
    public java.lang.String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.lang.String createdAt) {
        this.createdAt = createdAt;
    }


    private java.lang.String data_file;

    
    public java.lang.String getData_file() {
        return data_file;
    }

    public void setData_file(java.lang.String data_file) {
        this.data_file = data_file;
    }

}
