package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.encog.ml.data.versatile.VersatileMLDataSet;
import org.encog.ml.data.versatile.sources.VersatileDataSource;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity(name = "Datasets")
public class UploadDataset extends VersatileMLDataSet implements Serializable{
    public UploadDataset(VersatileDataSource theSource) {
		super(theSource);
		// TODO Auto-generated constructor stub
	}
  

    @Id
    @org.hibernate.annotations.Type(type="pg-uuid")
    @GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
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

		/*
		 * file name for the user
		 * 
		 */
    private java.lang.String data_file; 
    
    
    @Lob
    //BinaryType
    @Type(type = "org.hibernate.type.SerializableToBlobType")
    private File dataset;

    
    public File getDataset() {
		return dataset;
	}

	public void setDataset(File dataset) {
		this.dataset = dataset;
	}

	public java.lang.String getData_file() {
        return data_file;
    }

    public void setData_file(java.lang.String data_file) {
        this.data_file = data_file;
    }

}
