package net.apispark.webapi.representation;

import com.fasterxml.jackson.annotation.JsonProperty;

import ml_models.ML_Model;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.encog.ml.model.EncogModel;
import org.encog.neural.neat.NEATNetwork;

/*
 * Model class extension with data usage additional info,
 * serialization of model associated/operated with/by instance of this.
 */
@Entity
@Table(name = "Usermodel")
public class Usemodel<T extends ML_Model, E>{
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    @Id
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID id;// = "890gje09";
    private T _model;

    public Usemodel(T model) {
    	_model = model;
    	System.out.println("private in usemodel:"+_model.toString());
    }
    
    public UUID getId() {
        return id;
    }
    
    @JsonProperty("_model")
    public String toString() {
        return _model.toString();
        //_model.get_model().toString() get the underlying 
        //EncogModel object used by the model class implementation (NEAT)
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

	public E Train() {
		// TODO Auto-generated method stub
		return (E) this._model.Train();
	}
	

}
