package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Error {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.String code;

    
    public java.lang.String getCode() {
        return code;
    }

    public void setCode(java.lang.String code) {
        this.code = code;
    }


    private java.lang.String description;

    
    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    private java.lang.String reasonPhrase;

    
    public java.lang.String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(java.lang.String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

}
