package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.sources.VersatileDataSource;


@Entity
@Table(name = "Datasets")
public class UploadDataset extends VersatileMLDataSet{
    public UploadDataset(VersatileDataSource theSource) {
		super(theSource);
		// TODO Auto-generated constructor stub
	}
  

    @Id
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID id;

    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
