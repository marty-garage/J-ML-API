package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import ml_models.ML_Model;

import java.util.ArrayList;

/*
 * Model class extension with data usage additional info,
 * serialization of model associated/operated with/by instance of this.
 */
public class Usemodel<T extends ML_Model> extends ML_Model{
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String id;
    private ML_Model _model;

    private Usemodel(T model) {
    	_model = model;
    }
    
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

}
